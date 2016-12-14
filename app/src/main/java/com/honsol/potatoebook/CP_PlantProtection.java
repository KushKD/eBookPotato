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

public class CP_PlantProtection extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__plant_protection);
        String text  =  "Plant protection refers to the practices adopted for controlling the pests and diseases attacking the potato crop.  Potato crop is infested by a variety of fungal, bacterial and viral diseases.  As regards pests, some pests attacks the foliage while some attacks the tubers.  Many of the diseases in potato are soil/seed borne and so once infected is very difficult to control them.  Similarly viruses affect the seed quality and so has a chain of implications.  Thus proper diagnosis and control of pests and diseases is of utmost importance. Some of the important pests and diseases attacking the potato crop are _late_blight, _early_blight, _wart, _common_scab, _black_scurf, _bacterial_wilt, _soft_rot_black_leg, _viruses, _cutworm, _white_grub, _aphids, _leaf_hoppers, _tuber_moth, _mites, _potato_cyst_nematode, _root_knot_nematode etc. Not all pests and diseases are present every where.  Some of them are more widespread than the other while some are very localized e.g. Wart is one such disease, which is confined to the Darjeeling hills while golden nematode is another such pest, which is confined to the Nilgiri hills.";
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
                CP_PlantProtection.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

//Log.e("Hyperlink is :: " + clickedString, "Hyperlink is :: " + clickedString);
        if(clickedString.equalsIgnoreCase("_late_blight")){
            Intent c =  new Intent(CP_PlantProtection.this,Lateblight.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_early_blight")){
            Intent c =  new Intent(CP_PlantProtection.this,EarlyBlight.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_wart")) {
            Intent c =  new Intent(CP_PlantProtection.this,Wart.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_common_scab")) {
            Intent c =  new Intent(CP_PlantProtection.this,Scrab.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_black_scurf")) {
            Intent c =  new Intent(CP_PlantProtection.this,BlackScurf.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_bacterial_wilt")) {
            Intent c =  new Intent(CP_PlantProtection.this,Bacterialwilt.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_soft_rot_black_leg")) {
            Intent c =  new Intent(CP_PlantProtection.this,SoftRotBlackLeg.class);
            startActivity(c);

        }else if(clickedString.equalsIgnoreCase("_viruses")) {
            Intent c =  new Intent(CP_PlantProtection.this,Virus.class);
            startActivity(c);

        }else if(clickedString.equalsIgnoreCase("_cutworm")) {
            Intent c =  new Intent(CP_PlantProtection.this,CutWorm.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_aphids")) {
            Intent c =  new Intent(CP_PlantProtection.this,Aphids.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_white_grub")) {
            Intent c =  new Intent(CP_PlantProtection.this,Whitegrubs.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_tuber_moth")) {
            Intent c =  new Intent(CP_PlantProtection.this,Tubermoth.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_leaf_hoppers")) {
            Intent c =  new Intent(CP_PlantProtection.this,Leafhoppers.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_mites")) {
            Intent c =  new Intent(CP_PlantProtection.this,Mite.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_potato_cyst_nematode")) {
            Intent c =  new Intent(CP_PlantProtection.this,Cystnematode.class);
            startActivity(c);
        }else if(clickedString.equalsIgnoreCase("_root_knot_nematode")) {
            Intent c =  new Intent(CP_PlantProtection.this,RootKnot.class);
            startActivity(c);
        }else
        {
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}
