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
import com.alpha.peoplesbank.model.ChequeStatus;

import java.util.List;

public class ChequeHistoryAdapter extends RecyclerView.Adapter<ChequeHistoryAdapter.ChequeHistoryViewHolder> {

    private List<ChequeStatus> listData;
    private Context context;


    public ChequeHistoryAdapter(List<ChequeStatus> listData, Context context) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ChequeHistoryAdapter.ChequeHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.single_cheque_status_layout, parent, false);
        ChequeHistoryViewHolder chequeHistoryViewHolder = new ChequeHistoryViewHolder(listItem);

        return chequeHistoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChequeHistoryAdapter.ChequeHistoryViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView_1.setText((listData.get(position).getName()));
        holder.textView_2.setText(listData.get(position).getDate());
        holder.textView_3.setText(listData.get(position).getAmount());
        if(listData.get(position).getStatus()==1){
            holder.redArrow.setVisibility(View.GONE);
            holder.textView_3.setTextColor(Color.parseColor("#228B22"));
        }else {
            holder.greenArrow.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ChequeHistoryViewHolder extends RecyclerView.ViewHolder {

        public TextView textView_1, textView_2, textView_3;
        public ImageView redArrow,greenArrow;
        public LinearLayout linearLayout;
        public CardView cardView;

        public ChequeHistoryViewHolder(View itemView) {

            super(itemView);
            this.textView_1 = (TextView) itemView.findViewById(R.id.cheque_number);
            this.textView_2 = (TextView) itemView.findViewById(R.id.cheque_date);
            this.textView_3 = (TextView) itemView.findViewById(R.id.cheque_amount);
            this.redArrow = (ImageView) itemView.findViewById(R.id.cheque_red_arrow);
            this.greenArrow = (ImageView)itemView.findViewById(R.id.cheque_green_arrow);

            cardView = itemView.findViewById(R.id.single_cheque_status_item);

        }
    }
}