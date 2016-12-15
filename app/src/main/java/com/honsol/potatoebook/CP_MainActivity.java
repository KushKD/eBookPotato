package com.honsol.potatoebook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import Adapters.CP_MenuAdapter;

public class CP_MainActivity extends AppCompatActivity {

    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String[] prgmNameList = {
            "Introduction",
            "Seed preparation",
            "Land preparation",
            "Planting",
            "Fertilization",
            "Irrigation",
            "Weeding",
            "Earthing up",
            "Plant protection",
            "Halum cutting",
            "Harvesting",
            "Sorting & gading",
            "Storage",
            "Processing"};


    public static int[] prgmImages = {
            R.mipmap.introduction,
            R.mipmap.seedprepration,
            R.mipmap.landprepration,
            R.mipmap.planting,
            R.mipmap.fertilization,
            R.mipmap.irrigation,
            R.mipmap.weeding,
            R.mipmap.earthingup,
            R.mipmap.plantprotection,
            R.mipmap.cutting,
            R.mipmap.harvesting,
            R.mipmap.storing,
            R.mipmap.storage,
            R.mipmap.processing};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new CP_MenuAdapter(this, prgmNameList, prgmImages));
    }
}
