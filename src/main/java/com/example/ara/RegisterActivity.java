package com.example.ara;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, dob, username, password;
    RadioGroup gender;
    Spinner ds;
    Button rgbt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.labelName);
        email = findViewById(R.id.textEmail);
        dob = findViewById(R.id.textDob);
        gender = findViewById(R.id.typeGender);
        ds = findViewById(R.id.Designation1);
        username = findViewById(R.id.textUsername);
        password = findViewById(R.id.textPassword);
        rgbt = findViewById(R.id.btnRegister);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.designation_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ds.setAdapter(adapter);

        rgbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String nameText = name.getText().toString().trim();
        String emailText = email.getText().toString().trim();
        String dobDate = dob.getText().toString().trim();

        int genderId = gender.getCheckedRadioButtonId();
        RadioButton selectedGender = findViewById(genderId);
        String genderText = (selectedGender != null) ? selectedGender.getText().toString() : "";

        String dsText = (ds.getSelectedItem() != null) ? ds.getSelectedItem().toString() : "";
        String userText = username.getText().toString().trim();
        String passText = password.getText().toString().trim();

        if (nameText.isEmpty() || emailText.isEmpty() || dobDate.isEmpty()
                || genderText.isEmpty() || dsText.isEmpty()
                || userText.isEmpty() || passText.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(userText + "_password", passText);
        editor.putString(userText + "_designation", dsText);
        editor.apply();

        Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(RegisterActivity.this, MainActivity.class); // Or LoginActivity
        startActivity(intent);
        finish();
    }
}
