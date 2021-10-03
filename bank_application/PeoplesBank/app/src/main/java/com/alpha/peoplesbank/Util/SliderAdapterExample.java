package com.alpha.peoplesbank.Util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.alpha.peoplesbank.MainActivity;
import com.alpha.peoplesbank.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {
    private Context context;
    private String[] images;
    private String[] bannerType;
    private String[] buttonName;
    private String[] WebViewTitle;
    private String[] screenFlag;
    private String[] webUrl;
    private String[] textColourArray;
    private String[] buttonColourArray;

    public SliderAdapterExample(Context context, String[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_item_layout, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        //viewHolder.textViewDescription.setText("This is slider item " + position);

//        Glide.with(context).load(images[position]).error(R.drawable.master).into(viewHolder.imageViewBackground);

        //viewHolder.textViewDescription.setText();

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return images.length;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        View itemView;
        ImageView imageViewBackground;
        Button ActivateBanner;
        CardView cvButton;
        //TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_sliderImage);
            //textViewDescription = itemView.findViewById(R.id.tv_sliderText);
            this.itemView = itemView;
        }
    }
}
