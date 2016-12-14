package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;
import Utils.Custom_Dialog;

public class Aphids extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aphids);
        String text  = "Aphids constitute a major group of pests infesting potato crop. They are extremely important being vectors of many potato viruses.  Both the adults and nymphs suck the leaf sap. Aphids transmit potato virus Y (PVY) and potato leaf roll virus (PLRV).\n" +
                "\n" +
                "The aphids start appearing on potato crop in the North- Western plains of India from the second week of November, and in the Eastern plains in early December, reaching the critical level (20 aphids per 100 compound leaves) by the end of December in the former and during1-2nd week of January in the latter area. In the North- Western higher hills i.e. from Kashmir to Kumaon and in North-Eastern hills, the critical  level  generally reaches  by the end of July. In the plateau region of Maharashtra, aphid infestation remains almost negligible in Kharif crop while on Rabi crop, it appears in the second week of November and critical level reaches by the third week of December.  The management of aphids involves monitoring its appearance and then controlling them through use of chemicals.\n" +
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
                Aphids.this.finish();
            }
        });

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Aphids.this,"aphidgp");
            }
        });


        ImageView  imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Aphids.this,"aphidgpwinged");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
