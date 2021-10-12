package com.alpha.peoplesbank.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.peoplesbank.R;
import com.alpha.peoplesbank.model.FixDepositInterest;
import com.alpha.peoplesbank.model.Savings;

import java.util.List;


public class SavingAdapter extends RecyclerView.Adapter<SavingAdapter.SavingViewHolder> {

    private List<Savings> listData;
    private Context context;


    public SavingAdapter(List<Savings> listData, Context context) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public SavingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.single_saving_rate_item_layout, parent, false);
        SavingViewHolder savingViewHolder = new SavingViewHolder(listItem);

        return savingViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SavingViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView_1.setText((listData.get(position).getName()));
        holder.textView_2.setText((listData.get(position).getRate()));


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class SavingViewHolder extends RecyclerView.ViewHolder {

        public TextView textView_1,textView_2;
        public LinearLayout linearLayout;
        public CardView cardView;

        public SavingViewHolder(View itemView) {

            super(itemView);
            this.textView_1 = (TextView) itemView.findViewById(R.id.saving_product_name);
            this.textView_2 = (TextView) itemView.findViewById(R.id.saving_interest_rate);


            cardView = itemView.findViewById(R.id.single_saving_rate_item);

        }
    }
}