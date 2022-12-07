package com.example.cardview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cardview.R;
import com.example.cardview.adpter.Adapter;
import com.example.cardview.model.Post;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        // Define adapter
        setPosts();
        Adapter adapter = new Adapter(posts);
        recyclerView.setAdapter(adapter);
    }

    public void setPosts() {
        Post post = new Post("Marcos", "#TBT Viagem Legal!", R.drawable.imagem1);
        posts.add(post);

        post = new Post("André", "#TBT Viagem Legal!", R.drawable.imagem2);
        posts.add(post);

        post = new Post("Santos", "#TBT Viagem Legal!", R.drawable.imagem3);
        posts.add(post);

        post = new Post("Marquinhos", "#TBT Viagem Legal!", R.drawable.imagem4);
        posts.add(post);



    }

}