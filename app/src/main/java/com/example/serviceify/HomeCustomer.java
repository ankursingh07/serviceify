package com.example.serviceify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class HomeCustomer extends AppCompatActivity {

    CategoryAdapter categoryAdapter;
    RecyclerView.Adapter adapter;
   // RecyclerView recyclerView;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_customer);
        recyclerView=findViewById(R.id.home_customer_categories);
        adapter=new CategoryAdapter(this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }
}