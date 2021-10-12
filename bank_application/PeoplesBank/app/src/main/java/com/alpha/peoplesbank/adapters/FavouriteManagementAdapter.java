package com.alpha.peoplesbank.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.peoplesbank.R;
import com.alpha.peoplesbank.model.TransactionHistory;

import java.util.List;

public class FavouriteManagementAdapter extends RecyclerView.Adapter<FavouriteManagementAdapter.FavouriteViewHolder>{
    private List<TransactionHistory> listData;
    private Context context;


    public FavouriteManagementAdapter(List<TransactionHistory> listData, Context context) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public FavouriteManagementAdapter.FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.fav_management_item, parent, false);
        FavouriteManagementAdapter.FavouriteViewHolder favouriteViewHolder = new FavouriteManagementAdapter.FavouriteViewHolder(listItem);

        return favouriteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteManagementAdapter.FavouriteViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.tv_acc_name_fav1.setText((listData.get(position).getName()));

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class FavouriteViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_acc_name_fav1, tv_acc_name_fav2, tv_acc_name_fav3;
        public LinearLayout linearLayout;
        public ImageView redArrow,greenArrow;
        public CardView cardView1;

        public FavouriteViewHolder(View itemView) {

            super(itemView);
            this.tv_acc_name_fav1 = (TextView) itemView.findViewById(R.id.tv_acc_name_fav1);
            this.tv_acc_name_fav2 = (TextView) itemView.findViewById(R.id.tv_acc_name_fav2);
            this.tv_acc_name_fav3 = (TextView) itemView.findViewById(R.id.tv_acc_name_fav3);


            cardView1= itemView.findViewById(R.id.card1);

        }
    }
}

