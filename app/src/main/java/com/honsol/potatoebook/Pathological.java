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

public class Pathological extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pathological);
        String text  = "Physiological losses occur through respiration and evaporative loss of water. The magnitude of these losses depends largely on the environmental conditions. The environmental factors that affect the storage behaviour of potatoes are temperature and relative humidity. Physiological damage can occur from exposure to high or low temperatures both before and during storage. Overheating of tubers either due to direct exposure to sunlight or during high temperature and non-refrigerated storage could lead to black heart symptoms. At high temperature storage, the high rate of respiration leads to higher oxygen requirement, which results in asphyxiation leading to breakdown of inner tissues of tubers. Tubers exposed to freezing temperatures also suffer internal damage. Higher tuber respiration during storage results in loss of dry matter. In addition, the heat generated during respiration called respiratory heat also influences the storage temperature and this affects the storage life of potatoes.\n" +
                "\n" +
                "Major weight loss during storage is due to evaporative loss of water. When the loss of water from tubers exceeds 10 percent, the market value of potatoes is greatly reduced because of shriveling. Freshly harvested immature potatoes loose more water than mature tubers because immature skin is more permeable to water. Sprouting results in increased water loss. Sprouting also results in increased respiration leading to higher dry matter loss.\n" +
                "\n" +
                "            The relative humidity in the storage atmosphere affects the weight loss of tubers. Generally a higher relative humidity of 90-95% is maintained in cold stores to minimize weight loss. However, the weight loss is higher under non-refrigerated storage conditions due to lower relative humidity in the atmosphere during the hot summer months. The relative humidity in the storage atmosphere also affects the rate of sprout growth and the form of sprouts. The degree of branching in sprouts is greater under lower humidity levels. Relative humidity also affects wound healing. Wound periderm formation is rapid at higher humidity. For e.g. at a storage temperature of 100C, wound healing is rapid above 80%RH.\n" +
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
                Pathological.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
