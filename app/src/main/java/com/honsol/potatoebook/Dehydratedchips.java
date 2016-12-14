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

public class Dehydratedchips extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dehydratedchips);
        String text  =  "Dehydrated chips\n" +
                "\n" +
                "The potato chip is a fried snack food, which is most popular world over. However, frozen French fries have now superseded the chips in the developed countries. Before processing potatoes into chips, French fries, dehydrated products and canning, certain preliminary unit operations in preparing the potatoes are required. Some of these pre-processing operations, common to all the above processed forms, are as follows:\n" +
                "\n" +
                "Grading: Grading of potatoes is generally done according to the requirements of the product. For instance, medium large round tubers are preferred for chipping since their shape facilitates peeling. On the other hand, the French fry industry prefers large and long or oblong potatoes longer than 90 mm. For canning, small size tubers are selected so that they can be canned whole. The eyes should be shallow for less loss in peeling, particularly during abrasive peeling. Grading is done with the help of mechanical graders. \n" +
                "\n" +
                "Sorting and washing: During sorting, defective potatoes such as damaged and green ones are removed. Stones, any extraneous matter and other unwanted materials are removed manually or mechanically before the potatoes enter the processing line. Potatoes are washed to remove sand, dirt, mud and other extraneous matter. Barrel type washers are commonly used in which the potatoes are simultaneously sprayed with water and tumbled and rubbed against each other and against the sides of the horizontal axis barrel. \n" +
                "\n" +
                "Peeling: Potatoes are peeled by the use of heat (steam), chemicals and abrasive action. Abrasive peelers are available for batch or continuous peeling. Large plants are always equipped with continuous peeling lines to provide smooth and continuous processing. Freshly harvested potatoes can be peeled easily, while in stored potatoes, the peel or periderm is thick and needs strong measures. In steam peeling, there is partial cooking of the potato due to gelatinization of starch above 71 oC, causing a heat ring or cook ring in some processed products like in chips and French fries, which is unacceptable. All the potatoes destined for French fries are peeled by conventional lye (alkali) peeling or infrared dry caustic peeling, as tissue losses by abrasion peeling are excessive. Lye peeling uses a caustic soda solution of 5-15%. The dwell time may be between 10 sec to 1 min depending upon the age of the tubers, followed by thorough washing.\n" +
                "\n" +
                "Washing, sorting and trimming: These operations are important to produce a clean potato free from defects before slicing. It is much easier and more efficient to remove a defective area ahead of slicer before frying. With small tubers, it may be cheaper to eliminate the whole tuber rather than trimming the defect.\n" +
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
                Dehydratedchips.this.finish();
            }
        });

    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}
