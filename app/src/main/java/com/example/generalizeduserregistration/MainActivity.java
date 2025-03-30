package com.example.generalizeduserregistration;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtFirstName, txtMiddleName, txtLastName, txtEmail, txtPhone, txtHeight, txtWeight, txtTin, txtGsis, txtEmergencyName, txtEmergencyContact, txtEmergencyRelationship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFirstName = findViewById(R.id.txtfirstName);
        txtMiddleName = findViewById(R.id.txtmiddleName);
        txtLastName = findViewById(R.id.txtlastName);
        txtEmail = findViewById(R.id.txtemail);
        txtPhone = findViewById(R.id.txtphone);
        txtHeight = findViewById(R.id.txtheight);
        txtWeight = findViewById(R.id.txtweight);
        txtTin = findViewById(R.id.txttin);
        txtGsis = findViewById(R.id.txtgsis);
        txtEmergencyName = findViewById(R.id.txtemergencyName);
        txtEmergencyContact = findViewById(R.id.txtemergencyContact);
        txtEmergencyRelationship = findViewById(R.id.txtemergencyRelationship);

        Button nextButton = findViewById(R.id.btnNext);

        nextButton.setOnClickListener(v -> {
            if (validateInputs()) {
                Intent intent = new Intent(MainActivity.this, Education.class);

                intent.putExtra("firstName", txtFirstName.getText().toString().trim());
                intent.putExtra("middleName", txtMiddleName.getText().toString().trim());
                intent.putExtra("lastName", txtLastName.getText().toString().trim());
                intent.putExtra("email", txtEmail.getText().toString().trim());
                intent.putExtra("phone", txtPhone.getText().toString().trim());
                intent.putExtra("height", txtHeight.getText().toString().trim());
                intent.putExtra("weight", txtWeight.getText().toString().trim());
                intent.putExtra("tin", txtTin.getText().toString().trim());
                intent.putExtra("gsis", txtGsis.getText().toString().trim());
                intent.putExtra("emergencyName", txtEmergencyName.getText().toString().trim());
                intent.putExtra("emergencyContact", txtEmergencyContact.getText().toString().trim());
                intent.putExtra("emergencyRelationship", txtEmergencyRelationship.getText().toString().trim());

                startActivity(intent);
            }
        });
    }

    private boolean validateInputs() {
        boolean isValid = true;

        if (isEmpty(txtFirstName)) {
            txtFirstName.setError("First name is required!");
            isValid = false;
        }
        if (isEmpty(txtLastName)) {
            txtLastName.setError("Last name is required!");
            isValid = false;
        }
        if (isEmpty(txtEmail)) {
            txtEmail.setError("Email is required!");
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText().toString().trim()).matches()) {
            txtEmail.setError("Enter a valid email!");
            isValid = false;
        }
        if (isEmpty(txtPhone)) {
            txtPhone.setError("Phone number is required!");
            isValid = false;
        } else if (!txtPhone.getText().toString().trim().matches("\\d{10,11}")) {
            txtPhone.setError("Enter a valid phone number (10-11 digits)!");
            isValid = false;
        }
        if (isEmpty(txtHeight)) {
            txtHeight.setError("Height is required!");
            isValid = false;
        }
        if (isEmpty(txtWeight)) {
            txtWeight.setError("Weight is required!");
            isValid = false;
        }
        if (isEmpty(txtTin)) {
            txtTin.setError("TIN is required!");
            isValid = false;
        }
        if (isEmpty(txtGsis)) {
            txtGsis.setError("GSIS is required!");
            isValid = false;
        }
        if (isEmpty(txtEmergencyName)) {
            txtEmergencyName.setError("Emergency contact name is required!");
            isValid = false;
        }
        if (isEmpty(txtEmergencyContact)) {
            txtEmergencyContact.setError("Emergency contact number is required!");
            isValid = false;
        } else if (!txtEmergencyContact.getText().toString().trim().matches("\\d{10,11}")) {
            txtEmergencyContact.setError("Enter a valid emergency contact (10-11 digits)!");
            isValid = false;
        }
        if (isEmpty(txtEmergencyRelationship)) {
            txtEmergencyRelationship.setError("Relationship is required!");
            isValid = false;
        }

        return isValid;
    }

    private boolean isEmpty(TextInputEditText editText) {
        return TextUtils.isEmpty(editText.getText().toString().trim());
    }
}
