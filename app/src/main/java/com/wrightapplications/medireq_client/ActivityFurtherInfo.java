package com.wrightapplications.medireq_client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wrightapplications.medireq_client.databinding.ActivityFurtherInfoBinding;

public class ActivityFurtherInfo extends Activity {

    private TextView mTextView;
    private ActivityFurtherInfoBinding binding;
    private Button submitFurtherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFurtherInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mTextView = binding.text;

        submitFurtherInfo = binding.buttonSubmitFurtherInfo;

        submitFurtherInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityFurtherInfo.this, ActivityComplete.class);
                startActivity(intent);
            }
        });

    }
}