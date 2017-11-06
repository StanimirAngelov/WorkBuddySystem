package com.stan.loginregister;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.text.method.DateTimeKeyListener;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class AddRoster extends Activity
{
    private Intent intent;
    Calendar mycalendar = Calendar.getInstance().getInstance();


/*
//timepicker
    static int hour, min;
    TextView Start, End;
    Button btntimepicker1;
    java.sql.Time timeValue;
    Calendar c;
    int year, month, day;
*/


    //date picker
    EditText R_Date;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_roster);
        Toast.makeText(getApplicationContext(),"Broken on adding roster"+ 1 + 2, Toast.LENGTH_LONG).show();


        R_Date = (EditText) findViewById(R.id.R_Date);
     final EditText Start = (EditText) findViewById(R.id.Start);
      final EditText End = (EditText) findViewById(R.id.End);


        Button btnUpload = (Button) findViewById(R.id.btnUpload);


        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    /*

                    if (success)
                    {

                        String[] Username = jsonResponse.getJSONArray("Username");

                        Spinner spinner = (Spinner) findViewById(R.id.UserNames);

                        List<String> list = new ArrayList<String>();
                        list.add(Usename);

                        //create array adapter using default spinner layout and arry list
                        ArrayAdapter<String > adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
                        //specify the layout ti use when the list choice apear
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        //apply addapte to spiner
                        spinner.setAdapter(adapter);

                        //add listener to spinner
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                //using i as selecton from list of item

                            }

                            ArrayList<AdapterItem>    listnewsData = new ArrayList<AdapterItem>();
                            createroster.MyCustomAdapter myadapter;

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });


                    }
*/


                }catch (JSONException e)
                {
                    e.printStackTrace();
                }


            }
        };

        GetEmpRequest getemprequest = new GetEmpRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(AddRoster.this);
        queue.add(getemprequest);




/*
        //timer code
        c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        min = c.get(Calendar.MINUTE);

        btntimepicker1 = (Button)findViewById(R.id.btntimepicker1);

        btntimepicker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog td = new TimePickerDialog(DatePicker.this,
                        new TimePickerDialog().OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                try {
                                    String dtStart = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
                                 //   format = new SimpleDateFormat("HH:mm");

                                 //   timeValue = new java.sql.Time(format.parse(dtStart).getTime());
                                    Start.setText(String.valueOf(timeValue));
                                    String amPm = hourOfDay % 12 + ":" + minute + " " + ((hourOfDay >= 12) ? "PM" : "AM");
                                    Start.setText(amPm + "\n" + String.valueOf(timeValue));
                                } catch (Exception ex) {
                                    Start.setText(ex.getMessage().toString());
                                }
                            }
                        },
                        hour, min,
                      //  DateFormat.is24HourFormat(DateTimePicker.this)
            //    );
                td.show();
            }
        });

*/








        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = R_Date.getText().toString();
                int TStart = Integer.parseInt(String.valueOf(Start));
                int TEnd = Integer.parseInt(String.valueOf(End));
                String rdate = R_Date.toString();

                Response.Listener<String> responseListener = new Response.Listener<String>()
                {
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            Log.v("we made it this far", R_Date +"");

                            if (success)
                            {




                            }



                        }catch (JSONException e)
                        {
                            e.printStackTrace();
                        }


                }
                };

                AddRosterRequest addrosterrequst = new AddRosterRequest(rdate, 2 , 1, TStart, TEnd, responseListener);
                RequestQueue queue = Volley.newRequestQueue(AddRoster.this);
                queue.add(addrosterrequst);

            }



        });


        R_Date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddRoster.this, date, mycalendar
                        .get(Calendar.YEAR), mycalendar.get(Calendar.MONTH),
                        mycalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }





    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener()
    {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth)
        {
            // TODO Auto-generated method stub
            mycalendar.set(Calendar.YEAR, year);
            mycalendar.set(Calendar.MONTH, monthOfYear);
            mycalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };



    private void updateLabel()
    {

        String myFormat = "yyyy/MM/dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.UK);

        R_Date.setText(sdf.format(mycalendar.getTime()));
    }


}




