package com.example.ara;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class TeacherProfileActivity extends AppCompatActivity {

    private ImageView imgProfile;
    private EditText etStudentName, etPRN, etClass, etEmail, etAdditionalInfo;
    private Button btnEditProfile, btnChangeProfile, btnLogout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_profile);

        setupToolbar();
        initializeViews();
        setDefaultData();
        setupClickListeners();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void initializeViews() {
        imgProfile = findViewById(R.id.imgProfile);
        etStudentName = findViewById(R.id.etStudentName);
        etPRN = findViewById(R.id.etPRN);
        etClass = findViewById(R.id.etClass);
        etEmail = findViewById(R.id.etEmail);
        etAdditionalInfo = findViewById(R.id.etAdditionalInfo);

        btnEditProfile = findViewById(R.id.btnEditProfile);
        btnChangeProfile = findViewById(R.id.btnChangeProfile);
        btnLogout = findViewById(R.id.btnLogout);
    }

    private void setDefaultData() {
        // Set default or fetched user data
        etStudentName.setText("John Doe");
        etPRN.setText("123456789");
        etClass.setText("MCA-B");
        etEmail.setText("johndoe@gmail.com");
        etAdditionalInfo.setText("Contact No: 9876543210\nDOB: 01-01-2000\nAddress: Pune, India\nEnrollment Year: 2022\nGuardian Name: Mr. Doe");
        disableEditing();
    }

    private void setupClickListeners() {
       /* btnEditProfile.setOnClickListener(v -> {
            Toast.makeText(this, "Edit Profile Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(StudentProfileActivity.this, EditProfileActivity.class));
        });*/

        btnChangeProfile.setOnClickListener(v -> {
            Toast.makeText(this, "Change Profile Picture Clicked", Toast.LENGTH_SHORT).show();
            changeProfilePicture();
        });

        btnLogout.setOnClickListener(v -> {
            Toast.makeText(this, "Logging Out...", Toast.LENGTH_SHORT).show();
            logoutUser();
        });

        imgProfile.setOnClickListener(v -> {
            Toast.makeText(this, "Profile Image Clicked", Toast.LENGTH_SHORT).show();
            changeProfilePicture();
        });
    }

    private void disableEditing() {
        etStudentName.setEnabled(false);
        etPRN.setEnabled(false);
        etClass.setEnabled(false);
        etEmail.setEnabled(false);
        etAdditionalInfo.setEnabled(false);
    }

    private void changeProfilePicture() {
    }

    private void logoutUser() {
        finish();
    }
}
