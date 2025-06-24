package com.example.ara;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.Calendar;

public class TeacherUploadAssignment extends AppCompatActivity {

    private Spinner spinnerCourse, spinnerSection, spinnerSubject;
    private EditText etStartDate, etEndDate, etDescription;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_upload_assignment);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        spinnerCourse = findViewById(R.id.spinnerCourse);
        spinnerSection = findViewById(R.id.spinnerSection);
        spinnerSubject = findViewById(R.id.spinnerSubject);
        etStartDate = findViewById(R.id.etStartDate);
        etEndDate = findViewById(R.id.etEndDate);
        etDescription = findViewById(R.id.etDescription);
        btnSubmit = findViewById(R.id.btnSubmit);

        setupSpinners();
        setupDatePickers();
        setupSubmitButton();
    }

    private void setupSpinners() {
        String[] sections = {"A", "B", "C"};
        String[] subjects = {"Java", "DBMS", "C++", "Python"};
        String[] courses = {"MCA", "BCA", "BSc IT"};

        spinnerCourse.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, courses));
        spinnerSection.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sections));
        spinnerSubject.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, subjects));
    }

    private void setupDatePickers() {
        etStartDate.setOnClickListener(view -> showDatePicker(etStartDate));
        etEndDate.setOnClickListener(view -> showDatePicker(etEndDate));
    }

    private void showDatePicker(final EditText editText) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this, (view, year1, month1, dayOfMonth) ->
                editText.setText(String.format("%02d/%02d/%04d", dayOfMonth, month1 + 1, year1)),
                year, month, day).show();
    }

    private void setupSubmitButton() {
        btnSubmit.setOnClickListener(v -> {
            String course = spinnerCourse.getSelectedItem().toString();
            String section = spinnerSection.getSelectedItem().toString();
            String subject = spinnerSubject.getSelectedItem().toString();
            String startDate = etStartDate.getText().toString();
            String endDate = etEndDate.getText().toString();
            String description = etDescription.getText().toString();
            if (startDate.isEmpty() || endDate.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Assignment Uploaded", Toast.LENGTH_SHORT).show();
        });
    }
}

