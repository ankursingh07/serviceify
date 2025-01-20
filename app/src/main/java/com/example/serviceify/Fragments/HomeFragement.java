package com.example.serviceify.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.serviceify.R;

import com.example.serviceify.Adapter.CategoryAdapter;


public class HomeFragement extends Fragment implements CategoryAdapter.CategoryClickInterface {
    RecyclerView recyclerView;
    Context context;
    CategoryAdapter categoryAdapter;
    RecyclerView.Adapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=(RelativeLayout)inflater.inflate(R.layout.fragment_home_fragement,container,false);
        recyclerView=v.findViewById(R.id.home_customer_categories);
        context=getContext();
        adapter=new CategoryAdapter(context,this::onClickCategory);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onClickCategory(int position) {
        Fragment fragment;
        FragmentManager fragmentManager=getParentFragmentManager();
        fragment=new SearchResultFragment();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.frag_container,fragment);
        fragmentTransaction.replace(R.id.frag_container,fragment);
        fragmentTransaction.addToBackStack("main");
        fragmentTransaction.commit();

    }
}