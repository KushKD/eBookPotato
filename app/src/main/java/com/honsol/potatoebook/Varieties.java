package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.View;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class Varieties extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varieties);

        String text  =  "  Potato is grown in India under diverse agroclimatic conditions.  The varieties should make the best use of the agroclimatic conditions and give high yield.  Broadly the potato growing zones in India could be classified into the northern hills, the northern plains, the eastern hills, the plateau region and the southern hills.  The growing season in the northern hills is the kharif season with long days.  The crop experiences water stress during the emergence and initial growth phase while during the maximum bulking phase it is invariably exposed to late blight infection.  Therefore varieties for this region requires resistance to late blight, should be able to withstand water stress, be able to yield well under long day conditions and the crop duration can be between 120 – 150 days.  Presently _Kufri_Jyoti and _Kufri_Giriraj are the main varieties for this region.\n" +
                "\n" +
                "         The northwestern plains comprises of the Indo Gangetic plains extending from Punjab in the West to West Bengal in the East.  Here, autumn is the main potato season.  The crop duration is short about 100-120 days in the West but a short spring crop can also be raised.  In the central and eastern Indo Gangetic plains, the winter season is short and spring crop is invariably not possible.  The potato varieties adapted to the Indo Gangetic plains should be short to medium duration, having moderate resistance to late blight.  At present _Kufri_Jawahar, _Kufri_Chandramukhi, _Kufri_Sutlej are recommended for the western plains while _Kufri_Bahar, _Kufri_Anand and _Kufri_Ashoka have been recommended for the central plains while _Kufri_Pukhraj, _Kufri_Sindhuri and Kufri Ashoka have been recommended for the eastern plains.\n" +
                "\n" +
                "         In the eastern hills, two crop viz summer and kharif crops are taken.  Both the crops are relatively short and the kharf crop is prone to late blight.  Resistance to late blight is a must.  Presently _Kufri_Jyoti and Kufri Megha are the varieties recommended for the region.\n" +
                "\n" +
                "         In the plateau region two crops viz kharif and rabi are taken in many places.  The kharif crop encounters long days, erratic rainfall, warm temperatures, high incidence of early blight and mites. _Kufri_Jyoti and _Kufri_Lauvkar is recommended for this season.  The rabi crop is of very short duration and early bulking variety like Kufri Lauvkar is successful in this season.  Kufri Jyoti is also grown in this season.\n" +
                "\n" +
                "         In the southern hills, potato is grown in the Nilgiri hills.  Three crops are taken. _Potato_cyst_nematode and _late_blight are the problems of the region.  Kufri Jyoti and Kufri Swarna are the varieties recommended for the region.";
        check = (LinkEnabledTextView)findViewById(R.id.linkenabledtextview) ;
        // check = new LinkEnabledTextView(this, null);
        check.setOnTextLinkClickListener(this);
        check.gatherLinksForText(text);
        check.setTextColor(Color.BLACK);
        check.setLinkTextColor(Color.BLUE);
        // setContentView(check);

        MovementMethod m = check.getMovementMethod();
        if ((m == null) || !(m instanceof LinkMovementMethod)) {
            if (check.getLinksClickable()) {
                check.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        if(clickedString.equalsIgnoreCase("_Kufri_Jyoti")){
            Log.e("Hyperlink is :1: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Kufri_Giriraj")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Kufri_Jawahar")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Kufri_Chandramukhi")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Kufri_Sutlej")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Kufri_Bahar")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Kufri_Anand")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Kufri_Pukhraj")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Kufri_Sindhuri")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Kufri_Jyoti")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Kufri_Lauvkar")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Potato_cyst_nematode")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_late_blight")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else{
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}
