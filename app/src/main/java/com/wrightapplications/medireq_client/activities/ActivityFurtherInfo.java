package com.wrightapplications.medireq_client.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wrightapplications.medireq_client.business_layer.FurtherMedicalInfo;
import com.wrightapplications.medireq_client.databinding.ActivityFurtherInfoBinding;

public class ActivityFurtherInfo extends Activity {

    private TextView mTextView;
    private ActivityFurtherInfoBinding binding;
    private Button submitFurtherInfo;
    private EditText furtherDetailsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFurtherInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        submitFurtherInfo = binding.buttonSubmitFurtherInfo;
        furtherDetailsEditText = binding.editTextTextMultiLine;


        submitFurtherInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FurtherMedicalInfo furtherMedicalInfo = new FurtherMedicalInfo();
                furtherMedicalInfo.setFurtherInformation(furtherDetailsEditText.getText().toString());

                furtherMedicalInfo.formatAndPost();


                Intent intent = new Intent(ActivityFurtherInfo.this, ActivityComplete.class);
                startActivity(intent);
            }
        });

    }

}