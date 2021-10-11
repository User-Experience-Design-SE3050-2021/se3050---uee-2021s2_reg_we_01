package com.alpha.peoplesbank.fragment.cheque;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alpha.peoplesbank.R;


public class ChequeService extends Fragment {

    private View view;
    private LinearLayout chequeStatus;


    public ChequeService() {
        // constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cheque_service, container, false);
        chequeStatus = view.findViewById(R.id.cheque_status_check);

        ChequeHistory chequeHistory = new ChequeHistory();
        chequeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, chequeHistory).commit();
            }
        });
        return view;
    }
}