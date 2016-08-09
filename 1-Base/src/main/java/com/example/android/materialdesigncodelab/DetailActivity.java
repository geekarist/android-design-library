package com.example.android.materialdesigncodelab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DESC = "EXTRA_DESC";
    public static final String EXTRA_TITLE = "EXTRA_TITLE";

    public static void startActivity(Context context, String desc, String title) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_DESC, desc);
        intent.putExtra(EXTRA_TITLE, title);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        assert toolbarLayout != null;
        toolbarLayout.setTitle(getString(R.string.item_title));

        TextView descTextView = (TextView) findViewById(R.id.place_desc);
        TextView locTextView = (TextView) findViewById(R.id.place_location);

        descTextView.setText(getIntent().getStringExtra(EXTRA_DESC));
        locTextView.setText(getIntent().getStringExtra(EXTRA_TITLE));
    }
}
