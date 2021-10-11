package com.alpha.peoplesbank.fragment.payment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.alpha.peoplesbank.R;

import java.util.ArrayList;

public class OneTimeBillPayment extends Fragment {

    private View view;
    private TextView serviceProvider;
    private Dialog dialog;
    private EditText dialog_edit;
    private ListView dialog_listView;
    private ArrayList<String> stringArrayList;

    public OneTimeBillPayment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_one_time_bill_payment, container, false);
        serviceProvider = view.findViewById(R.id.one_time_payment_service_provider);

        stringArrayList = new ArrayList<>();
        stringArrayList.add("one");
        stringArrayList.add("two");
        stringArrayList.add("three");
        stringArrayList.add("four");
        stringArrayList.add("five");
        stringArrayList.add("six");
        stringArrayList.add("seven");
        stringArrayList.add("eight");
        stringArrayList.add("nine");
        stringArrayList.add("ten");

        PaymentService paymentService = new PaymentService();

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {

            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, paymentService).commit();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

        serviceProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_searchable_sprinner);
                dialog.getWindow().setLayout(800, 1200);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                dialog_edit = dialog.findViewById(R.id.dialog_edit_text);
                dialog_listView = dialog.findViewById(R.id.dialog_list_view);

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, stringArrayList);

                dialog_listView.setAdapter(arrayAdapter);

                dialog_edit.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        arrayAdapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                dialog_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        serviceProvider.setText(arrayAdapter.getItem(i));
                        dialog.dismiss();
                    }
                });
            }
        });

        return view;
    }

}