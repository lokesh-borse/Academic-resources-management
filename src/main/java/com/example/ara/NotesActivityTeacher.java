package com.example.ara;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class NotesActivityTeacher extends AppCompatActivity {

    private Spinner subjectSpinner, mcaSpinner;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_notes);
        subjectSpinner = findViewById(R.id.subjectSpinner);
        mcaSpinner = findViewById(R.id.mcaSpinner);
        backButton = findViewById(R.id.backButton);

        setupSpinner(mcaSpinner, new String[]{"MCA 1st Year", "MCA 2nd Year"});
        setupSpinner(subjectSpinner, new String[]{"Java", "Python", "C++", "DSA"});

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setupSpinner(Spinner spinner, String[] items) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
    }
}
