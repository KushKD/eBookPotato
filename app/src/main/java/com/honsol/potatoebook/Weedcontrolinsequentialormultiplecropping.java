package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class Weedcontrolinsequentialormultiplecropping extends AppCompatActivity implements TextLinkClickListener {
    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weedcontrolinsequentialormultiplecropping);
        String text = "In sequential and intercropping systems, the weed flora and weed control practices adopted in the previous crop and other component crop may affect the weed growth and yield of the potato crop and vice-versa.\n" +
                "\n" +
                "The herbicides should be selected in such a manner so that there is no injury or harm to the succeeding crops.  Proper adoption of crop rotations also helps in the reduction of weed growth.  Most of the herbicides tested/used in potato crop reduced the weed growth in the succeeding crops without having any deleterious effect on yield. Metribuzin and oxyfluorfen have been found to particularly benefit spring potato. ";

        check = (LinkEnabledTextView) findViewById(R.id.linkenabledtextview);
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

        back_Bt = (Button)findViewById(R.id.back);
        back_Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Weedcontrolinsequentialormultiplecropping.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {



    }
}
