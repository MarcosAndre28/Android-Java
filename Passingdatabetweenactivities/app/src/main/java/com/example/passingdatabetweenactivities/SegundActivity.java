package com.example.passingdatabetweenactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
// Permite a conversão do objeto usuario em bytes
public class SegundActivity extends AppCompatActivity {

    TextView tvName, tvYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segund);

        tvName = findViewById(R.id.tv_name);
        tvYear = findViewById(R.id.tv_year);

        // Pegando dados da intent(Activity antarior)
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int year = bundle.getInt("year");
        User user = (User) bundle.getSerializable("objeto");

        // Configurar os valores
        tvName.setText(user.getEmail());
        tvYear.setText(String.valueOf(year));
    }
}