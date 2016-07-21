package com.example.android.materialdesigncodelab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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
        RecyclerView.Adapter adapter = new CardContentAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return recyclerView;
    }

    private class CardContentAdapter extends ContentAdapter {

        private static final int SIZE = 18;

        private PlacesData placesData;

        public CardContentAdapter() {
            super();
            placesData = new PlacesData(getContext().getResources());
        }

        @Override
        public CardContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(R.layout.fragment_card_content, parent, false);
            return new CardContentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CardContentViewHolder holder, int position) {
            holder.bind(placesData.getTitle(position), placesData.getDesc(position), placesData.getDrawable(position));
        }

        @Override
        public int getItemCount() {
            return SIZE;
        }
    }

}
