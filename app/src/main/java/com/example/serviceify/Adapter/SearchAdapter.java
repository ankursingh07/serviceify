package com.example.serviceify.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.serviceify.R;

import java.util.ArrayList;

import Models.ServiceModel;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private Context context;
    private ClickServiceCard clickServiceCard;
    private ArrayList<ServiceModel> serviceModelArrayList;
//    public SearchAdapter(Context context,ClickServiceCard clickServiceCard) {
//        this.context = context;
//        this.clickServiceCard=clickServiceCard;
//    }

    public SearchAdapter(Context context, ClickServiceCard clickServiceCard, ArrayList<ServiceModel> serviceModelArrayList) {
        this.context = context;
        this.clickServiceCard = clickServiceCard;
        this.serviceModelArrayList = serviceModelArrayList;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.search_category_cardview,parent,false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.address.setText(serviceModelArrayList.get(position).getAddress());
        holder.price.setText(serviceModelArrayList.get(position).getPrice());
        holder.title.setText(serviceModelArrayList.get(position).getTitle());
        holder.availability.setText(serviceModelArrayList.get(position).getAvailability());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickServiceCard.onClickServiceCard(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return serviceModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,address,availability,price;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            title=itemView.findViewById(R.id.card_service_title);
            address=itemView.findViewById(R.id.card_service_address);
            availability=itemView.findViewById(R.id.card_service_availability);
            price=itemView.findViewById(R.id.card_service_cost);
        }
    }

    public interface ClickServiceCard{
        public void onClickServiceCard(int position);
    }
}
