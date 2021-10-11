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
import com.alpha.peoplesbank.model.BillPayment;
import java.util.List;


public class BillPaymentHistoryAdapter extends RecyclerView.Adapter<BillPaymentHistoryAdapter.BillPaymentHistoryViewHolder> {

    private List<BillPayment> listData;
    private Context context;


    public BillPaymentHistoryAdapter(List<BillPayment> listData, Context context) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public BillPaymentHistoryAdapter.BillPaymentHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.single_bill_payment_history_item, parent, false);
        BillPaymentHistoryViewHolder billPaymentHistoryViewHolder = new BillPaymentHistoryViewHolder(listItem);

        return billPaymentHistoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BillPaymentHistoryAdapter.BillPaymentHistoryViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView_1.setText((listData.get(position).getName()));
        holder.textView_2.setText(listData.get(position).getDate());
        holder.textView_3.setText(listData.get(position).getAmount());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class BillPaymentHistoryViewHolder extends RecyclerView.ViewHolder {

        public TextView textView_1, textView_2, textView_3;
        public LinearLayout linearLayout;
        public CardView cardView;

        public BillPaymentHistoryViewHolder(View itemView) {

            super(itemView);
            this.textView_1 = (TextView) itemView.findViewById(R.id.history_bill_payment_name);
            this.textView_2 = (TextView) itemView.findViewById(R.id.history_bill_payment_date);
            this.textView_3 = (TextView) itemView.findViewById(R.id.history_bill_payment_amount);

            cardView = itemView.findViewById(R.id.single_bill_payment_item);

        }
    }
}