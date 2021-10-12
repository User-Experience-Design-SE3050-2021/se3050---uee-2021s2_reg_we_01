package com.alpha.peoplesbank.fragment.payment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.alpha.peoplesbank.R;

import java.util.ArrayList;

public class OneTimeBillPayment extends Fragment {

    private View view;
    private Spinner paymentFromAccount;
    private TextView serviceProvider;
    private Dialog dialog;
    private EditText dialog_edit,paymentDate;
    private Button nextButton;
    private ListView dialog_listView;
    private ArrayList<String> stringArrayList;
    private java.util.Calendar calendar = java.util.Calendar.getInstance();
    private int day, month, year;


    public OneTimeBillPayment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_one_time_bill_payment, container, false);
        serviceProvider = view.findViewById(R.id.one_time_payment_service_provider);
        paymentDate = (EditText) view.findViewById(R.id.one_time_payment_time_date);
        nextButton = view.findViewById(R.id.one_time_payment_next_button);
        paymentFromAccount = view.findViewById(R.id.one_time_payment_from_accounts);

        fillAccountNumber();

        day = calendar.get(Calendar.DAY_OF_MONTH);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);

        stringArrayList = new ArrayList<>();
        stringArrayList.add("ALLIANZ LIFE INSURANCE");
        stringArrayList.add("ASSET LINE LEASING");
        stringArrayList.add("BUDDHIST LADIES COLLEGE");
        stringArrayList.add("CEYLINCO INSURANCE-LIFE POLICY");
        stringArrayList.add("CEYLON ELECTRICITY BOARD");
        stringArrayList.add("CITIZEN DEVELOPMENT BANK");
        stringArrayList.add("COLOMBO MUNICIPAL COUNCIL");
        stringArrayList.add("CEYLON PETROLEUM CORPORATION");
        stringArrayList.add("D.J TRADING CO LED");




        paymentDate.setOnClickListener(paymentDateClickListener);

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

        PaymentOtp paymentOtp = new PaymentOtp();

       nextButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, paymentOtp).commit();
           }
       });

        return view;
    }


    View.OnClickListener paymentDateClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fromDateDialog();
        }
    };

    public void fromDateDialog() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                paymentDate.setText(dayOfMonth + "/" + monthOfYear + "/" + year);

            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), listener, year, month, day);
        datePickerDialog.show();
    }

    private void fillAccountNumber() {
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1);
        adapter.add("LKR 5837 6742 3588 2398");
        adapter.add("LKR 3425 6734 1845 5734");


        //SET ADAPTER INSTANCE TO OUR SPINNER
        paymentFromAccount.setAdapter(adapter);

    }

}