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

public class SourceMicro  extends  AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_micro);

        String text  = "Sulphate salts of different micro-nutrients are the common sources of micro-nutrients. Correction of zinc and copper deficiencies may be made by inorganic fertilizers, e.g. zinc sulphate and copper sulphate or chelates. Application of farmyard manure at 10 tons/ha is able to meet zinc requirements of potato crop. Iron sprays best accomplish correction of deficiencies of iron in the field. Foliar sprays with acidified solution of 0.3% ferrous sulphate or with 0.1% iron citrate has been found to reduce iron chlorosis and significantly increase potato tuber yield of cv. Kufri Jawahar. Fe-EDDHA can also be used successfully in the field. ";

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
                SourceMicro.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}