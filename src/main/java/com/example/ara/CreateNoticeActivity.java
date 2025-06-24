package com.example.ara;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CreateNoticeActivity extends AppCompatActivity {

    EditText ettitle, etstartdate, etenddate, etnotice;
    Spinner sp;
    TextView charCount;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_notice);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        ettitle = findViewById(R.id.etTitle);
        etstartdate = findViewById(R.id.etStartDate);
        etenddate = findViewById(R.id.etEndDate);
        etnotice = findViewById(R.id.etNoticeText);
        sp = findViewById(R.id.spinnerClass);
        charCount = findViewById(R.id.charCount);
        btn = findViewById(R.id.btnSubmit);

        String[] classes = {"MCA A", "MCA B", "MCA C"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, classes);
        sp.setAdapter(adapter);
        etnotice.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int count = charSequence.length();
                charCount.setText(count + "/500");
            }

            @Override
            public void afterTextChanged(android.text.Editable editable) { }
        });

        btn.setOnClickListener(view -> {
            String title = ettitle.getText().toString();
            String selectedClass = sp.getSelectedItem().toString();
            String startDate = etstartdate.getText().toString();
            String endDate = etenddate.getText().toString();
            String description = etnotice.getText().toString();

            if (title.isEmpty() || startDate.isEmpty() || endDate.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Notice Submitted for " + selectedClass, Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
