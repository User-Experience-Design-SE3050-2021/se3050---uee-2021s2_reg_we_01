package com.alpha.peoplesbank.fragment.payment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.alpha.peoplesbank.R;

public class PaymentOtp extends Fragment {

    private View view;
    Button verify;


    public PaymentOtp() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_payment_otp, container, false);
        verify = view.findViewById(R.id.btn_payment_submit);
        PaymentSuccessfulMessage paymentSuccessfulMessage = new PaymentSuccessfulMessage();

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, paymentSuccessfulMessage).commit();
                Toast.makeText(getActivity(),"Payment Verified",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}