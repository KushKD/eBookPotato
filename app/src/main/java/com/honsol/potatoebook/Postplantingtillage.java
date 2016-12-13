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

public class Postplantingtillage extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String text2 = "The post emergence tillage is done to control weeds as well as to make up the ridge to its full size as it would have eroded due to irrigations, especially in light soils   Normally in the northern Indo Gangetic plains a 9 tyne tiller is run in the furrows about 20-25 days after planting in the main crop.  This would remove the weeds which are present in the furrows.  The weeds near the plants are removed through hand weeding.  Following the tillering operation, a ridger is operated after application of the split dose of N so that the fertilizer is covered by the soil during the earthing up process.  This increases the ridge size and ensures adequate protection to the emerging stolons and tubers.";

        setContentView(R.layout.activity_postplantingtillage);
        check = (LinkEnabledTextView)findViewById(R.id.linkenabledtextview) ;

        check.setOnTextLinkClickListener(this);
        check.gatherLinksForText(text2);
        check.setTextColor(Color.BLACK);
        check.setLinkTextColor(Color.BLUE);

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
                Postplantingtillage.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}
