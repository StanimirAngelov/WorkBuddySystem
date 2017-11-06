package com.stan.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class createroster extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createroster);
        //add to second page
        Intent intent = getIntent();
       // String message = intent.getStringExtra(UserAreaActivity.EXTRA_MESSAGE);
        //capture the layout text vuew and set string ast its text
        TextView textView = (TextView) findViewById(R.id.textView);
      //  textView.setText(message);





       Spinner spinner = (Spinner) findViewById(R.id.spinner_id);

        List<String> list = new ArrayList<String>();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");

        //create array adapter using default spinner layout and arry list
        ArrayAdapter<String > adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        //specify the layout ti use when the list choice apear
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //apply addapte to spiner
        spinner.setAdapter(adapter);

        //add listener to spinner
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //using i as selecton from list of item
                switch (i){
                    case 0:
                        Toast.makeText(getApplicationContext(),"Monday", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"Tuesday", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Wednesday", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"Thursday", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),"Friday", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(getApplicationContext(),"Saturday", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(getApplicationContext(),"Sunday", Toast.LENGTH_SHORT).show();
                        default:
                }
            }

            ArrayList<AdapterItem>    listnewsData = new ArrayList<AdapterItem>();
            MyCustomAdapter myadapter;

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }



    ArrayList<AdapterItem> listnewsData = new ArrayList<AdapterItem>();
    AdapterItem myadapter;

    //display news list
    class MyCustomAdapter extends BaseAdapter {
        public  ArrayList<AdapterItem>  listnewsDataAdpater ;

        ListView lvlist = (ListView)findViewById(R.id.lvlist);
        //adapter class


     /*   //add data and view it
    listnewsData.add(new AdapterItem(1,"20/3/5"," 10:00","18:00"))
    listnewsData.add(new AdapterItem(4,"sdf"," 12:00","18:00"));
        myadapter =new AdapterItem (listnewsData);
    lvlist.setAdapter(myadapter);

*/
        public MyCustomAdapter(ArrayList<AdapterItem>  listnewsDataAdpater) {
            this.listnewsDataAdpater=listnewsDataAdpater;
        }




        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_roster, null);

            final   AdapterItem s = listnewsDataAdpater.get(position);

            //if i want to change elements and add more i have to add them here
            // myView is used to say this view layout_roster
            TextView tvID=( TextView)myView.findViewById(R.id.tvID);
            tvID.setText(s.ID);

            TextView tvDates=( TextView)myView.findViewById(R.id.tvDates);
            tvID.setText(s.Dates);

            TextView tvStartTime=( TextView)myView.findViewById(R.id.tvStartTime);
            tvID.setText(s.StartTime);

            TextView tvEndTime=( TextView)myView.findViewById(R.id.tvEndTime);
            tvID.setText(s.EndTime);
            return myView;
        }

    }




}
