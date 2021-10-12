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
import com.alpha.peoplesbank.adapters.SavingAdapter;
import com.alpha.peoplesbank.model.Savings;

import java.util.ArrayList;
import java.util.List;

public class SavingsInterestRate extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private SavingAdapter savingAdapter;
    private List<Savings> savingsList = new ArrayList<>();

    public SavingsInterestRate() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        savingsList.add(new Savings("parinatha","5.0"));
        savingsList.add(new Savings("sisu Udana","4.5"));
        savingsList.add(new Savings("yes Saving","5.0"));
        savingsList.add(new Savings("sisu Udana","4.5"));

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_savings_interest_rate, container, false);
        recyclerView = view.findViewById(R.id.saving_rates_recyclerView);

        savingAdapter = new SavingAdapter(savingsList, getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(savingAdapter);
        return view;
    }
}