package com.example.recyclerview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.RecyclerItemClickListener;
import com.example.recyclerview.adpter.Adapter;
import com.example.recyclerview.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Lista de Filmes
        createMovies();

        // Configurar adpter
        Adapter adapter = new Adapter(movieList);


        // Tamnho fixo da rc para otmização
        recyclerView.setHasFixedSize(true);

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        // Evento de click
        recyclerView.addOnItemTouchListener(

               new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                   @Override
                   public void onItemClick(View view, int position) {
                       Movie movie = movieList.get(position);
                       Toast.makeText(getApplicationContext(), movie.getTitle(), Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onLongItemClick(View view, int position) {
                       Movie movie = movieList.get(position);
                       Toast.makeText(getApplicationContext(), "ClickLong " + movie.getTitle(), Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                   }
               })

        );
    }

    public void createMovies(){

        Movie movie = new Movie("Homem Aranha - De Volta ao lar","Aventura","2017");
        movieList.add(movie);

        movie = new Movie("It: A Coisa","Drama/Terror","2017");
        movieList.add(movie);

        movie = new Movie("Mulher Maravilha","Fantasia","2017");
        movieList.add(movie);

        movie = new Movie("Liga da Justiça","Ficção","2017");
        movieList.add(movie);
    }

}