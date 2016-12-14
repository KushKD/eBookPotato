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

public class CutWorm extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut_worm);
        String text  = "Cutworms are polyphagous insects of  cosmoplitan distribution. Two species are Agrotis ipsilon (Hfn), A segetum Schiff.,widely distributed in plains and hilly regions, respectively. The larvae (caterpillars) of cutworms damage the crop by cutting the young plants at the base and later on by feeding on shoots and leaves. After tuberisation, they feed on tubers by making deep and irregular galleries in them thus reducing the market value of infested tubers. In badly infested fields tuber damage may vary from 12-40 per cent.\n" +
                "\n" +
                "The Moths are generally not found in North Indian plains between May to September but reappear during October and remain active till March-April. Cutworms can be managed through combination of cultural and chemical control.\n" +
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
                CutWorm.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
