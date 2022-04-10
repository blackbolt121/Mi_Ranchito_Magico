package com.example.service;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

public class Requester {
    private String URL = "http://localhost/mannyfoods/";
    private RequestQueue queue;

    public Requester(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public String str_response;
    /***
     * En esta función lo que se hace es enviar una petición al servidor, con ayuda del usuario y la contraseña,
     * La contraseña es agregada al cuerpo de la petición y es hasheada en el proceso
     * @param user String
     * @param password String
     * @returns String
     */
    public String requestLogin(String user, String password) {
        return makeRequest(URL+"login.php",
                "POST",
                new HashMap() {
                    {
                        put("user", user);
                        put("password", password);
                    }
                }).orElse("");
    }
    public String requestRegister(HashMap body){
        return makeRequest(URL+"register.php",
                "POST",
                body).orElse("");
    }
    //Method to build call a API for any request
    public Optional<String> makeRequest(String URL, String method, HashMap body) {
        StringRequest request;
        String Response;
        switch (method) {
            case "GET":
                request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        str_response = response;
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return new HashMap<String, String>() {
                            {
                                put("Content-Type", "text/html");
                            }
                        };
                    }
                };
                break;
            case "POST":
                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        str_response = response;

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        return body;
                    }
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return new HashMap<String, String>() {
                            {
                                put("Content-Type", "text/html");
                            }
                        };
                    }
                };
                break;
            default:
                return Optional.ofNullable(null);
        }
        return (!str_response.equals("")) ? Optional.ofNullable(str_response) : Optional.ofNullable(null);
    }


}
