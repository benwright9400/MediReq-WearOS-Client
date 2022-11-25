package com.wrightapplications.medireq_client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wrightapplications.medireq_client.databinding.ActivitySignUpBinding;

public class ActivitySignUp extends Activity {

    private TextView mTextView;
    private ActivitySignUpBinding binding;
    private Button completeSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.text;

        completeSignUp = binding.button1;

        completeSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivitySignUp.this, ActivityComplete.class);
                startActivity(intent);
            }
        });
    }
}