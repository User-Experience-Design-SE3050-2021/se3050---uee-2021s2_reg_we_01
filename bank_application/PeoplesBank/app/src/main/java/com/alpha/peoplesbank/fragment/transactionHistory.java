package com.alpha.peoplesbank.fragment;

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
import com.alpha.peoplesbank.adapters.TransactionHistoryAdapter;
import com.alpha.peoplesbank.fragment.payment.PaymentService;
import com.alpha.peoplesbank.model.BillPayment;
import com.alpha.peoplesbank.model.TransactionHistory;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link transactionHistory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class transactionHistory extends Fragment {

    private View view;
    private List<TransactionHistory> transactionHistoryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TransactionHistoryAdapter transactionHistoryAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public transactionHistory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment transactionHistory.
     */
    // TODO: Rename and change types and number of parameters
    public static transactionHistory newInstance(String param1, String param2) {
        transactionHistory fragment = new transactionHistory();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        transactionHistoryList.add(new TransactionHistory("W A Ranjula","2021/10/12","24000.00",1));
        transactionHistoryList.add(new TransactionHistory("Maneesha W R ","2021/12/12","2500.00",0));
        transactionHistoryList.add(new TransactionHistory("transaction 01","2021/12/12","2500.00",1));
        transactionHistoryList.add(new TransactionHistory("transaction 01","2021/12/12","2500.00",0));


        view = inflater.inflate(R.layout.fragment_transaction_history, container, false);
        recyclerView = view.findViewById(R.id.Transactional_history_recyclerView);


        transactionHistoryAdapter =  new TransactionHistoryAdapter(transactionHistoryList,getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(transactionHistoryAdapter);

        HomeFragment homeFragment = new HomeFragment();

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {

            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, homeFragment).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);
        return view;
    }
}