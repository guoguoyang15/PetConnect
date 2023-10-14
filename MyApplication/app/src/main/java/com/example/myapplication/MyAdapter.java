package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity activity;
    private List<Pet> petList;
    public MyAdapter(List<Pet> list){
        petList = list;
    }
    public MyAdapter(Activity activity, List<Pet> list){
        this.activity = activity;
        petList = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        RecyclerView.ViewHolder vh=new RecyclerView.ViewHolder(view) {};
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Pet item = petList.get(position);
        TextView name=holder.itemView.findViewById(R.id.textView);
        name.setText(item.name);
        //TextView type=holder.itemView.findViewById(R.id.textView2);
        //type.setText(petList.get(position+1).name);

        ImageView imageView=holder.itemView.findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity.getApplicationContext(), DetailActivity.class);
                intent.putExtra("pet",item);
                activity.startActivity(intent);
            }
        });
        //Glide.with(imageView.getContext()).load(petList.get(position).url).into(imageView);
    }

    @Override
    public int getItemCount() {
        return petList.size();
    }
}
