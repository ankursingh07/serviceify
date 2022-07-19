package Fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.serviceify.R;

import Adapter.SearchAdapter;

public class SearchResultFragment extends Fragment {

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
        adapter= new SearchAdapter(context);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView=view.findViewById(R.id.search_customer_categories);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        view.requestFocus();
        view.setFocusableInTouchMode(true);
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i==KeyEvent.KEYCODE_BACK && keyEvent.getAction()==KeyEvent.ACTION_DOWN ){
                    System.out.println("back pressed");
                   fragment=new HomeFragement();
                   fragmentManager=getParentFragmentManager();
                   fragmentTransaction=fragmentManager.beginTransaction();
                   fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                   fragmentTransaction.commit();
                   return  true;
                }
                return false;
            }
        });

        return view;
    }

}