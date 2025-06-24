package com.example.ara;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class StudentNoticeActivity extends AppCompatActivity {

    CardView notice1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_notice);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
        notice1 = findViewById(R.id.notice1);
        notice1.setOnClickListener(view -> {
            Intent intent = new Intent(StudentNoticeActivity.this, NoticeDetailsActivity.class);
            intent.putExtra("title", "Notice 1");
            intent.putExtra("content", "Details of Notice 1...");
            startActivity(intent);
        });

    }
}
