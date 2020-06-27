package com.example.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<ImageUrl> imageUrl;
    private Context context;
    DataTransferInterface dataTransferInterface;


    public DataAdapter(Context context,ArrayList<ImageUrl>imageUrl,DataTransferInterface dataTransfer){
        this.context=context;
        this.imageUrl=imageUrl;
        this.dataTransferInterface=dataTransfer;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Glide.with(context).load(imageUrl.get(position).getImageUrl()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return imageUrl.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv_title ;
        TextView tv_overview ;
        TextView tv_release ;
        ImageView img_backdrop;
        private LinearLayout viewContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            viewContainer = itemView.findViewById(R.id.container);
            img = itemView.findViewById(R.id.imageView);
            tv_title = itemView.findViewById(R.id.title);
            tv_overview = itemView.findViewById(R.id.overview);
            tv_release = itemView.findViewById(R.id.release);
            img_backdrop = itemView.findViewById(R.id.backdrop);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataTransferInterface.movieClick(imageUrl.get(getAdapterPosition()),img);

                }
            });

        }
    }
}

