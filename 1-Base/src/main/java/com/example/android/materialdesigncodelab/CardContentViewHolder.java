package com.example.android.materialdesigncodelab;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class CardContentViewHolder extends RecyclerView.ViewHolder {

    private final ImageView mImagePlace;
    private final TextView mTextPlaceTitle;
    private final TextView mTextPlaceDesc;

    public CardContentViewHolder(View itemView) {
        super(itemView);

        mImagePlace = (ImageView) itemView.findViewById(R.id.image_place);
        mTextPlaceTitle = (TextView) itemView.findViewById(R.id.text_place_title);
        mTextPlaceDesc = (TextView) itemView.findViewById(R.id.text_place_desc);
    }

    public void bind(String place, String placeDescription, Drawable placeDrawable) {

        mImagePlace.setImageDrawable(placeDrawable);
        mTextPlaceTitle.setText(place);
        mTextPlaceDesc.setText(placeDescription);
    }
}
