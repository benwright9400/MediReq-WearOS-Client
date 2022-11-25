package com.wrightapplications.medireq_client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wrightapplications.medireq_client.databinding.ActivityHomeBinding;

public class ActivityHome extends Activity {

    private TextView mTextView;
    private ActivityHomeBinding binding;
    private Button buttonMedicalRequest;
    private Button buttonSARequest;
    private Button buttonCancelTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.text;
        buttonMedicalRequest = binding.buttonMedicalRequest;
        buttonSARequest = binding.buttonSARequest;
        buttonCancelTerms = binding.buttonCancelTerms;

        buttonMedicalRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, ActivityFurtherInfo.class);
                startActivity(intent);
            }
        });

        buttonSARequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, ActivityComplete.class);
                startActivity(intent);
            }
        });

        buttonCancelTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, ActivityComplete.class);
                startActivity(intent);
            }
        });
    }
}