package com.honsol.potatoebook;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class Resistanceagainstfrost extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistanceagainstfrost);

        String text  ="Frost is almost a regular feature in December-January in the north-western plains i.e. Punjab and western Uttar Pradesh, resulting in yield losses up to 40 per cent. Observations on frost injury to potato plant reveal a strong interaction between frost injuries and K nutrition in K deficient soils. Potato crop grown on soils supplied with sufficient quantity of K suffer less from frost injury.  The high K concentration in leaf helps in lowering the freezing point of cell sap thereby helps the plant to escape frost injury. Potato varieties also differ with regard to their susceptibility to frost injury. Kufri Chandramukhi and Gulmarg Special are highly susceptible while Kufri Sindhuri is least susceptible. In general, highly frost susceptible varieties are highly responsive to K. \n" +
                "\n" +
                "\n";
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

        back_Bt = (Button)findViewById(R.id.back);
        back_Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resistanceagainstfrost.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}