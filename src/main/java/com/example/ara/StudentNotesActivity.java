package com.example.ara;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class StudentNotesActivity extends AppCompatActivity {

    LinearLayout noteItem1, noteItem2, noteItem3;
    TextView noteText1, noteText2, noteText3;
    ImageView downloadBtn1, downloadBtn2, downloadBtn3;
    ImageButton backButton;
    Spinner subspi;

    HashMap<String, String[]> notesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_notes);

        subspi =findViewById(R.id.spinnersubjects);
        noteItem1 = findViewById(R.id.noteItem1);
        noteItem2 = findViewById(R.id.noteItem2);
        noteItem3 = findViewById(R.id.noteItem3);
        noteText1 = noteItem1.findViewById(R.id.textNote1);
        noteText2 = noteItem2.findViewById(R.id.textNote2);
        noteText3 = noteItem3.findViewById(R.id.textNote3);
        downloadBtn1 = noteItem1.findViewById(R.id.downloadBtn1);
        downloadBtn2 = noteItem2.findViewById(R.id.downloadBtn2);
        downloadBtn3 = noteItem3.findViewById(R.id.downloadBtn3);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(v -> finish());

        notesMap = new HashMap<>();
        notesMap.put("JAVA", new String[]{"Chapter-1.pdf", "Chapter-2.pdf", "Chapter-3.pdf"});
        notesMap.put("DBMS", new String[]{"ER-Model.pdf", "Normalization.pdf", "SQL.pdf"});
        notesMap.put("C++", new String[]{"Basics.pdf", "OOPs.pdf", "Inheritance.pdf"});
        notesMap.put("Python", new String[]{"Intro.pdf", "DataTypes.pdf", "Loops.pdf"});

        String[] subjects = {"JAVA", "DBMS", "C++", "Python"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, subjects);
        subspi.setAdapter(adapter);

        subspi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedSubject = subjects[position];
                showNotesForSubject(selectedSubject);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        downloadBtn1.setOnClickListener(v -> Toast.makeText(this, "Downloading " + noteText1.getText(), Toast.LENGTH_SHORT).show());
        downloadBtn2.setOnClickListener(v -> Toast.makeText(this, "Downloading " + noteText2.getText(), Toast.LENGTH_SHORT).show());
        downloadBtn3.setOnClickListener(v -> Toast.makeText(this, "Downloading " + noteText3.getText(), Toast.LENGTH_SHORT).show());
    }

    private void showNotesForSubject(String subject) {
        String[] notes = notesMap.get(subject);
        if (notes != null && notes.length >= 3) {
            noteText1.setText(notes[0]);
            noteText2.setText(notes[1]);
            noteText3.setText(notes[2]);
        }
    }
}
