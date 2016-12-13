package com.honsol.potatoebook;

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

public class ImportanceOfN extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importance_of_n);

        String text  =  " Nitrogen is the first limiting nutrient in potato production that greatly influences crop growth, tuber yield and its quality. A mature crop of potato yielding 25-30 t/ha removes 120-140 kg N/ha. The Indian soils are generally deficient in organic matter and thus are unable to release N at the rate required to maintain adequate N supply to the growing plant. Therefore, application of nitrogen in form of fertilizers and manures becomes indispensable to meet N needs of the crop. The potato plants with sufficient N are characterized by vigorous growth, high leaf area, more number of large size tubers. Its deficiency on the other hand leads to slow growth of the plants which are weak and pale. The leaf margins show pale green coloration in initial stages, later the full leaf turns pale yellow during acute deficiency. These symptoms first appear at the lower leaves and later on the whole plant gives yellowish look with dropping lower leaves. On the other hand excess of N delays tuber initiation and onset of linear phase of tuber growth ultimately resulting in lower yield. ";

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
                ImportanceOfN.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        //Log.e("Hyperlink is :: " + clickedString, "Hyperlink is :: " + clickedString);

    }
}