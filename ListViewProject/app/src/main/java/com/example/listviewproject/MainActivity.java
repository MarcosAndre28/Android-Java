package com.example.listviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private  String[] locations = { "Angra dos Reis", "Caldas Novas", "Campos do Jordão", "Costa do Sauípe", "Ilhéus", "Porto Seguro" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        // Criar uma adptador para o List View(Recomendado separar essa parte do codigo principal)
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(
                getApplicationContext(), android.R.layout.simple_list_item_1,android.R.id.text1,locations
        );

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((adapterView, view, position, l) -> {
            String selectValue = listView.getItemAtPosition(position).toString();
            Toast.makeText(MainActivity.this, selectValue, Toast.LENGTH_SHORT).show();
        });
    }
}