package com.example.ara;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class StudentAssignmentActivity extends AppCompatActivity {

    EditText studentDatePicker;
    Spinner studentMcaSpinner;
    ImageView studentBackButton;
    Button studentUploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_assignment);
        studentDatePicker = findViewById(R.id.studentDatePicker);
        studentMcaSpinner = findViewById(R.id.studentMcaSpinner);
        studentBackButton = findViewById(R.id.studentBackButton);
        studentUploadButton = findViewById(R.id.studentUploadButton);

        String[] options = {"MCA-A", "MCA-B", "MCA-C"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        studentMcaSpinner.setAdapter(adapter);

        studentDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        StudentAssignmentActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                                studentDatePicker.setText(selectedDate);
                            }
                        },
                        year, month, day
                );
                datePickerDialog.show();
            }
        });

        studentBackButton.setOnClickListener(v -> finish());
        studentUploadButton.setOnClickListener(v -> {
            Intent intent = new Intent(StudentAssignmentActivity.this, StudentUploadAssignment.class);
            startActivity(intent);
        });
    }
}
