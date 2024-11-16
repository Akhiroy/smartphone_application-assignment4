package com.example.simplelistapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.custom_list_view);
        Button buttonExpandable = findViewById(R.id.button_expandable);

        // Data for the Custom ListView
        String[] items = {"Fruits", "Vegetables", "Oil", "Dairy", "Meat"};

        // ArrayAdapter to connect data with the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_list, R.id.item_text, items);
        listView.setAdapter(adapter);

        // Navigate to ExpandableActivity on button click
        buttonExpandable.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ExpandableActivity.class);
            startActivity(intent);
        });
    }
}
