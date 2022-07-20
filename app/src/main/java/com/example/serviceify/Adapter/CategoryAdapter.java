package com.example.serviceify.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.serviceify.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context context;
    private CategoryClickInterface categoryClickInterface;
    public CategoryAdapter(Context context,CategoryClickInterface categoryClickInterface) {
        this.context=context;
        this.categoryClickInterface=categoryClickInterface;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.category_cardview,parent,false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.text.setText("Hoooooo");
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryClickInterface.onClickCategory(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_icon);
            text=itemView.findViewById(R.id.text_card);

        }
    }

    public interface CategoryClickInterface{
        public void onClickCategory(int position);
    }
}
