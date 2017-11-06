package com.stan.loginregister;

/**
 * Created by Stan on 26/03/2017.
 */

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AddRosterRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://stansfinal.azurewebsites.net/insertRoster.php";
    private Map<String, String> params;

    public AddRosterRequest(String rdate, int UserID, int deptID, int RStart, int TEnd, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("R_Day", rdate);
        params.put("UserID", UserID+"");
        params.put("deptID", deptID+"");
        params.put("RStart",RStart+"");
        params.put("TEnd", TEnd+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
