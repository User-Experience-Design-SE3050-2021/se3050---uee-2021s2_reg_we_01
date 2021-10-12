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

import java.util.List;



public class FixDepositInterestAdapter extends RecyclerView.Adapter<FixDepositInterestAdapter.FixDepositInterestViewHolder> {

    private List<FixDepositInterest> listData;
    private Context context;


    public FixDepositInterestAdapter(List<FixDepositInterest> listData, Context context) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public FixDepositInterestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.single_fix_deposite_rate_layout, parent, false);
        FixDepositInterestViewHolder fixDepositInterestViewHolder = new FixDepositInterestViewHolder(listItem);

        return fixDepositInterestViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FixDepositInterestViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView_1.setText((listData.get(position).getName()));


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class FixDepositInterestViewHolder extends RecyclerView.ViewHolder {

        public TextView textView_1;
        public LinearLayout linearLayout;
        public CardView cardView;

        public FixDepositInterestViewHolder(View itemView) {

            super(itemView);
            this.textView_1 = (TextView) itemView.findViewById(R.id.fixed_deposit_name);


            cardView = itemView.findViewById(R.id.single_fix_deposit_rate_item);

        }
    }
}