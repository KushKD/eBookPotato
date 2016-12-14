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

public class Countrystores extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrystores);
        String text  = "The following non-refrigerated storage systems are effective for storing potatoes for 3-4 months under hot summer conditions in India..\n" +
                "\n" +
                "Evaporatively Cooled Potato Store: The daily maximum temperatures inside the ECPS remain 6-130C lower than the ambient temperature during March-June. Relative humidity remains high at 72-98%. The weight loss in potato tubers during storage is significantly reduced. Ware potatoes can be stored in good condition up to the beginning of June. During storage, reducing sugars in potatoes decrease and chip colour improves. Thus potatoes stored in ECPS become suitable for processing after 90 days of storage (Potatoes produced in North-western plains are otherwise unsuitable for processing due to high levels of reducing sugars at harvest). Storage life of potatoes can be further extended up to the end of June by treating the tubers with sprout suppressants like maleic hydrazide (MH) and isopropyl N-3-chlorophenyl carbamate (CIPC). This technology is suitable for regions where the temperatures are high and humidity is low during the storage period.\n" +
                "\n" +
                "On-farm storage in heaps and pits: The traditional methods of storing potatoes in heaps and pits are very useful for storing small quantity of potatoes for 3-4 months. The traditional methods are very cheap and high investment is not needed on storage structures and so is readily acceptable to farmers. Potatoes are being stored by traditional methods in states of Assam, Bihar, U.P, M.P., Gujarat, Maharashtra and Karnataka. Heaps and pits are the most common methods of potato storage in the plains and plateau regions and the stored potatoes are suitable for processing. Heaps are made by heaping potatoes in the shade of a tree to a maximum height of 1m and covering them with 1 foot thick wheat/rice straw or sugarcane trash. Pits are dug in the shade of a tree and there are two types of pits viz. pakka and katcha. Pakka pits are lined with bricks and are made in the form of a well. An average katcha pit measures 6 x 4.5 x 4.5 m (Length x Breadth x Width) and an average pucca pit measures 3.5 x 4.5m (Diameter x Depth). Generally 5-30 tonnes of potatoes are stored in heaps and 10-40 tonnes of potatoes are stored in pits.Storage losses in heaps and pits could be quite high if proper care is not taken. Potatoes stored in heaps and pits are suitable for processing due to their higher dry matter and lower reducing sugars content.\n" +
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
                Countrystores.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
