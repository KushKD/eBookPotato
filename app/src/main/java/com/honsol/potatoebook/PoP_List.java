package com.honsol.potatoebook;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import Adapters.BinderData_DFSC;
import Modal.PP;
import Utils.EConstants;

import static Utils.EConstants.READ_PATH_SDCARD;

public class PoP_List extends AppCompatActivity {

    static final String filename_dfsc = "PPData.xml";
    List<PP> InsObjectList;
    ListView list;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po_p__list);

        DFSC_Async DA = new DFSC_Async();
        DA.execute(filename_dfsc);

        list = (ListView) findViewById(R.id.list);

        pb = (ProgressBar) findViewById(R.id.progressBar1);
        pb.setVisibility(View.VISIBLE);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub

                PP dd = (PP) parent.getItemAtPosition(position);
                Log.e("FILE Name is:", dd.getFilename());

                //TODO

                File file = new File(READ_PATH_SDCARD + dd.getFilename());
                if (file.exists()) {
                    try {
                        Log.e("File", Boolean.toString(file.exists()));
                        Log.e("File", file.toString());
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromFile(file));
                        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(PoP_List.this, "No PDF Viewer Installed", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.adobe.reader")));
                    }

                }
            }
        });
        }


    class DFSC_Async extends AsyncTask<String, String, List<PP>> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // pb.setVisibility(View.VISIBLE);



        }

        @Override
        protected List<PP> doInBackground(String... params) {

            File file = new File(EConstants.READ_PATH_SDCARD + params[0]);
            InputStream is = null;
            try {
                is = new FileInputStream(file.getPath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = null;
            try {
                docBuilder = docBuilderFactory.newDocumentBuilder();

            } catch (ParserConfigurationException e) {
                Log.e("@@@@",e.getLocalizedMessage());
            }
            try {
                Log.e("filename","Are We Here");
                Document doc = docBuilder.parse(new InputSource(is));
                Log.e("filename","Are We Here 2");

                InsObjectList = new ArrayList<>();
                Log.e("filename","Are We Here3");
                doc.getDocumentElement().normalize();
                Log.e("filename","Are We Here4");
                NodeList INSList = doc.getElementsByTagName("dfscdata");

                List<PP> map = null;

                for (int i = 0; i < INSList.getLength(); i++) {
                    System.out.println(Integer.toString(INSList.getLength()));
                    map = new ArrayList<>();
                    PP INP = new PP();
                    Node firstWeatherNode = INSList.item(i);
                    if (firstWeatherNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element firstWeatherElement = (Element) firstWeatherNode;
                        //-------
                        NodeList idList = firstWeatherElement.getElementsByTagName("sno");
                        Element firstIdElement = (Element)idList.item(0);
                        NodeList textIdList = firstIdElement.getChildNodes();
                        //--sno
                        INP.setSno(textIdList.item(0).getNodeValue().trim());

                        //2.-------
                        NodeList cityList = firstWeatherElement.getElementsByTagName("filename");
                        Element firstCityElement = (Element)cityList.item(0);
                        NodeList textCityList = firstCityElement.getChildNodes();
                        //--district
                        INP.setFilename(textCityList.item(0).getNodeValue().trim());

                        //3.-------
                        NodeList tempList = firstWeatherElement.getElementsByTagName("Name");
                        Element firstTempElement = (Element)tempList.item(0);
                        NodeList textTempList = firstTempElement.getChildNodes();
                        //--address
                        INP.setName(textTempList.item(0).getNodeValue().trim());


                        InsObjectList.add(INP);
                    }


                }
            }catch (Exception e){
                Log.e("Error:", e.getLocalizedMessage());
            }
            return  InsObjectList;
        }


        @Override
        protected void onPostExecute(List<PP> s) {
            super.onPostExecute(s);
            updateui(s);
        }

        private void updateui(List<PP> listCollection) {

            BinderData_DFSC bindingData = new BinderData_DFSC(PoP_List.this, R.layout.item_in, listCollection);




            Log.i("BEFORE", "<<------------- Before SetAdapter-------------->>");

            list.setAdapter(bindingData);

            Log.i("AFTER", "<<------------- After SetAdapter-------------->>");
            pb.setVisibility(View.INVISIBLE);
        }
    }
}
