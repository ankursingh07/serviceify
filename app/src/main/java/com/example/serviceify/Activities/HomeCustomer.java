package com.example.serviceify.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager.OnBackStackChangedListener;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.serviceify.Fragments.HomeFragement;
import com.example.serviceify.R;
import com.example.serviceify.Fragments.ProfileFragment;
import com.example.serviceify.Fragments.SearchResultFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeCustomer extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {


    FrameLayout frameLayout;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String Username="";
    Intent intent;
    int i=0;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_customer);
        bottomNavigationView=findViewById(R.id.customer_navigation);
        fragment=new HomeFragement();
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_container,fragment);
        fragmentTransaction.commit();

        bottomNavigationView.setOnItemSelectedListener(this);

        fragmentManager.addOnBackStackChangedListener(new OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                FragmentManager fragmentManager1=getSupportFragmentManager();
                Fragment fragment1=fragmentManager1.findFragmentById(R.id.frag_container);
                if(fragment1 instanceof HomeFragement){
                    bottomNavigationView.getMenu().findItem(R.id.home_nav).setChecked(true);
                }
                else if(fragment1 instanceof SearchResultFragment){
                    bottomNavigationView.getMenu().findItem(R.id.home_nav).setChecked(true);
                }
                else if(fragment1 instanceof SearchResultFragment){
                    bottomNavigationView.getMenu().findItem(R.id.home_nav).setChecked(true);
                }
                else if(fragment1 instanceof SearchResultFragment){
                    bottomNavigationView.getMenu().findItem(R.id.home_nav).setChecked(true);
                }
                else if(fragment1 instanceof SearchResultFragment){
                    bottomNavigationView.getMenu().findItem(R.id.home_nav).setChecked(true);
                }
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==bottomNavigationView.getSelectedItemId()){
            return false;
        }
        switch (item.getItemId()){
            case R.id.home_nav:fragment=new HomeFragement();
                    break;
            case R.id.help_nav:
                Toast.makeText(getApplicationContext(),"Help",Toast.LENGTH_LONG).show();
                    break;
            case R.id.person_nav:fragment=new ProfileFragment();
                    break;
        }
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        Bundle bundle=new Bundle();
        fragmentTransaction.replace(R.id.frag_container,fragment);
        fragmentTransaction.addToBackStack("main");
        i++;
        fragmentTransaction.commit();
        return true;
    }
}