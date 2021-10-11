package com.alpha.peoplesbank.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.peoplesbank.R;
import com.alpha.peoplesbank.adapters.AccountListAdapter;
import com.alpha.peoplesbank.interfaces.OnClickInterface;
import com.alpha.peoplesbank.model.ItemAccountList;

import java.util.ArrayList;
import java.util.List;


public class FundTransferFragment extends Fragment {

    View rootView;

    public LinearLayout add_fav_fund_trans;
    public Button btn_transaction1_next;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public EditText et_toAccount;

    public Spinner Accounts;
    public int mSelectedIndex = 0;

    public OnClickInterface onClickInterface;


    private List<ItemAccountList> data;
    public static AccountListAdapter accountListAdapter;
    private RecyclerView AccountRecyclerView;

    public FundTransferFragment() {
        // Required empty public constructor
    }

    public static FundTransferFragment newInstance(String param1, String param2) {
        FundTransferFragment fragment = new FundTransferFragment();
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

    public void initialize() {
        Accounts = (Spinner) rootView.findViewById(R.id.sp_accounts);
        AccountRecyclerView = rootView.findViewById(R.id.account_recyclerview);

        et_toAccount = rootView.findViewById(R.id.et_toAccount);

        data = new ArrayList<ItemAccountList>();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        AccountRecyclerView.setLayoutManager(layoutManager);

        add_fav_fund_trans = rootView.findViewById(R.id.add_fav_trans);

        btn_transaction1_next = rootView.findViewById(R.id.btn_transaction1_next);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_fund_transaction, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setHasOptionsMenu(true);





        initialize();
        eventHandler();

        return rootView;
    }




    public void eventHandler() {

        add_fav_fund_trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new add_fav_fund_trans();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commitAllowingStateLoss();
            }
        });


        btn_transaction1_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new fundTransfer2();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commitAllowingStateLoss();
            }
        });

        onClickInterface = new OnClickInterface() {
            @Override
            public void setValues(String card) {

                et_toAccount.setText(card);

            }
        };

        String[] sample_data_array = getResources().getStringArray(R.array.sample_data_array);
        String[] sample_acc_data_array = getResources().getStringArray(R.array.sample_acc_data_array);

        for (int i = 0; i < sample_data_array.length; i++){

            addMDataEvent(sample_data_array[i], sample_acc_data_array[i]);
        }

        setDataToAdapter();

    }

    public void setDataToSpinner() {
        List<String> spinnerArray = new ArrayList<>();


        spinnerArray.add("Account1");

        spinnerArray.add("Account2");


        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddFaultActivity.this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
        spServiceTypes.setAdapter(adapter);*/

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_dropdown_style, spinnerArray) {
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the spinner collapsed item (non-popup item) as a text view
                TextView tv = (TextView) super.getView(position, convertView, parent);
                // Set the text color of spinner item
                tv.setBackgroundColor(getResources().getColor(R.color.transparent));
                tv.setTextColor(getResources().getColor(R.color.black));
                // Return the view
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                // Cast the drop down items (popup items) as text view
                TextView tv = (TextView) super.getDropDownView(position, convertView, parent);
                // Set the text color of drop down items
                tv.setBackgroundColor(getResources().getColor(R.color.white));
                tv.setTextColor(getResources().getColor(R.color.purple_700));
                // If this item is selected item
                if (position == mSelectedIndex) {
                    // Set spinner selected popup item's text color
                    tv.setBackgroundColor(getResources().getColor(R.color.purple_700));
                    tv.setTextColor(getResources().getColor(R.color.white));
                }
                // Return the modified view
                return tv;
            }
        };

        // Set an item selection listener for spinner widget
        Accounts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Set the value for selected index variable
                mSelectedIndex = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Data bind the spinner with array adapter items
        Accounts.setAdapter(adapter);
    }


    public void setDataToAdapter() {

        System.out.println("People's bank app dataCard size "+data.size());

        accountListAdapter = new AccountListAdapter(data, onClickInterface, getContext(), getActivity());
//            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(GetExGBActivity.this);
//            cardRecyclerView.setLayoutManager(mLayoutManager);
        AccountRecyclerView.setItemAnimator(new DefaultItemAnimator());
        AccountRecyclerView.setAdapter(accountListAdapter);
    }

    public void addMDataEvent(String Name, String CardNumber) {

        ItemAccountList item = new ItemAccountList();

        item.name = Name;
        item.CardNumber = CardNumber;


        data.add(item);
    }


}