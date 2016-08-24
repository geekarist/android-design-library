package com.example.android.materialdesigncodelab;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MaterialApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/xephyr-shadow.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
