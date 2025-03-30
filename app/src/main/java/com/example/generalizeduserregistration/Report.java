package com.example.generalizeduserregistration;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.graphics.Typeface;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        TextView txtReport = findViewById(R.id.txtReport);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstName");
        String middleName = intent.getStringExtra("middleName");
        String lastName = intent.getStringExtra("lastName");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String height = intent.getStringExtra("height");
        String weight = intent.getStringExtra("weight");
        String tin = intent.getStringExtra("tin");
        String gsis = intent.getStringExtra("gsis");
        String emergencyName = intent.getStringExtra("emergencyName");
        String emergencyContact = intent.getStringExtra("emergencyContact");
        String emergencyRelationship = intent.getStringExtra("emergencyRelationship");
        String elementarySchool = intent.getStringExtra("elementarySchool");
        String elementaryDegree = intent.getStringExtra("elementaryDegree");
        String secondarySchool = intent.getStringExtra("secondarySchool");
        String secondaryDegree = intent.getStringExtra("secondaryDegree");
        String vocationalSchool = intent.getStringExtra("vocationalSchool");
        String vocationalDegree = intent.getStringExtra("vocationalDegree");
        String collegeSchool = intent.getStringExtra("collegeSchool");
        String collegeDegree = intent.getStringExtra("collegeDegree");
        String graduateSchool = intent.getStringExtra("graduateSchool");
        String graduateDegree = intent.getStringExtra("graduateDegree");

        SpannableStringBuilder report = new SpannableStringBuilder();

        addBoldText(report, "Personal Information:\n");
        report.append("Name: ").append(firstName).append(" ").append(middleName).append(" ").append(lastName).append("\n")
                .append("Email: ").append(email).append("\n")
                .append("Phone: ").append(phone).append("\n")
                .append("Height: ").append(height).append("\n")
                .append("Weight: ").append(weight).append("\n")
                .append("TIN: ").append(tin).append("\n")
                .append("GSIS: ").append(gsis).append("\n\n");

        addBoldText(report, "Emergency Contact:\n");
        report.append("Name: ").append(emergencyName).append("\n")
                .append("Contact: ").append(emergencyContact).append("\n")
                .append("Relationship: ").append(emergencyRelationship).append("\n\n");

        addBoldText(report, "Educational Background:\n");
        report.append("Elementary: ").append(elementarySchool).append(" (").append(elementaryDegree).append(")\n")
                .append("Secondary: ").append(secondarySchool).append(" (").append(secondaryDegree).append(")\n")
                .append("Vocational: ").append(vocationalSchool).append(" (").append(vocationalDegree).append(")\n")
                .append("College: ").append(collegeSchool).append(" (").append(collegeDegree).append(")\n")
                .append("Graduate: ").append(graduateSchool).append(" (").append(graduateDegree).append(")\n");

        txtReport.setText(report);

    }

    private void addBoldText(SpannableStringBuilder builder, String text) {
        int start = builder.length();
        builder.append(text);
        builder.setSpan(new StyleSpan(Typeface.BOLD), start, builder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
}
