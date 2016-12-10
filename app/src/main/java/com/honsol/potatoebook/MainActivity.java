package com.honsol.potatoebook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import Adapters.MenuAdapter;

public class MainActivity extends AppCompatActivity {

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
            "Sorting & gading ",
            "Storage",
            "Processing"};


    public static int[] prgmImages = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new MenuAdapter(this, prgmNameList, prgmImages));
    }
}
