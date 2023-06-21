package com.midterm.mad_final_018;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername, editTextPassword, editTextName;
    private Button buttonLogin, buttonSignUp, buttonSettings;
    private DatabseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabseHelper(this);

        editTextName = findViewById(R.id.editTextName);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (databaseHelper.checkUser(username, password)) {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    // Redirect to main_bg_activity
                    Intent intent = new Intent(MainActivity.this, MainBgActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonSettings = findViewById(R.id.buttonSettings);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (databaseHelper.addUser(name, username, password)) {
                    Toast.makeText(MainActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the SettingsActivity
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
