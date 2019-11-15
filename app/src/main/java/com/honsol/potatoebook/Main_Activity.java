package com.honsol.potatoebook;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Adapters.CP_MenuAdapter;
import Adapters.Main_MenuAdapter;

public class Main_Activity extends AppCompatActivity {

    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String[] prgmNameList = {
            "Potato Fact Files",
            "Potato Research In India",
            "Cultural Practices",
            "True Potato Seed",
            "Varieties",
            "Growing Conditions",
            "Growth & Develop.",
            "Package of Practices",
//            "Potato Portal",
            "About Us"};

    String dir_path = Environment.getExternalStorageDirectory() + "//PotatoeBook//";


    public static int[] prgmImages = {
            R.mipmap.facts,
            R.mipmap.research,
            R.mipmap.planting,
            R.mipmap.potatoseed,
            R.mipmap.varieties,
            R.mipmap.conditions,
            R.mipmap.growth,
            R.mipmap.packageofpractice,
           // R.mipmap.growth, //portal
            R.mipmap.introduction
           };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);



        gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new Main_MenuAdapter(this, prgmNameList, prgmImages));

        Asyntasking A = new Asyntasking();
        A.execute();
    }



    private void CopyAssets() {
        AssetManager assetManager = getAssets();
        String[] files = {};
        try {
            Log.e("Coping Files","We Are Here");
            files = assetManager.list("pdf");
            Log.e("Coping Files",files[0]);
        } catch (IOException e) {
            Log.e("Coping Files", e.getMessage());
        }

        for (String filename : files) {
            System.out.println("File name => " + filename);
            Log.e("File Name",filename);
            InputStream in = null;

            OutputStream out = null;
            try {


                try{


                        in = assetManager.open("pdf/" + filename);   // if files resides inside the "Files" directory itself
                        out = new FileOutputStream(dir_path + filename);


                    if (dir_exists(dir_path)){
                        // 'Dir exists'
                    }else{
// Display Errormessage 'Dir could not creat!!'
                    }
                }catch(Exception e){

                }
                copyFile(in, out);
                in.close();
                in = null;
                out.flush();
                out.close();
                out = null;
            } catch (Exception e) {
                Log.e("Coping Files", e.getMessage());
            }
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }


    private class Asyntasking extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.e("Coping Files", "Starting AsyncTask");
        }

        @Override
        protected Void doInBackground(Void... params) {
            Log.e("Coping Files", "Inside AsyncTask");
            if (!dir_exists(dir_path)){
                File directory = new File(dir_path);
                directory.mkdirs();}
            CopyAssets();

            return null;
        }
    }

    public boolean dir_exists(String dir_path)
    {
        boolean ret = false;
        File dir = new File(dir_path);
        if(dir.exists() && dir.isDirectory())
            ret = true;
        return ret;
    }
}
