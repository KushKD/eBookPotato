package Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.honsol.potatoebook.R;

import java.util.List;

import Modal.PP;

/**
 * Created by kuush on 12/12/2016.
 */

public class BinderData_DFSC extends ArrayAdapter<PP> {

    private Context context;
    private List<PP> DfscCollection;


    public BinderData_DFSC(Context context, int resource, List<PP> objects) {
        super(context, resource, objects);
        this.context = context;
        this.DfscCollection = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_in, parent, false);


        //Display flower name in the TextView widget
        PP ip = DfscCollection.get(position);
        TextView tv = (TextView) view.findViewById(R.id.textView1_room_no);
        //  TextView tv2 = (TextView)view.findViewById(R.id.textView2_floor_entrance);




        tv.setText(ip.getName());
        // tv2.setText(ip.getAddress());


        return view;
    }
}
