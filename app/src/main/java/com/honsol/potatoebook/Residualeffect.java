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

public class Residualeffect extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residualeffect);

        String text = "The recovery of N by potato depends on soil type, amount of water received through rainfall in hills and irrigation in plains, temperature, C/N ratio and most importantly soil organic matter content.  In potato crop, the recovery of N varies between 30-50 per cent.  The unused N is leached down to lower layers in soil. Thus, applied N is expected to leave residual effect the magnitude depending upon various factors like the applied N dose, yield harvested, location, soil type etc.\n" +
                "\n" +
                "Long term studies in alluvial soils of Indo-Gangetic plains revealed that when potato crop is fertilized with recommended dose of N, the wheat crop succeeding potato requires only 50 per cent of its recommended dose of N while sunflower succeeding wheat does not need any N.  Similarly, onion requires only 60 kg N/ha if preceding potato crop is given 150 kg N/ha. It has been established that application of 120 kg N to maize (Kharif), 180 kg N to potato (autumn) and 40 kg N/ha only to wheat (spring) is sufficient in potato-wheat-maize sequence. Thus fertilizer N applied to potato leaves sufficient residual effect on succeeding crop but potato itself does not benefit from the residual N from previous crop, emphasizing that it requires full recommended dose of N. More than 15 per cent of N applied to potato is recovered by succeeding wheat crop indicating that fertilizer input cost can be reduced and fertilizer use efficiency can be increased in multiple cropping system. Potato is grown in cropping systems with other important crops. The fertilizer schedule of important potato based cropping systems are given in table.\n" +
                "\n";
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
                Residualeffect.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}