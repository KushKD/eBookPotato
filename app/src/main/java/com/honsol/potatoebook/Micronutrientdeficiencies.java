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

public class Micronutrientdeficiencies  extends  AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micronutrientdeficiencies);

        String text  = "Micronutrient deficiencies\n" +
                "\n" +
                "Diagnosis is the first step for precise monitoring and efficient correction of micro-nutrient disorders in potato plants and soils. Several approaches that have been used to diagnose the magnitude of micro-nutrient deficiencies:\n" +
                "\n" +
                "Visual diagnosis\n" +
                "\n" +
                "Signs of stress will appear whenever any one of the micro-nutrients becomes severely deficient or well beyond the “marginal deficiency stage” of development. Each element develops its own characteristic deficiency symptoms.  Visual diagnosis of symptoms is possible as soon as the symptoms have appeared.\n" +
                "\n" +
                "Deficiency symptoms\n" +
                "\n" +
                "Zinc: Deficient plants show severe stunting and bronzing or yellowing of the foliage, usually around the leaf margins, starting from the tips. Zinc deficiency in potato, often known as fern leaf or little leaf, appears on young leaves. The youngest leaves are cupped upwards and rolled to such an extent that the terminal growth resembles that of ferns. Leaves of affected plants are smaller and their upper inter-nodes shorter.\n" +
                "\n" +
                "Iron:  Its deficiency appears initially as yellowing of top young leaves. With time, the leaves become light yellow to nearly white. During the deficiency, blade tips remain green for a longer time. Netted green veination is seen when traces of iron are absorbed and translocated along the veins for chlorophyll formation. Green veination is actually a sign of iron recovery.\n" +
                "\n" +
                "Manganese:  The first sign of its deficiency is yellowing and slight cupping of younger leaves. Pinkish colour develops at the base of younger chlorotic leaves while relatively old leaves show dark to black spots. With increased deficiency, dark to black spotting develops between the veins with increased spotting, appearing along larger veins and the mid rib. The symptoms of darkening and cupping of leaves, increase in severity with time. Upon mild deficiency, upper parts of the plants become somewhat chlorotic but do not develop dead spots.\n" +
                "\n" +
                "Copper:  An early sign of its deficiency is the development of a uniform, light green colour of young, immature leaf blades similar to those of molybdenum, manganese and iron deficiencies. Thereafter, it is primarily seen as pronounced upward cupping and inward rolling of the young, relatively large, leaf blades. This is in sharp contrast to the small, narrow leaf blades of zinc deficiency.\n" +
                "\n" +
                "Boron:  Its deficiency causes the formation of a bushy plant with droopy leaves. Blades crinkle, cup upwards and are bordered by light brown tissue. Its deficiency, like calcium, affects the growing points. Immature center leaves become deformed and the growing point dies. In case of mild boron deficiency, slight upward curling of the margins of the older leaves is visible.\n" +
                "\n" +
                "Molybdenum:  The symptoms of its deficiency are – marked chlorosis, associated with reduction in growth and yield.\n" +
                "\n" +
                " \n" +
                "\n" +
                "\n" +
                "Back";

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
                Micronutrientdeficiencies.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}