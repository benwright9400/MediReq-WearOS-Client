package com.wrightapplications.medireq_client.business_layer;

import com.wrightapplications.medireq_client.communication_modules.APIInterface;

import org.json.JSONObject;

public class MedicalRequest {
    public MedicalRequest() {

    }

    public void postMedicalRequest() {
        APIInterface apiInterface = new APIInterface();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fName", "Ben");
            jsonObject.put("lName", "Wright");
            jsonObject.put("userType", "ELDERLY_PERSON");
            jsonObject.put("requestType", "MAKE_MEDICAL_REQUEST");
            jsonObject.put("content", "");
            jsonObject.put("address", "2 Bentley Copse");
            jsonObject.put("postCode", "GU15 1DY");
            jsonObject.put("dateOfBirth", "21/05/2003");
            jsonObject.put("id", "6380d2e868a52febf44e53de");
            apiInterface.sendPostRequest(jsonObject,"client/medicalRequest");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
