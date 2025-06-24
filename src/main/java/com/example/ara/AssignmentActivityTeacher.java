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

import androidx.appcompat.app.AppCompatActivity;

import com.example.ara.TeacherUploadAssignment;

import java.util.Calendar;

public class AssignmentActivityTeacher extends AppCompatActivity {

    EditText datePicker;
    Spinner mcaSpinner;
    ImageView backButton, imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_assignment);

        // Initialize views
        datePicker = findViewById(R.id.datePicker);
        mcaSpinner = findViewById(R.id.mcaSpinner);
        backButton = findViewById(R.id.backButton);
        imageView = findViewById(R.id.imageView);
        String[] options = {"MCA-A", "MCA-B", "MCA-C"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        mcaSpinner.setAdapter(adapter);

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AssignmentActivityTeacher.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                                datePicker.setText(selectedDate);
                            }
                        },
                        year, month, day
                );
                datePickerDialog.show();
            }
        });
        backButton.setOnClickListener(v -> finish());
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(AssignmentActivityTeacher.this, TeacherUploadAssignment.class);
            startActivity(intent);
   });
  }
}