package com.alpha.peoplesbank.fragment.rates;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alpha.peoplesbank.R;



public class BankRates extends Fragment {

    private LinearLayout linearLayout;
    private View view;
    public BankRates() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_bank_rates, container, false);
        linearLayout = view.findViewById(R.id.navigate_interest_rate);
        InterestRatesForDeposits interestRatesForDeposits = new InterestRatesForDeposits();
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, interestRatesForDeposits).commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}