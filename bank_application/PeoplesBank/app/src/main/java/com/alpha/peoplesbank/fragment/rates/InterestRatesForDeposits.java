package com.alpha.peoplesbank.fragment.rates;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alpha.peoplesbank.R;
import com.alpha.peoplesbank.fragment.payment.PaymentService;

public class InterestRatesForDeposits extends Fragment {
    private View view;
    private LinearLayout linearLayoutFix, linearLayoutSaving;

    public InterestRatesForDeposits() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_interest_rates_for_deposits, container, false);
        linearLayoutFix = view.findViewById(R.id.fixed_deposit_interest_rate);
        linearLayoutSaving = view.findViewById(R.id.savings_rate_next);
        FixDepositRate fixDepositRate = new FixDepositRate();
        SavingsInterestRate savingsInterestRate = new SavingsInterestRate();
        linearLayoutFix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fixDepositRate).commit();
            }
        });
        linearLayoutSaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, savingsInterestRate).commit();
            }
        });
        BankRates paymentService = new BankRates();

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {

            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, paymentService).commit();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

        return view;
    }
}