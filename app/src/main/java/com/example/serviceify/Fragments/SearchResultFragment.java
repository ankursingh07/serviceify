package com.example.serviceify.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.serviceify.R;

import com.example.serviceify.Activities.ServiceScreen;
import com.example.serviceify.Adapter.SearchAdapter;

public class SearchResultFragment extends Fragment implements SearchAdapter.ClickServiceCard {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Context context;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=(RelativeLayout)inflater.inflate(R.layout.fragment_search_result, container, false);
        context=getContext();
        adapter= new SearchAdapter(context,this::onClickServiceCard);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView=view.findViewById(R.id.search_customer_categories);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }

    @Override
    public void onClickServiceCard(int position) {
        Intent intent;
        intent=new Intent(context, ServiceScreen.class);
        startActivity(intent);
    }
}