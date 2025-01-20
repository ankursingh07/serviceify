package com.example.serviceify.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.serviceify.R;

public class ServiceReviewAdapter extends RecyclerView.Adapter<ServiceReviewAdapter.ViewHolder> {
    Context context;

    public ServiceReviewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ServiceReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.service_reviews_card,parent,false);
        return new ServiceReviewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
