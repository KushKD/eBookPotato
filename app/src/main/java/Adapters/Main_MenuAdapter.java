package Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.honsol.potatoebook.CP_EarthingUp;
import com.honsol.potatoebook.CP_Fertilization;
import com.honsol.potatoebook.CP_Harvesting;
import com.honsol.potatoebook.CP_Haulmscutting;
import com.honsol.potatoebook.CP_Introduction;
import com.honsol.potatoebook.CP_Irrigation;
import com.honsol.potatoebook.CP_LandPrepration;
import com.honsol.potatoebook.CP_MainActivity;
import com.honsol.potatoebook.CP_PlantProtection;
import com.honsol.potatoebook.CP_Planting;
import com.honsol.potatoebook.CP_Processing;
import com.honsol.potatoebook.CP_SeedPrepration;
import com.honsol.potatoebook.CP_Storage;
import com.honsol.potatoebook.CP_Weeding;
import com.honsol.potatoebook.CP_sortingGrading;
import com.honsol.potatoebook.Main_Activity;
import com.honsol.potatoebook.PDFViewActivity;
import com.honsol.potatoebook.PdfViewerActivity;
import com.honsol.potatoebook.R;

import Utils.Helper;

/**
 * Created by kuush on 12/12/2016.
 */

public class Main_MenuAdapter extends BaseAdapter {

    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;

    public Main_MenuAdapter(Main_Activity mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }



    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Main_MenuAdapter.Holder holder=new Main_MenuAdapter.Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.optionsmenu, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(result[position].toString().equalsIgnoreCase("Potato In India Fact Files")){

                    Log.e("File Name",Helper.getAssetsPdfPath(context));

                    Intent intent = new Intent(context, PDFViewActivity.class);
                        intent.putExtra(PdfViewerActivity.EXTRA_PDFFILENAME, Helper.getAssetsPdfPath(context));
                       context.startActivity(intent);

                }else if (result[position].toString().equalsIgnoreCase("Potato Research In India")){
                    // Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context,CP_SeedPrepration.class);
                    context.startActivity(intent);
                }else if (result[position].toString().equalsIgnoreCase("Cultural Practices")){
                    // Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context,CP_MainActivity.class);  //TravelTracking
                    context.startActivity(intent);
                }else if(result[position].toString().equalsIgnoreCase("True Potato Seed")){
                    Intent intent = new Intent(context,CP_Planting.class);  //TravelTracking
                    context.startActivity(intent);
                }else if(result[position].equalsIgnoreCase("Varieties")) {
                    Intent intent = new Intent(context,CP_Fertilization.class);  //TravelTracking
                    context.startActivity(intent);
                }else if(result[position].equalsIgnoreCase("Growing Conditions")) {
                    Intent intent = new Intent(context,CP_Irrigation.class);  //TravelTracking
                    context.startActivity(intent);
                }else if(result[position].equalsIgnoreCase("Groth and Development")) {
                    Intent intent = new Intent(context,CP_Weeding.class);  //TravelTracking
                    context.startActivity(intent);
                }else if(result[position].equalsIgnoreCase("Package of Practices")) {
                    Intent intent = new Intent(context,CP_EarthingUp.class);  //TravelTracking
                    context.startActivity(intent);
                }
                else

                {
                    Toast.makeText(context, "Something went wrong.", Toast.LENGTH_LONG).show();
                }
            }
        });

        return rowView;
    }
}
