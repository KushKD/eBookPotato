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

public class MethordOfApplication extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methord_of_application);

        String text = "The proper placement of fertilizer has a great influence on P and K utilization and subsequently their effect on fertilizer use efficiency. Under rainfed conditions, the moisture stress at early growth stages or excess rains after planting have a direct bearing on the utilization of applied nutrients. This is true for K, a highly mobile nutrient prone to leaching or it may be washed out as surface run off in hills. \n" +
                "\n" +
                "P&K are invariably placed in bands near the seed tubers.  This is because P is easily fixed and the more it comes in contact with the soil the greater is the fixation.  Therefore, minimum contact with the soil is needed in this case.  In the case of K also, it is placed since it also gets fixed though in this case it comes into the solution whenever needed. Because of its low mobility and P fixation in acidic and laterite soils, its placement near the active root zone or near the seed tuber is recommended. Therefore its furrow placement has been found more economical than broadcasting or band placement in acidic hill soils of Shimla and Shillong. \n" +
                "\n" +
                "\n" +
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
                MethordOfApplication.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}
