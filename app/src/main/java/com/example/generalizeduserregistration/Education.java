package com.example.generalizeduserregistration;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

public class Education extends AppCompatActivity {

    private TextInputEditText txtElementarySchool, txtElementaryDegree;
    private TextInputEditText txtSecondarySchool, txtSecondaryDegree;
    private TextInputEditText txtVocationalSchool, txtVocationalDegree;
    private TextInputEditText txtCollegeSchool, txtCollegeDegree;
    private TextInputEditText txtGraduateSchool, txtGraduateDegree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        // Get references to text input fields
        txtElementarySchool = findViewById(R.id.txtElementarySchool);
        txtElementaryDegree = findViewById(R.id.txtElementaryDegree);
        txtSecondarySchool = findViewById(R.id.txtSecondarySchool);
        txtSecondaryDegree = findViewById(R.id.txtSecondaryDegree);
        txtVocationalSchool = findViewById(R.id.txtVocationalSchool);
        txtVocationalDegree = findViewById(R.id.txtVocationalDegree);
        txtCollegeSchool = findViewById(R.id.txtCollegeSchool);
        txtCollegeDegree = findViewById(R.id.txtCollegeDegree);
        txtGraduateSchool = findViewById(R.id.txtGraduateSchool);
        txtGraduateDegree = findViewById(R.id.txtGraduateDegree);

        Button submitButton = findViewById(R.id.btnSubmit);

        submitButton.setOnClickListener(v -> {
            if (validateInputs()) {
                // Retrieve personal data from previous activity
                Intent receivedIntent = getIntent();
                Intent reportIntent = new Intent(Education.this, Report.class);

                // Pass personal details
                reportIntent.putExtra("firstName", receivedIntent.getStringExtra("firstName"));
                reportIntent.putExtra("middleName", receivedIntent.getStringExtra("middleName"));
                reportIntent.putExtra("lastName", receivedIntent.getStringExtra("lastName"));
                reportIntent.putExtra("email", receivedIntent.getStringExtra("email"));
                reportIntent.putExtra("phone", receivedIntent.getStringExtra("phone"));
                reportIntent.putExtra("height", receivedIntent.getStringExtra("height"));
                reportIntent.putExtra("weight", receivedIntent.getStringExtra("weight"));
                reportIntent.putExtra("tin", receivedIntent.getStringExtra("tin"));
                reportIntent.putExtra("gsis", receivedIntent.getStringExtra("gsis"));
                reportIntent.putExtra("emergencyName", receivedIntent.getStringExtra("emergencyName"));
                reportIntent.putExtra("emergencyContact", receivedIntent.getStringExtra("emergencyContact"));
                reportIntent.putExtra("emergencyRelationship", receivedIntent.getStringExtra("emergencyRelationship"));

                // Pass educational details
                reportIntent.putExtra("elementarySchool", txtElementarySchool.getText().toString().trim());
                reportIntent.putExtra("elementaryDegree", txtElementaryDegree.getText().toString().trim());
                reportIntent.putExtra("secondarySchool", txtSecondarySchool.getText().toString().trim());
                reportIntent.putExtra("secondaryDegree", txtSecondaryDegree.getText().toString().trim());
                reportIntent.putExtra("vocationalSchool", txtVocationalSchool.getText().toString().trim());
                reportIntent.putExtra("vocationalDegree", txtVocationalDegree.getText().toString().trim());
                reportIntent.putExtra("collegeSchool", txtCollegeSchool.getText().toString().trim());
                reportIntent.putExtra("collegeDegree", txtCollegeDegree.getText().toString().trim());
                reportIntent.putExtra("graduateSchool", txtGraduateSchool.getText().toString().trim());
                reportIntent.putExtra("graduateDegree", txtGraduateDegree.getText().toString().trim());

                startActivity(reportIntent);
            }
        });
    }

    private boolean validateInputs() {
        boolean isValid = true;
        StringBuilder missingFields = new StringBuilder("Please fill in:\n");

        // Ensure at least one educational field is filled
        if (isEmpty(txtElementarySchool) && isEmpty(txtSecondarySchool) &&
                isEmpty(txtVocationalSchool) && isEmpty(txtCollegeSchool) && isEmpty(txtGraduateSchool)) {
            missingFields.append("- At least one school\n");
            isValid = false;
        }

        // Ensure degrees match the schools filled
        if (!validatePair(txtVocationalSchool, txtVocationalDegree, "Vocational")) isValid = false;
        if (!validatePair(txtCollegeSchool, txtCollegeDegree, "College")) isValid = false;
        if (!validatePair(txtGraduateSchool, txtGraduateDegree, "Graduate")) isValid = false;

        // If any field is missing, show a Toast message and prevent submission
        if (!isValid) {
            Toast.makeText(this, missingFields.toString(), Toast.LENGTH_LONG).show();
        }

        return isValid;
    }

    // Helper method to check if a field is empty
    private boolean isEmpty(TextInputEditText editText) {
        return TextUtils.isEmpty(editText.getText().toString().trim());
    }

    // Helper method to validate school-degree pairs
    private boolean validatePair(TextInputEditText school, TextInputEditText degree, String level) {
        if (!isEmpty(school) && isEmpty(degree)) {
            degree.setError(level + " degree is required!");
            return false;
        } else if (isEmpty(school) && !isEmpty(degree)) {
            school.setError(level + " school is required!");
            return false;
        }
        return true;
    }
}
