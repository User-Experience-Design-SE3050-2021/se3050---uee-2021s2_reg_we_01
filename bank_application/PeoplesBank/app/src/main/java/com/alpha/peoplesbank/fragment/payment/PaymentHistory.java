package com.alpha.peoplesbank.fragment.payment;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alpha.peoplesbank.R;
import com.alpha.peoplesbank.adapters.BillPaymentHistoryAdapter;
import com.alpha.peoplesbank.model.BillPayment;

import java.util.ArrayList;
import java.util.List;

public class PaymentHistory extends Fragment {
private View view;
private List<BillPayment>billPayments = new ArrayList<>();
private RecyclerView recyclerView;
private BillPaymentHistoryAdapter billPaymentHistoryAdapter;

    public PaymentHistory() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        billPayments.clear();
        billPayments.add(new BillPayment("Electricity Bill Payment","2021/11/07","RS.10000.00"));
        billPayments.add(new BillPayment("Water Bill Payment","2021/11/07","RS.20000.00"));
        billPayments.add(new BillPayment("Phone Bill Payment","2021/11/07","RS.30000.00"));
        billPayments.add(new BillPayment("Electricity Bill Payment","2021/11/07","RS.10000.00"));
        billPayments.add(new BillPayment("Water Bill Payment","2021/11/07","RS.20000.00"));
        billPayments.add(new BillPayment("Phone Bill Payment","2021/11/07","RS.30000.00"));
        billPayments.add(new BillPayment("Phone Bill Payment","2021/11/07","RS.30000.00"));
        billPayments.add(new BillPayment("Electricity Bill Payment","2021/11/07","RS.10000.00"));

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_payment_history, container, false);
        recyclerView = view.findViewById(R.id.payment_history_recyclerView);

         billPaymentHistoryAdapter=  new BillPaymentHistoryAdapter(billPayments,getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(billPaymentHistoryAdapter);

       PaymentService paymentService = new PaymentService();

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