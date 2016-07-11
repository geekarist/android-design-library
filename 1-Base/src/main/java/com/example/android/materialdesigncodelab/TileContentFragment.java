package com.example.android.materialdesigncodelab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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
        ContentAdapter adapter = new ContentAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return recyclerView;
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        public ContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_tile_content, parent, false));
        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ContentViewHolder> {

        public static final int SIZE = 18;

        public ContentAdapter() {
        }

        @Override
        public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            return new ContentViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(ContentViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return SIZE;
        }
    }
}
