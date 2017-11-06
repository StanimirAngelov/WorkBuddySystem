package com.stan.loginregister;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        final Button bLogin = (Button) findViewById(R.id.bSignIn);

        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                String Role = jsonResponse.getString("Role");
                                int UserID = jsonResponse.getInt("UserID");
                               int DeptID = jsonResponse.getInt("DeptID");

                                Log.v("we made it this far", Role +"");
                               Log.v("Users ID = ", UserID+"");
                                Log.v("Department ID = ", DeptID+"");



                                if (Role.equals("Admin"))
                                {

                                  // toast to set .setText("DeptID = " +Role+"" + "UserID = " + Role + "");
                                    Toast.makeText(getApplicationContext(),"userID and DeptID but broken in Login Activity"+ UserID + DeptID, Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(LoginActivity.this, UserAreaActivity.class);
                                    intent.putExtra("Role", Role);
                                    intent.putExtra("Username", username);
                                    intent.putExtra("UserID",UserID);
                                    intent.putExtra("DeptID", DeptID);

                                    LoginActivity.this.startActivity(intent);

                                }

                                if(Role.equals("Employee"))
                                {
                                    Intent intent = new Intent(LoginActivity.this, EmployeeActivity.class);
                                    intent.putExtra("Username", username);
                                    LoginActivity.this.startActivity(intent);

                                }

                                else
                                {
                                    tvRegisterLink.setText("Invalid login attempt");

                                }




                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
