package com.example.serviceify.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.serviceify.R;

public class ServiceImageAdapter extends RecyclerView.Adapter<ServiceImageAdapter.ViewHolder> {
    Context context;

    public ServiceImageAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ServiceImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.service_image_card,parent,false);
        return new ServiceImageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceImageAdapter.ViewHolder holder, int position) {

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
