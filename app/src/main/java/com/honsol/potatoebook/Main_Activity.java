package com.honsol.potatoebook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import Adapters.CP_MenuAdapter;
import Adapters.Main_MenuAdapter;

public class Main_Activity extends AppCompatActivity {

    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String[] prgmNameList = {
            "Potato In India Fact Files",
            "Potato Research In India",
            "Cultural Practices",
            "True Potato Seed",
            "Varieties",
            "Growing Conditions",
            "Groth and Development",
            "Package of Practices"};


    public static int[] prgmImages = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
           };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new Main_MenuAdapter(this, prgmNameList, prgmImages));
    }
}
