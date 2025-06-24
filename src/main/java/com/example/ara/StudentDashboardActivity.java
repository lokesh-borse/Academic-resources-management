package com.example.ara;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentdashboard);

        Toast.makeText(this, "Student Dashboard Loaded!", Toast.LENGTH_SHORT).show();

        ImageView iconAssignment = findViewById(R.id.iconAssignment);
        iconAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDashboardActivity.this, StudentAssignmentActivity.class);
                startActivity(intent);
            }
        });
        ImageView iconNotes = findViewById(R.id.iconNotes);
        iconNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDashboardActivity.this, StudentNotesActivity.class);
                startActivity(intent);
            }
        });
        ImageView iconNotices = findViewById(R.id.iconNotices);
        iconNotices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDashboardActivity.this, StudentNoticeActivity.class);
                startActivity(intent);
            }
        });
        ImageView iconCalander = findViewById(R.id.iconCalander);

        iconCalander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open StudentActivity
                Intent intent = new Intent(StudentDashboardActivity.this, TeacherTimeTableActivity.class);
                startActivity(intent);
            }
        });
        ImageView iconProfile = findViewById(R.id.iconProfile);

        iconProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open StudentActivity
                Intent intent = new Intent(StudentDashboardActivity.this, StudentProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
