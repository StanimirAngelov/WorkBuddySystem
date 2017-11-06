package com.stan.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserAreaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final Intent intent = getIntent();
         String name = intent.getStringExtra("name");
        final String username = intent.getStringExtra("username");
        String Role = intent.getStringExtra("Role");
        final  int UserID = intent.getIntExtra("UserID", 0);
        final int DeptID = intent.getIntExtra("DeptID",0);

        Button addPayslip = (Button) findViewById(R.id.addPayslip); //button initialized for add roster page connection
        Button addRoster = (Button) findViewById(R.id.addRoster); //connect to addroster page
      //  Button addMap = (Button) findViewById(R.id.addMap);

        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        Toast.makeText(getApplicationContext()," broken on userareactivity "+ UserID + DeptID, Toast.LENGTH_LONG).show();

        //button to connect to AddRoster page
        addRoster.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {

                                             Log.v("we are here","yay");
                                             Intent AddRoster = new Intent(getApplicationContext(), AddRoster.class);
                                             intent.putExtra("Username", username);

                                             //send data to new activity
                                             // Log.e("n");
                                             startActivity(AddRoster);


                                         }
        });
        //connect to add payslip page
        addPayslip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddPayslip = new Intent(getApplicationContext(), AddPayslip.class);
                startActivity(AddPayslip);
            }
        });

        /*
        addMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent AddMaps = new Intent(getApplicationContext(), AddMaps.class);
                startActivity(AddMaps);

            }
        });
        */

    }
}



       /* // Display user details
        String message = name + " welcome to your user area";
        tvWelcomeMsg.setText("hi boss: "+ Role);
*/