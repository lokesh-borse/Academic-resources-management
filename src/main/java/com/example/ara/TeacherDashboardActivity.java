package com.example.ara;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TeacherDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Teacher Dashboard Loaded!", Toast.LENGTH_SHORT).show();

        ImageView iconStudents = findViewById(R.id.iconStudent);

        iconStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open StudentActivity
                Intent intent = new Intent(TeacherDashboardActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });
        ImageView iconNotice = findViewById(R.id.iconNotice);

        iconNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open StudentActivity
                Intent intent = new Intent(TeacherDashboardActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });
        ImageView iconAssignment = findViewById(R.id.iconAssignment);

        iconAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open StudentActivity
                Intent intent = new Intent(TeacherDashboardActivity.this, AssignmentActivityTeacher.class);
                startActivity(intent);
            }
        });

        ImageView iconNotes = findViewById(R.id.iconNotes);

        iconNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open StudentActivity
                Intent intent = new Intent(TeacherDashboardActivity.this, NotesActivityTeacher.class);
                startActivity(intent);
            }
        });
        ImageView iconCalander = findViewById(R.id.iconCalander);

        iconCalander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open StudentActivity
                Intent intent = new Intent(TeacherDashboardActivity.this, TeacherTimeTableActivity.class);
                startActivity(intent);
            }
        });
        ImageView iconProfile = findViewById(R.id.iconProfile);

        iconProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open StudentActivity
                Intent intent = new Intent(TeacherDashboardActivity.this, TeacherProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
