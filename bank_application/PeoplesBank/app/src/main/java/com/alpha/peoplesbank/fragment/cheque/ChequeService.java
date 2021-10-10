package com.alpha.peoplesbank.fragment.cheque;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alpha.peoplesbank.R;


public class ChequeService extends Fragment {



    public ChequeService() {
        // constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cheque_service, container, false);
    }
}