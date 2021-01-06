package com.search.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.search.search.adapter.ExampleAdapter;
import com.search.search.model.ExampleItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    private ExampleAdapter adapter;
    private List<ExampleItem> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onSearchRequested();
        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setIconified(false);
        initialiseSearchListener();
        fillExampleList();
        setUpRecyclerView();
    }

    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(android.R.drawable.ic_menu_report_image, "One", "Ten"));
        exampleList.add(new ExampleItem(android.R.drawable.ic_menu_report_image, "Two", "Eleven"));
        exampleList.add(new ExampleItem(android.R.drawable.ic_menu_report_image, "Three", "Twelve"));
        exampleList.add(new ExampleItem(android.R.drawable.ic_menu_report_image, "Four", "Thirteen"));
        exampleList.add(new ExampleItem(android.R.drawable.ic_menu_report_image, "Five", "Fourteen"));
        exampleList.add(new ExampleItem(android.R.drawable.ic_menu_report_image, "Six", "Fifteen"));
        exampleList.add(new ExampleItem(android.R.drawable.ic_menu_report_image, "Seven", "Sixteen"));
        exampleList.add(new ExampleItem(android.R.drawable.ic_menu_report_image, "Eight", "Seventeen"));
        exampleList.add(new ExampleItem(android.R.drawable.ic_menu_report_image, "Nine", "Eighteen"));
    }
    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initialiseSearchListener() {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Toast.makeText(MainActivity.this, "Search Query Submit " + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                Toast.makeText(MainActivity.this, "Search Query "  + newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}