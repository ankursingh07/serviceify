package com.example.serviceify.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.serviceify.Adapter.ServiceImageAdapter;
import com.example.serviceify.Adapter.ServiceReviewAdapter;
import com.example.serviceify.R;

public class ServiceScreen extends AppCompatActivity {

    RecyclerView recyclerViewReview,recyclerViewImage;
    RecyclerView.Adapter adapterReview,adapterImage;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_screen);
        getSupportActionBar().hide();

        recyclerViewReview =findViewById(R.id.service_screen_reviews_recycler_view);
        recyclerViewImage=findViewById(R.id.service_screen_image_recycler_view);

        adapterReview =new ServiceReviewAdapter(this);
        adapterImage=new ServiceImageAdapter(this);

        LinearLayoutManager linearLayoutManagerImage=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManagerReview=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerViewImage.setAdapter(adapterImage);
        recyclerViewImage.setLayoutManager(linearLayoutManagerImage);
        recyclerViewReview.setAdapter(adapterReview);
        recyclerViewReview.setLayoutManager(linearLayoutManagerReview);

        description=findViewById(R.id.service_screen_description);
        description.setText(
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                        "\n" +
                        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham."
        );

    }
}