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

public class BlackScurf extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_scurf);
        String text  = "The affected tubers appear shabby with black mass sticking on the tubers which leads to lower economic return.  Normally yield losses to the extent of 25% in the hills and 10% in the plains have been reported.\n" +
                "\n" +
                "The emerging sprouts when infected develop cankers causing girdling of the stem bases.  The affected plants show upward rolling of leaves with pinkish or purplish margin.\n" +
                "\n" +
                "The roots and emerging stolons also get infected having rottage of cortical tissues.  Therefore infected plants have poor root system and infected stolons give rise to deformed tubers.\n" +
                "\n" +
                "The tubers from infected plants show dark brown to black irregular lumps sticking on the surface of tubers. \n" +
                "\n" +
                "Tubers may also show skin cracks, crater like depressions, pitting, stem end necrosis and shape deformity.\n" +
                "\n" +
                " ";

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
                BlackScurf.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
