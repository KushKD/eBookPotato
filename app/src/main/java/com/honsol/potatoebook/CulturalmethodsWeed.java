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

public class CulturalmethodsWeed extends AppCompatActivity implements TextLinkClickListener {
    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culturalmethods_weed);
        String text = "Physical methods of weed control require manual energy, animal power or fuel to work implements that dig out weeds. Pulling-out of weeds by hand or removal by hand trowel, hand hoe, spades etc. is the oldest and still widely practiced and most efficient method for reducing weed growth in potato crop. It is very effective against both annual and biennial weeds. This method is also useful for the destruction of weeds growing within the rows which cannot be controlled by cultivation.\n" +
                "\n" +
                "Animal-drawn implements viz three-tine-cultivator (Triphali) is a useful implement for weeding and tilling operations in potato. Tractor-mounted cultivator consisting of nine spring tines with narrow reversible shovels fitted to a tractor tool bar is also used for weed control as it cultivates three potato rows at a time thus removing the weeds present in these rows.\n" +
                "\n" +
                "Mulching is also an effective practice for reducing the growth of annual weeds in potato. It has smothering effect on weeds and also provides an effective barrier to weed emergence. In addition, mulching conserves soil moisture resulting in quick emergence and growth of potato thus gaining competitive advantage. Dry straw, grasses, pine needles and other plant as well as plastic sheets and polythene films can be used as mulching materials. It should be ensured that the mulch is sufficiently thick to prevent transmission of light for suppressing photosynthesis by weeds.\n" +
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

        back_Bt = (Button)findViewById(R.id.back);
        back_Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CulturalmethodsWeed.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {



    }
}
