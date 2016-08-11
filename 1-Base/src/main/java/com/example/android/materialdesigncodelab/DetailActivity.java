package com.example.android.materialdesigncodelab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DESC = "EXTRA_DESC";
    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_IMG = "EXTRA_IMG";

    public static void startActivity(Context context, String desc, String title, int img) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_DESC, desc);
        intent.putExtra(EXTRA_TITLE, title);
        intent.putExtra(EXTRA_IMG, img);
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
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        toolbarLayout.setTitle(title);

        TextView descTextView = (TextView) findViewById(R.id.place_desc);
        TextView locTextView = (TextView) findViewById(R.id.place_location);

        assert descTextView != null;
        descTextView.setText(getIntent().getStringExtra(EXTRA_DESC));
        assert locTextView != null;
        locTextView.setText(title);

        ImageView imageView = (ImageView) findViewById(R.id.detail_image_place);
        assert imageView != null;
        imageView.setImageDrawable(
                getResources().getDrawable(getIntent().getIntExtra(EXTRA_IMG, R.drawable.a)));
    }
}
