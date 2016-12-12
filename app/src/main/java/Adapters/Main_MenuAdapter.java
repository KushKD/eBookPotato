package Adapters;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
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
import com.honsol.potatoebook.CP_Irrigation;
import com.honsol.potatoebook.CP_MainActivity;
import com.honsol.potatoebook.CP_Planting;
import com.honsol.potatoebook.CP_SeedPrepration;
import com.honsol.potatoebook.CP_Weeding;
import com.honsol.potatoebook.Main_Activity;
import com.honsol.potatoebook.PoP_List;
import com.honsol.potatoebook.R;

import java.io.File;

import Utils.Helper;

import static Utils.EConstants.READ_PATH_SDCARD;

/**
 * Created by kuush on 12/12/2016.
 */

public class Main_MenuAdapter extends BaseAdapter {

    String[] result;
    Context context;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public Main_MenuAdapter(Main_Activity mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result = prgmNameList;
        context = mainActivity;
        imageId = prgmImages;
        inflater = (LayoutInflater) context.
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

    public class Holder {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Main_MenuAdapter.Holder holder = new Main_MenuAdapter.Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.optionsmenu, null);
        holder.tv = (TextView) rowView.findViewById(R.id.textView1);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (result[position].toString().equalsIgnoreCase("Potato In India Fact Files")) {

                    File file = new File(READ_PATH_SDCARD + "fact_file.pdf");
                    if (file.exists()) {
                        try {
                            Log.e("File", Boolean.toString(file.exists()));
                            Log.e("File", file.toString());
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromFile(file));
                            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
                            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            context.startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                            Toast.makeText(context, "No PDF Viewer Installed", Toast.LENGTH_LONG).show();
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.adobe.reader")));
                        }

                    } else {
                        Toast.makeText(context, "File Not Found", Toast.LENGTH_LONG).show();
                    }


                } else if (result[position].toString().equalsIgnoreCase("Potato Research In India")) {
                    File file = new File(READ_PATH_SDCARD + "cpri-brow.pdf");
                    if (file.exists()) {
                        try {
                            Log.e("File", Boolean.toString(file.exists()));
                            Log.e("File", file.toString());
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromFile(file));
                            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
                            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            context.startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                            Toast.makeText(context, "No PDF Viewer Installed", Toast.LENGTH_LONG).show();
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.adobe.reader")));
                        }

                    } else {
                        Toast.makeText(context, "File Not Found", Toast.LENGTH_LONG).show();
                    }
                } else if (result[position].toString().equalsIgnoreCase("Cultural Practices")) {
                    // Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context, CP_MainActivity.class);  //TravelTracking
                    context.startActivity(intent);
                } else if (result[position].toString().equalsIgnoreCase("True Potato Seed")) {
                    Intent intent = new Intent(context, CP_Planting.class);  //TravelTracking
                    context.startActivity(intent);
                } else if (result[position].equalsIgnoreCase("Varieties")) {
                    Intent intent = new Intent(context, CP_Fertilization.class);  //TravelTracking
                    context.startActivity(intent);
                } else if (result[position].equalsIgnoreCase("Growing Conditions")) {
                    Intent intent = new Intent(context, CP_Irrigation.class);  //TravelTracking
                    context.startActivity(intent);
                } else if (result[position].equalsIgnoreCase("Groth and Development")) {
                    Intent intent = new Intent(context, CP_Weeding.class);  //TravelTracking
                    context.startActivity(intent);
                } else if (result[position].equalsIgnoreCase("Package of Practices")) {
                    Intent intent = new Intent(context, PoP_List.class);  //TravelTracking
                    context.startActivity(intent);
                } else

                {
                    Toast.makeText(context, "Something went wrong.", Toast.LENGTH_LONG).show();
                }
            }
        });

        return rowView;
    }
}
