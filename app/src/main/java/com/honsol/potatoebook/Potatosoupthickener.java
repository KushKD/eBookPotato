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

public class Potatosoupthickener extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potatosoupthickener);
        String text  =  "Potato starch powder and potato flour-starch combination (1:1) was found to be good thickening agents. Addition of 2% of these thickening agents were effective in bringing the desired consistency in the tomato and chicken soups and comparatively superior than commercially available corn flour. Based on taste, colour and homogeneity of tomato soup, the potato starch was adjudged the best followed by corn flour and potato flour-starch combination. \n" +
                "\n" +
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
                Potatosoupthickener.this.finish();
            }
        });

    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}
