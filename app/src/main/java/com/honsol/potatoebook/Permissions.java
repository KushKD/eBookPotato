package com.honsol.potatoebook;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.honsol.permissions.RakshamPermissionResponse;
import com.honsol.permissions.RakshamPermissions;

import Utils.Custom_Dialog;

public class Permissions extends Activity implements View.OnClickListener,RakshamPermissions.OnRequestPermissionsBack{

    private static final String TAG = "MainActivity";
    private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        checkButton = (Button)findViewById(R.id.checkButton);
        checkButton.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {

        try {

            new RakshamPermissions.Builder(this)
                    .withPermissions(
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                          )
                    .requestId(1)
                    .setListener(this)
                    .check();



        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Something Went wrong while setting the permissions.",Toast.LENGTH_LONG).show();
        }

    }



    @Override
    public void onRequestBack(RakshamPermissionResponse gotaResponse) {
        SharedPreferences settings = getSharedPreferences("Permissions", 0); // 0 - for private mode
        SharedPreferences.Editor editor = settings.edit();
        //Set "hasLoggedIn" to true
        editor.putBoolean("PermissionsFlag", true);
        editor.commit();

        // Intent i = new Intent(Permissions.this,Login.class);   //Working
        Intent i = new Intent(Permissions.this,Main_Activity.class);
        startActivity(i);
        Permissions.this.finish();

        if(gotaResponse.isGranted(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            Log.d(TAG, "GRATED");
        }

    }
}