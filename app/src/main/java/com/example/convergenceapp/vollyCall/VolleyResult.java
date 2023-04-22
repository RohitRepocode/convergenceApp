package com.example.convergenceapp.vollyCall;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface VolleyResult {
    void notifySuccess(String requestType, JSONObject response);
    void notifyError(String requestType, VolleyError error);
}
