package com.wrightapplications.medireq_client.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.wrightapplications.medireq_client.business_layer.SignUpForm;
import com.wrightapplications.medireq_client.databinding.ActivitySignUpBinding;

public class ActivitySignUp extends Activity {

    private TextView mTextView;
    private ActivitySignUpBinding binding;
    private Button completeSignUp;
    private TextView name;
    private TextView addressFirstLine;
    private TextView postCode;
    private TextView dateOfBirth;
    private CheckBox termsCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        completeSignUp = binding.button1;

        name = binding.editTextTextPersonName;
        addressFirstLine = binding.editTextAddress;
        postCode = binding.editTextPostCode;
        dateOfBirth = binding.editTextDOB;
        termsCheckBox = binding.checkBox;


        completeSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpForm signUpForm = new SignUpForm();
                signUpForm.setName(name.getText().toString());
                signUpForm.setAddressFirstLine(addressFirstLine.getText().toString());
                signUpForm.setPostCode(postCode.getText().toString());
                signUpForm.setDateOfBirth(dateOfBirth.getText().toString());
                signUpForm.setAcceptedTerms(termsCheckBox.isChecked());

                signUpForm.formatAndPost();

                Intent intent = new Intent(ActivitySignUp.this, ActivityComplete.class);
                startActivity(intent);
            }
        });
    }
}