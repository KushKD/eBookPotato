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

public class Chemicalweedcontrol extends AppCompatActivity implements TextLinkClickListener {
    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemicalweedcontrol);
        String text = "Manual and mechanical weeding ignores early flush of weeds during the emergence of crop. Weed control through herbicides is quicker and less laborious hence large areas can be covered in a short period of time with limited labour. Chemical weed control in seed production programme also minimizes the spread of contagious viruses X and S since possibilities of contact with the plants is reduced in this case.  The chemicals used for control of weeds are called herbicides. They demand considerable skill in their application. Those that are volatile in nature should be applied to the soil before making the ridges and mixed thoroughly to reduce losses due to volatilization and photodecomposition. The contact and systemic herbicides should be applied only when weeds appear. In case of residual herbicides, it is essential that there is no cultivation done after spraying, therefore, the soil should be well prepared before planting.  The herbicides  are classified according to their time of application as\n" +
                "\n" +
                "Pre-planting herbicides:  They are applied before planting and mixed with the soil to avoid volatilization losses. The important pre-planting herbicides for potato are fluchloralin and pendimethalin.\n" +
                "\n" +
                "Pre-emergence herbicides:  They are applied within 3-5 days after planting the crop or just before the emergence of weeds and crop. The pre-emergence herbicides for potato crop are 2,4-D, alachlor, atrazine, isoproturon, linuron, methabenzthiazuron, oxyfluorfen, metribuzin and simazine. \n" +
                "\n" +
                "Post-emergence herbicides: These are applied after the emergence of weeds or crop. The post-emergence herbicides for potato are paraquat (applied at about 5% emergence of potato crop) and propanil (applied at one to three leaf stage of the weeds).\n" +
                "\n" +
                "The herbicides effective for weed control in potato depending on their availability, cost, weed flora and the cropping pattern followed are listed in table.";

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
                Chemicalweedcontrol.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {



    }
}
