package com.example.serviceify.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.serviceify.R;

import com.example.serviceify.Activities.ServiceScreen;
import com.example.serviceify.Adapter.SearchAdapter;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import Models.ServiceModel;

public class SearchResultFragment extends Fragment implements SearchAdapter.ClickServiceCard {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Context context;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    public final FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
    final String customerDetailCollection="CustomerDetails";
    final String serviceDetailCollection="ServiceDetails";
    CollectionReference collectionReference;
    public DocumentReference documentReference;
    ServiceModel serviceModel=new ServiceModel();
    ArrayList<ServiceModel> serviceModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        serviceModelArrayList=new ArrayList<ServiceModel>();
        View view=(RelativeLayout)inflater.inflate(R.layout.fragment_search_result, container, false);
        context=getContext();
        adapter= new SearchAdapter(context,this::onClickServiceCard,serviceModelArrayList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView=view.findViewById(R.id.search_customer_categories);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        fetchServices();
        return view;
    }

    @Override
    public void onClickServiceCard(int position) {
        Intent intent;
        intent=new Intent(context, ServiceScreen.class);
        ServiceModel serviceModel=new ServiceModel();
                serviceModel=serviceModelArrayList.get(position);
        intent.putExtra("model_class", serviceModel);
        startActivity(intent);
    }

    void fetchServices(){
        collectionReference=firebaseFirestore.collection(serviceDetailCollection);
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for (DocumentSnapshot documentSnapshot:value.getDocuments()){
                    serviceModel=documentSnapshot.toObject(ServiceModel.class);
                    //serviceModel.setAddress(documentSnapshot.get("address").toString());
                    serviceModelArrayList.add(serviceModel);
                }
                adapter.notifyDataSetChanged();
            }

        });
    }
}