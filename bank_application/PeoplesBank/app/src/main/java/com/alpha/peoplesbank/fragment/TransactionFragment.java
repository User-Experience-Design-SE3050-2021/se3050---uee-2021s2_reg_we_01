package com.alpha.peoplesbank.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.alpha.peoplesbank.R;

public class TransactionFragment extends Fragment {


    View rootView;

    public LinearLayout lo_fundtransfer,lo_intertransfer;

    public TransactionFragment() {
        // Required empty public constructor
    }

//    public static TransactionFragment newInstance(String param1, String param2) {
//        TransactionFragment fragment = new TransactionFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_transaction, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setHasOptionsMenu(true);

        initialize();
        eventHandler();
        return rootView;
    }


    public void initialize(){

        lo_fundtransfer = rootView.findViewById(R.id.lo_fundtransfer);
        lo_intertransfer = rootView.findViewById(R.id.lo_inter_bank_transfer);

    }

    public void eventHandler(){
        lo_fundtransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new FundTransferFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commitAllowingStateLoss();
            }
        });


        lo_intertransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new FundTransferFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commitAllowingStateLoss();
            }
        });







    }

}