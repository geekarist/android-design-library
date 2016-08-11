package com.example.android.materialdesigncodelab;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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

        private PlaceContents mContents;

        public ContentAdapter() {
            super();
            mContents = new PlaceContents(getContext().getResources());
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
                    mContents.getTitle(position),
                    mContents.getDesc(position),
                    mContents.getDrawable(position),
                    mContents.getDrawableId(position));
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
        private int mDrawableId;

        public ContentViewHolder(View itemView) {
            super(itemView);

            mImagePlace = (ImageView) itemView.findViewById(R.id.image_place);
            mTextPlaceTitle = (TextView) itemView.findViewById(R.id.text_place_title);
            mTextPlaceDesc = (TextView) itemView.findViewById(R.id.text_place_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    DetailActivity.startActivity(
                            context,
                            String.valueOf(mTextPlaceDesc.getText()),
                            String.valueOf(mTextPlaceTitle.getText()),
                            mDrawableId);
                }
            });
        }

        public void bind(final String place, String placeDescription, Drawable placeDrawable, int drawableId) {

            mImagePlace.setImageDrawable(placeDrawable);
            mTextPlaceTitle.setText(place);
            mTextPlaceDesc.setText(placeDescription);
            mDrawableId = drawableId;

            View actionButton = itemView.findViewById(R.id.button_action);
            actionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Did an action on " + place, Snackbar.LENGTH_LONG).show();
                }
            });

            View favButton = itemView.findViewById(R.id.button_favorite);
            favButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "You like " + place, Snackbar.LENGTH_LONG).show();
                }
            });


            View shareButton = itemView.findViewById(R.id.button_share);
            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "You shared " + place, Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }

}
