package com.alpha.peoplesbank.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.peoplesbank.MainActivity;
import com.alpha.peoplesbank.R;
import com.alpha.peoplesbank.fragment.TransactionFragment;
import com.alpha.peoplesbank.interfaces.OnClickInterface;
import com.alpha.peoplesbank.model.ItemAccountList;

import java.util.List;


//import com.yarolegovich.discretescrollview.sample.R;

/**
 * Created by dhanushka.
 */

public class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.ViewHolder> {

    private List<ItemAccountList> data;
    static Context context;
    static Activity activity;
    OnClickInterface onClickInterface;


    public AccountListAdapter(List<ItemAccountList> data, OnClickInterface onClickInterface, Context context, Activity activity) {
        this.data = data;
        this.context = context;
        this.activity = activity;
        this.onClickInterface = onClickInterface;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.accountl_list_item, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ItemAccountList item = data.get(position);

        final int id = item.id;
        final String name = item.name;



        holder.AccountName.setText(name);

        holder.CVmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickInterface.setValues(item.CardNumber);
            }
        });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView CVmain;
        private ProgressBar progressBar, progressBar1;
        ConstraintLayout clMain;
        TextView AccountName;
        ImageView ivAccountImg;
        private Handler handler = new Handler();

        public ViewHolder(View itemView) {
            super(itemView);

            CVmain = itemView.findViewById(R.id.CV_main);
            AccountName = itemView.findViewById(R.id.tv_acc_name);
            ivAccountImg = itemView.findViewById(R.id.iv_acc_img);



           // ArrayList NoOfEmp = new ArrayList();


//            CardView.LayoutParams layoutParams = new CardView.LayoutParams((int) (Utill.getDeviceScreenWidth(context)*(0.6)), (int) (Utill.getDeviceScreenHeight(context)*0.5));
//            CVmain.setLayoutParams(layoutParams);

        }
    }








}
