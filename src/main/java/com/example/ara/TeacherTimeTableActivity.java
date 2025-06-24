package com.example.ara;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class TeacherTimeTableActivity extends AppCompatActivity {

    private LinearLayout datePickerLayout;
    private LinearLayout lectureListLayout;
    private ImageView backButton;

    private List<TimeTableItem> timeTableData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_timetable);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        datePickerLayout = findViewById(R.id.datePickerLayout);
        lectureListLayout = findViewById(R.id.lectureListLayout);
        timeTableData.add(new TimeTableItem("JAVA", "Patil sir", "01:00 PM - 02:00 PM", 1));
        timeTableData.add(new TimeTableItem("JAVA", "Patil sir", "01:00 PM - 02:00 PM", 1));
        timeTableData.add(new TimeTableItem("JAVA", "Patil sir", "01:00 PM - 02:00 PM", 1));

        setupDatePicker();
        displayLecturesForDate(1);
    }

    private void setupDatePicker() {
        if (datePickerLayout.getChildCount() > 0) {
            View firstDateView = datePickerLayout.getChildAt(0);
            firstDateView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    displayLecturesForDate(1);
                    updateSelectedDateUI(v);
                }
            });
            updateSelectedDateUI(firstDateView);
        }
    }

    private void updateSelectedDateUI(View selectedView) {
        for (int i = 0; i < datePickerLayout.getChildCount(); i++) {
            View child = datePickerLayout.getChildAt(i);
            if (child instanceof LinearLayout) {
                child.setBackgroundResource(R.drawable.date_item_background);
            }
        }
        if (selectedView instanceof LinearLayout) {
            selectedView.setBackgroundResource(R.drawable.date_item_background_selected);
        }
    }

    private void displayLecturesForDate(int dayOfWeek) {
        lectureListLayout.removeAllViews();
        for (TimeTableItem item : timeTableData) {
            if (item.getDayOfWeek() == dayOfWeek) {
                LinearLayout lectureItemView = new LinearLayout(this);
                lectureItemView.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                lectureItemView.setOrientation(LinearLayout.VERTICAL);
                lectureItemView.setPadding(12, 12, 12, 12);
                lectureItemView.setBackgroundResource(R.drawable.lecture_item_background);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                layoutParams.setMargins(0, 0, 0, 8);
                lectureItemView.setLayoutParams(layoutParams);
                TextView subjectTextView = new TextView(this);
                subjectTextView.setText(item.getSubject());
                subjectTextView.setTextSize(16);
                subjectTextView.setTextAppearance(android.R.style.TextAppearance_Medium);
                subjectTextView.setTextAppearance(android.R.style.TextAppearance_Medium);
                subjectTextView.setTextColor(getResources().getColor(R.color.black));
                lectureItemView.addView(subjectTextView);

                LinearLayout teacherTimeLayout = new LinearLayout(this);
                teacherTimeLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                teacherTimeLayout.setOrientation(LinearLayout.HORIZONTAL);
                teacherTimeLayout.setGravity(android.view.Gravity.CENTER_VERTICAL);
                ImageView teacherIcon = new ImageView(this);
                LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                iconParams.setMarginEnd(8);
                teacherIcon.setLayoutParams(iconParams);
                teacherIcon.setImageResource(R.drawable.ic_person);
                teacherIcon.setColorFilter(getResources().getColor(android.R.color.darker_gray));
                teacherTimeLayout.addView(teacherIcon);

                TextView teacherTextView = new TextView(this);
                teacherTextView.setText(item.getTeacher());
                teacherTextView.setTextSize(14);
                teacherTextView.setTextColor(getResources().getColor(android.R.color.darker_gray));
                LinearLayout.LayoutParams teacherParams = new LinearLayout.LayoutParams(
                        0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
                teacherTextView.setLayoutParams(teacherParams);
                teacherTimeLayout.addView(teacherTextView);

                TextView timeSlotTextView = new TextView(this);
                timeSlotTextView.setText(item.getTimeSlot());
                timeSlotTextView.setTextSize(14);
                timeSlotTextView.setTextColor(getResources().getColor(android.R.color.darker_gray));
                teacherTimeLayout.addView(timeSlotTextView);

                lectureItemView.addView(teacherTimeLayout);

                lectureListLayout.addView(lectureItemView);
            }
        }
        if (lectureListLayout.getChildCount() == 0) {
            TextView noLecturesTextView = new TextView(this);
            noLecturesTextView.setText("No lectures for this day.");
            lectureListLayout.addView(noLecturesTextView);
        }
    }
    private static class TimeTableItem {
        private String subject;
        private String teacher;
        private String timeSlot;
        private int dayOfWeek;

        public TimeTableItem(String subject, String teacher, String timeSlot, int dayOfWeek) {
            this.subject = subject;
            this.teacher = teacher;
            this.timeSlot = timeSlot;
            this.dayOfWeek = dayOfWeek;
        }

        public String getSubject() {
            return subject;
        }

        public String getTeacher() {
            return teacher;
        }

        public String getTimeSlot() {
            return timeSlot;
        }

        public int getDayOfWeek() {
            return dayOfWeek;
        }
    }
}
