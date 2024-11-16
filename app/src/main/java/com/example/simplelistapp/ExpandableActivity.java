package com.example.simplelistapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        ExpandableListView expandableListView = findViewById(R.id.expandable_list_view);
        Button buttonCustom = findViewById(R.id.button_custom);

        // Data
        List<String> groupList = new ArrayList<>();
        groupList.add("Fruits");
        groupList.add("Vegetables");
        groupList.add("Dairy");

        HashMap<String, List<String>> childMap = new HashMap<>();
        childMap.put("Fruits", List.of("Apple", "Banana", "Cherry"));
        childMap.put("Vegetables", List.of("Carrot", "Broccoli", "Spinach"));
        childMap.put("Dairy", List.of("Milk", "Cheese", "Yogurt"));

        // Group images
        List<Integer> groupImages = new ArrayList<>();
        groupImages.add(R.drawable.fruits);
        groupImages.add(R.drawable.vegetable);
        groupImages.add(R.drawable.dairy);

        // Set adapter
        CustomExpandableListAdapter adapter = new CustomExpandableListAdapter(this, groupList, childMap, groupImages);
        expandableListView.setAdapter(adapter);
        // Button to navigate back
        buttonCustom.setOnClickListener(v -> {
            Intent intent = new Intent(ExpandableActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
