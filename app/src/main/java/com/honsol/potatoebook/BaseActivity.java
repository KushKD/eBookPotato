package com.honsol.potatoebook;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by kuush on 12/13/2016.
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
