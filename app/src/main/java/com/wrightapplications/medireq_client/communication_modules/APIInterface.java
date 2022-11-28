package com.wrightapplications.medireq_client.communication_modules;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

public class APIInterface {
    public APIInterface() {

    }

    private void processMedicalRequestResponse(String response) {
        if(response == "invalid request") {
            System.out.println(response);
        } else {
            Database database = new Database();
            database.addRequest(response);
        }
    }

    private void processResponse(String path, String response) {
        if (path == "client/medicalRequest") {
            processMedicalRequestResponse(response);
        }
        if(path == "client/medicalRequestDetails") {

        }

        if(path == "client/subjectAccessRequest") {

        }

    }

    public void sendPostRequest(JSONObject body, String path) {
        try {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);

//            https://medireq-server.herokuapp.com/

            String send = body.toString();

            URL url = new URL(("https://medireq-server.herokuapp.com/" + path));
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Content-Type","application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");


            OutputStream outputStream = urlConnection.getOutputStream();
            outputStream.write(send.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            String response = readInputStream(in);

            processResponse(path, response);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readInputStream(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder result = new StringBuilder();
        int i = 100000;
        while (i > 0) {
            try {
                String val = reader.readLine();
                if(val == null) {
                    break;
                }
                result.append(val);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
            i--;
        }
        Log.i("===response===", result.toString());
        return result.toString(); //if correct this will show the request id
    }
}
