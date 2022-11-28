package com.wrightapplications.medireq_client.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wrightapplications.medireq_client.databinding.ActivityCompleteBinding;

public class ActivityComplete extends Activity {

    private TextView mTextView;
    private ActivityCompleteBinding binding;
    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCompleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.text;

        homeButton = binding.button2;

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityComplete.this, ActivityHome.class);
                startActivity(intent);
            }
        });
    }
}