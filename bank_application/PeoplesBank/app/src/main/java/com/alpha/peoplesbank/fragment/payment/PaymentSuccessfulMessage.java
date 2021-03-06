package com.alpha.peoplesbank.fragment.payment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.alpha.peoplesbank.R;

public class PaymentSuccessfulMessage extends Fragment {

    private  View view;
    private Button button;

    public PaymentSuccessfulMessage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_payment_successful_message, container, false);
        button = view.findViewById(R.id.btn_payment_success);

        PaymentService paymentService = new PaymentService();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, paymentService).commit();
                Toast.makeText(getActivity(),"Payment Successful",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}