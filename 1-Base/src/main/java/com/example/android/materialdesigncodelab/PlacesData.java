package com.example.android.materialdesigncodelab;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

public class PlacesData {
    private String[] mPlaces;
    private String[] mPlaceDescriptions;
    private Drawable[] mPlaceDrawables;

    public PlacesData(Resources resources) {

        mPlaces = resources.getStringArray(R.array.places);
        mPlaceDescriptions = resources.getStringArray(R.array.place_desc);

        TypedArray placePics = resources.obtainTypedArray(R.array.places_picture);
        mPlaceDrawables = new Drawable[placePics.length()];
        for (int i = 0; i < mPlaceDrawables.length; i++) {
            mPlaceDrawables[i] = placePics.getDrawable(i);
        }
        placePics.recycle();
    }

    public String getTitle(int position) {
        return mPlaces[position % mPlaces.length];
    }

    public String getDesc(int position) {
        return mPlaceDescriptions[position % mPlaceDescriptions.length];
    }

    public Drawable getDrawable(int position) {
        return mPlaceDrawables[position % mPlaceDrawables.length];
    }
}
