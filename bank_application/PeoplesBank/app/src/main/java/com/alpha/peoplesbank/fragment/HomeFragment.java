package com.alpha.peoplesbank.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.peoplesbank.MainActivity;
import com.alpha.peoplesbank.R;
import com.alpha.peoplesbank.Util.SliderAdapterExample;
import com.alpha.peoplesbank.adapters.ChequeHistoryAdapter;
import com.alpha.peoplesbank.adapters.TransactionHistoryAdapter;
import com.alpha.peoplesbank.fragment.payment.PaymentService;
import com.alpha.peoplesbank.model.TransactionHistory;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    View rootView;
    private PaymentService paymentService = new PaymentService();
    private RecyclerView recyclerView;
    private TransactionHistoryAdapter transactionHistoryAdapter;
    private List<TransactionHistory> transactionHistoryList = new ArrayList<>();

    public SliderView sliderView;
    public SliderAdapterExample sliderAdapter;
    public String[] addImagesArray = {};

    public static Button btn_transaction;

    public HomeFragment() {
        // Required empty public constructor
    }


    public void initialize(){

        sliderView = rootView.findViewById(R.id.imageSlider);

        btn_transaction = rootView.findViewById(R.id.btn_transaction);
    }

    public void eventHandler(){
        HomeFragment.btn_transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new TransactionFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commitAllowingStateLoss();
                MainActivity.bottomNavigationView.getMenu().getItem(1).setChecked(true);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        transactionHistoryList.add(new TransactionHistory("transaction 01","2021/12/12","2500.00",1));
        transactionHistoryList.add(new TransactionHistory("transaction 01","2021/12/12","2500.00",0));
        transactionHistoryList.add(new TransactionHistory("transaction 01","2021/12/12","2500.00",1));
        transactionHistoryList.add(new TransactionHistory("transaction 01","2021/12/12","2500.00",0));

        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setHasOptionsMenu(true);
        initialize();
        eventHandler();


        recyclerView =  rootView.findViewById(R.id.transaction_history_recycleView);

        transactionHistoryAdapter = new TransactionHistoryAdapter(transactionHistoryList, getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(transactionHistoryAdapter);


        return rootView;
    }


    public void setImagesToImageSlider() {

        sliderAdapter = new SliderAdapterExample(getContext(), addImagesArray);
        sliderView.setSliderAdapter(sliderAdapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(getResources().getColor(R.color.accent_white));
        sliderView.setIndicatorUnselectedColor(getResources().getColor(R.color.white));
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }
}