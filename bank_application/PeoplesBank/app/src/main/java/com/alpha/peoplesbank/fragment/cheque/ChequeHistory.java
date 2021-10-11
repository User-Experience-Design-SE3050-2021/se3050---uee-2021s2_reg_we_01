package com.alpha.peoplesbank.fragment.cheque;

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
import com.alpha.peoplesbank.adapters.ChequeHistoryAdapter;
import com.alpha.peoplesbank.fragment.payment.PaymentService;
import com.alpha.peoplesbank.model.BillPayment;
import com.alpha.peoplesbank.model.ChequeStatus;

import java.util.ArrayList;
import java.util.List;

public class ChequeHistory extends Fragment {
    private View view;
    private List<ChequeStatus> chequeStatusList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ChequeHistoryAdapter chequeHistoryAdapter;

    public ChequeHistory() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        chequeStatusList.clear();
        chequeStatusList.add(new ChequeStatus("IN001123", "2021/11/07", "2500.00", 1));
        chequeStatusList.add(new ChequeStatus("IN001123", "2021/11/07", "2500.00", 0));
        chequeStatusList.add(new ChequeStatus("IN001123", "2021/11/07", "2500.00", 0));
        chequeStatusList.add(new ChequeStatus("IN001123", "2021/11/07", "2500.00", 1));
        chequeStatusList.add(new ChequeStatus("IN001123", "2021/11/07", "2500.00", 1));
        chequeStatusList.add(new ChequeStatus("IN001123", "2021/11/07", "2500.00", 1));
        chequeStatusList.add(new ChequeStatus("IN001123", "2021/11/07", "2500.00", 0));
        chequeStatusList.add(new ChequeStatus("IN001123", "2021/11/07", "2500.00", 1));

        view = inflater.inflate(R.layout.fragment_cheque_history, container, false);
        recyclerView = view.findViewById(R.id.cheque_history_recyclerView);

        chequeHistoryAdapter = new ChequeHistoryAdapter(chequeStatusList, getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(chequeHistoryAdapter);

        ChequeService chequeService = new ChequeService();

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {

            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, chequeService).commit();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

        return view;
    }
}