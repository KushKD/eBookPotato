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

public class CP_EarthingUp extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__earthing_up);
        String text  =  "As the name itself indicates earthIng up refers to the practise of remaking up the ridge by bringing soil from the furrow and putting it back on the ridges.  Thus it refers to the practise of making up the ridges in an intercultural operation.  This operation is normally done at stolonization stage because if done later stolons and roots are liable to be damaged.\n" +
                "\n" +
                " In the case of manual cultivation, earthing up is done using hand tools like Khurpa.  Where bullocks are used for earthing up, a bullock drawn plough is used for earthing up while in the case of mechanical cultivation, a ridger is used for earthing up.\n" +
                "\n" +
                "Earthing up is necessary so that the emerging stolons as well as developing tubers are covered by soil.  In situations where planting is done shallow for quick emergence, the emerging stolons and developing tubers have to be covered fully with soil by a secondary tillage operation called earthing up.  This is because the soil cover at planting is not sufficient and exposure of the stolons to light may lead to it becoming an aerial stem.  In the case of light soils, irrigations erode the ridge making it smaller and smaller with each irrigation and hence has to be remade at the time of stolon development.  This is done through earthing up.";
        check = (LinkEnabledTextView)findViewById(R.id.linkenabledtextview) ;
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
                CP_EarthingUp.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        //Log.e("Hyperlink is :: " + clickedString, "Hyperlink is :: " + clickedString);
        if(clickedString.equalsIgnoreCase("_ridger")){
           //TODO Photo
        }else{
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}
