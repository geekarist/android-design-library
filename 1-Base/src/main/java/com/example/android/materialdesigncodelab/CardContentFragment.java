package com.example.android.materialdesigncodelab;


import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardContentFragment extends Fragment {


    public CardContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        RecyclerView.Adapter adapter = new ContentAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return recyclerView;
    }

    private class ContentAdapter extends RecyclerView.Adapter<ContentViewHolder> {

        private static final int SIZE = 18;
        private final String[] mPlaces;
        private final String[] mPlaceDescriptions;
        private final Drawable[] mPlaceDrawables;

        public ContentAdapter() {

            super();

            Resources resources = getContext().getResources();
            mPlaces = resources.getStringArray(R.array.places);
            mPlaceDescriptions = resources.getStringArray(R.array.place_desc);

            TypedArray placePics = resources.obtainTypedArray(R.array.places_picture);
            mPlaceDrawables = new Drawable[placePics.length()];
            for (int i = 0; i < mPlaceDrawables.length; i++) {
                mPlaceDrawables[i] = placePics.getDrawable(i);
            }
            placePics.recycle();
        }

        @Override
        public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(R.layout.fragment_card_content, parent, false);
            return new ContentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ContentViewHolder holder, int position) {
            holder.bind(
                    mPlaces[position % mPlaces.length],
                    mPlaceDescriptions[position % mPlaceDescriptions.length],
                    mPlaceDrawables[position % mPlaceDrawables.length]);
        }

        @Override
        public int getItemCount() {
            return SIZE;
        }
    }

    private class ContentViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImagePlace;
        private final TextView mTextPlaceTitle;
        private final TextView mTextPlaceDesc;

        public ContentViewHolder(View itemView) {
            super(itemView);

            mImagePlace = (ImageView) CardContentFragment.this.getActivity().findViewById(R.id.image_place);
            mTextPlaceTitle = (TextView) CardContentFragment.this.getActivity().findViewById(R.id.text_place_title);
            mTextPlaceDesc = (TextView) CardContentFragment.this.getActivity().findViewById(R.id.text_place_desc);
        }

        public void bind(String place, String placeDescription, Drawable placeDrawable) {

            mImagePlace.setImageDrawable(placeDrawable);
            mTextPlaceTitle.setText(place);
            mTextPlaceDesc.setText(placeDescription);
        }
    }
}
