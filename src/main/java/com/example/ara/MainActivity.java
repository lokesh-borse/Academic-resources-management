package com.example.ara;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    Spinner sp;
    EditText username,password;
    Button bt;
    TextView rgtext;

    protected void onCreate(Bundle si) {
        super.onCreate(si);

        setContentView(R.layout.activity_login);
        sp = findViewById(R.id.designation);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        bt = findViewById(R.id.button);
        rgtext = findViewById(R.id.register);

        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"Select","Student","Teacher"});
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ad);
        rgtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        bt.setOnClickListener(view -> loginUser());
    }

    private void loginUser() {
        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(user.isEmpty() || pass.isEmpty())
        {
            Toast.makeText(this,"Username or password missing",Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sp = getSharedPreferences("UserData",MODE_PRIVATE);
        String storepass = sp.getString(user + "_password", "");
        String designation = sp.getString(user + "_designation", "");
        if (pass.equals(storepass))
        {
            Toast.makeText(this,"Login Successfull!!",Toast.LENGTH_SHORT).show();
            if(designation.equalsIgnoreCase("Teacher"))
            {
                Intent i = new Intent(MainActivity.this,TeacherDashboardActivity.class);
                startActivity(i);
            }
            else if(designation.equalsIgnoreCase("Student"))
            {
                Intent i = new Intent(MainActivity.this,StudentDashboardActivity.class);
                startActivity(i);
            }
            finish();
        }
        else{
            Toast.makeText(this,"Invalid Username or password:",Toast.LENGTH_SHORT).show();
        }
    }
}
