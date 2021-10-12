package com.alpha.peoplesbank.fragment.rates;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alpha.peoplesbank.R;
import com.alpha.peoplesbank.adapters.FixDepositInterestAdapter;
import com.alpha.peoplesbank.model.FixDepositInterest;

import java.util.ArrayList;
import java.util.List;

public class FixDepositRate extends Fragment {
private View view;
private List<FixDepositInterest>fixDepositInterestList = new ArrayList<>();
private FixDepositInterestAdapter fixDepositInterestAdapter;
private RecyclerView recyclerView;

    public FixDepositRate() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fixDepositInterestList.clear();
        fixDepositInterestList.add(new FixDepositInterest("Fixed Deposit Normal"));
        fixDepositInterestList.add(new FixDepositInterest("Fixed Deposit Normal Monthly Interest"));
        fixDepositInterestList.add(new FixDepositInterest("Fixed Deposit Parinatha and Maturity"));
        fixDepositInterestList.add(new FixDepositInterest("Fixed Deposit Parinatha and Maturity Interest"));
        fixDepositInterestList.add(new FixDepositInterest("Fixed Deposit Parinatha over 60 Int-Monthly"));
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_fix_deposit_rate, container, false);
        recyclerView = view.findViewById(R.id.rate_fix_deposit_recyclerView);

        fixDepositInterestAdapter = new FixDepositInterestAdapter(fixDepositInterestList, getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(fixDepositInterestAdapter);
        return view;
    }
}