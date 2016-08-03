package com.example.android.materialdesigncodelab;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TileContentFragment extends Fragment {


    public TileContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(getResources());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        int tilePadding = getContext().getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        return recyclerView;
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTextTitle;
        private final ImageView mImage;

        public ContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_tile_content, parent, false));

            mTextTitle = (TextView) itemView.findViewById(R.id.tile_text_place_title);
            mImage = (ImageView) itemView.findViewById(R.id.tile_image_place);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    context.startActivity(intent);
                }
            });
        }

        public void bind(String title, Drawable drawable) {

            mTextTitle.setText(title);
            mImage.setImageDrawable(drawable);
        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ContentViewHolder> {

        public static final int SIZE = 18;
        private final PlaceContents mContents;

        public ContentAdapter(Resources resources) {
            mContents = new PlaceContents(resources);
        }

        @Override
        public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            return new ContentViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(ContentViewHolder holder, int position) {
            holder.bind(mContents.getTitle(position), mContents.getDrawable(position));
        }

        @Override
        public int getItemCount() {
            return SIZE;
        }
    }
}
