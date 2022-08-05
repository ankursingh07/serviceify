package com.example.serviceify.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.serviceify.Activities.HomeCustomer;
import com.example.serviceify.Activities.Login;
import com.example.serviceify.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;

import java.util.concurrent.Executor;

import Models.Customer;
import Service.Auth;
import Service.FetchService;
import Service.ToastService;


public class ProfileFragment extends Fragment {

    Auth auth;
    ImageView logout,profileImage;
    TextView email,name,address,phone;
    Customer customer=new Customer();
    FetchService fetchService;
    HomeCustomer homeCustomer=new HomeCustomer();
    ToastService toastService=new ToastService();
    public final FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
    final String customerDetailCollection="CustomerDetails";
    public DocumentReference documentReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=(RelativeLayout)inflater.inflate(R.layout.fragment_profile_fragment, container, false);

        auth=new Auth();

        auth.firebaseAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null){
                    changeActivity();
                }
            }
        });



        email=v.findViewById(R.id.customer_email);
        name=v.findViewById(R.id.customer_user_name);
        address=v.findViewById(R.id.customer_address);
        phone=v.findViewById(R.id.customer_phone);
        profileImage=v.findViewById(R.id.customer_profile_photo);
        logout=v.findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut(getContext());
            }
        });

        fetchCustomerDetails();
        setUserDetails();
        return v;
    }

    void changeActivity(){
        Intent intent=new Intent(getActivity(),Login.class);
        startActivity(intent);
        getActivity().finish();
    }




    public void setUserDetails(){
//        if(customer!=null){

            email.setText(customer.email);
            name.setText(customer.name);
            address.setText(customer.address);
            phone.setText(customer.phoneNumber);
        //}

    }

        public void fetchCustomerDetails(){
            documentReference=firebaseFirestore.collection(customerDetailCollection).document(auth.currentUser().getUid().toString());
            documentReference.get(Source.CACHE).addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()){
                        System.out.println("Success");
                        System.out.println(task.getResult().get("name").toString());
                        name.setText(task.getResult().get("name").toString());
                        address.setText(task.getResult().get("Address").toString());
                        phone.setText(task.getResult().get("phone number").toString());
                        email.setText(task.getResult().get("email").toString());

//                        customer.setName(task.getResult().get("name").toString());
//                        customer.setAddress(task.getResult().get("Address").toString());
//                        customer.setPhoneNumber(task.getResult().get("phone number").toString());
//                        customer.setEmail(task.getResult().get("email").toString());
//                        customer.setProfileUrl(task.getResult().get("profile photo").toString());
                    }
                    else{

                    }
                }

            });
    }
}