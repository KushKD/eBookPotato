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

public class EffectofPKonresponsetomoisturestress extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effectof_pkonresponsetomoisturestress);

        String text ="Potassium contributes greatly in helping the plants to achieve water economy. This is true especially in rainfed crop in hills where moisture stress often occurs during plant emergence and tuber initiation stage. Potassium application although does not economize on water needs of the crop, it increases water use efficiency in terms of tubers yield/mm water. Phosphorus on the other hand indirectly helps the plants tolerate water stress by increasing rooting.  ";

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

        back_Bt = (Button) findViewById(R.id.back);
        back_Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EffectofPKonresponsetomoisturestress.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}
