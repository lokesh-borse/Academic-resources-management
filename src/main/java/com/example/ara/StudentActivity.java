package com.example.ara;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class StudentActivity extends AppCompatActivity {
    Spinner spclass, spsection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        spclass = findViewById(R.id.spinnerClass);
        spsection = findViewById(R.id.spinnerSection);

        setupSpinners();
    }
    private void setupSpinners() {
        String[] classes = {"Select Course", "MCA", "MBA"};
        ArrayAdapter<String> c = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classes);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spclass.setAdapter(c);

        String[] sections = {"Select Section", "A", "B", "C"};
        ArrayAdapter<String> s = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sections);
        s.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spsection.setAdapter(s);
    }
    public void goBack(View view) {
        finish();
    }
}
