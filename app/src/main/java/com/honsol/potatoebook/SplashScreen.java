package com.honsol.potatoebook;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    private int GPS_PERMISSION = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences settings = getSharedPreferences("Permissions", 0);
                //Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
                //   boolean hasParkingSelected_ = settings.getBoolean("hasParkingSelected", false);

                int currentapiVersion = android.os.Build.VERSION.SDK_INT;
                if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP){

                    boolean Flag_Permissions = settings.getBoolean("PermissionsFlag",false);
                    if(Flag_Permissions)
                    {
                        Intent login_Intent = new Intent(SplashScreen.this, Main_Activity.class);
                        SplashScreen.this.startActivity(login_Intent);
                        SplashScreen.this.finish();

                    }else{
                        /*Intent login_Intent = new Intent(SplashScreen.this, Permissions.class);
                        SplashScreen.this.startActivity(login_Intent);
                        SplashScreen.this.finish();*/
                        if(!isGPSAllowed()){
                            requestGPSPermission();
                        }
                    }
                } else{

                    Intent mainIntent = new Intent(SplashScreen.this, Main_Activity.class);
                    SplashScreen.this.startActivity(mainIntent);
                    SplashScreen.this.finish();
                }





            }
        }, 3000);
    }

    private void requestGPSPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},GPS_PERMISSION);
        //ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},GPS_PERMISSION);
    }

    //We are calling this method to check the permission status
    private boolean isGPSAllowed() {
        // String permission = "android.permission.ACCESS_FINE_LOCATION";
        // int res = this.checkCallingOrSelfPermission(permission);
        // return (res == PackageManager.PERMISSION_GRANTED);
        //Getting the permission status
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE );

        //If permission is granted returning true
        if (result == PackageManager.PERMISSION_GRANTED)
            return true;

        //If permission is not granted returning false
        return false;
    }

    //This method will be called when the user will tap on allow or deny
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        if(requestCode == GPS_PERMISSION){
            //If permission is granted
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                //Displaying a toast
                Toast.makeText(this,"GPS Permission granted ",Toast.LENGTH_LONG).show();
                SharedPreferences settings = getSharedPreferences("Permissions", 0); // 0 - for private mode
                SharedPreferences.Editor editor = settings.edit();
                //Set "hasLoggedIn" to true
                editor.putBoolean("PermissionsFlag", true);
                editor.commit();

                // Intent i = new Intent(Permissions.this,Login.class);   //Working
                Intent i = new Intent(SplashScreen.this,Main_Activity.class);
                startActivity(i);
                SplashScreen.this.finish();
            }else{
                //Displaying another toast if permission is not granted
                Toast.makeText(this,"Oops you just denied the GPS permission",Toast.LENGTH_LONG).show();
            }
        }
    }
}
