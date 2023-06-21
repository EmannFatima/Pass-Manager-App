package com.midterm.mad_final_018;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {
    private EditText editTextName, editTextNewPassword;
    private Button buttonSave;
    private DatabseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        databaseHelper = new DatabseHelper(this);

        editTextName = findViewById(R.id.editTextName);
        editTextNewPassword = findViewById(R.id.editTextNewPassword);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = editTextName.getText().toString();
                String newPassword = editTextNewPassword.getText().toString();

                // Update the user's name and password in the database
                if (databaseHelper.updateUserSettings(newName, newPassword)) {
                    Toast.makeText(SettingActivity.this, "Settings saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SettingActivity.this, "Failed to save settings", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}