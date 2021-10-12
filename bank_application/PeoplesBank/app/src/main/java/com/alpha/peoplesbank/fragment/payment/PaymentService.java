package com.alpha.peoplesbank.fragment.payment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alpha.peoplesbank.R;
import com.alpha.peoplesbank.fragment.cheque.ChequeService;

public class PaymentService extends Fragment {

    private LinearLayout oneTimeBillPay,billHistory,chequeService;
    private View view;
    private OneTimeBillPayment oneTimeBillPayment = new OneTimeBillPayment();
    private PaymentHistory paymentHistory = new PaymentHistory();
    private ChequeService chequeServices = new ChequeService();

    public PaymentService() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_payment_service, container, false);
        oneTimeBillPay = view.findViewById(R.id.one_time_bill_pay);
        billHistory = view.findViewById(R.id.bill_pay_history);
        chequeService = view.findViewById(R.id.cheque_service);
        oneTimeBillPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, oneTimeBillPayment).commit();
            }
        });
        billHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, paymentHistory).commit();
            }
        });

        return view;
    }
}