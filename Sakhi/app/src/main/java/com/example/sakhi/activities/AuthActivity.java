package com.example.sakhi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.example.sakhi.R;

public class AuthActivity extends AppCompatActivity {
    private TextInputEditText etUsername, etPassword;
    private MaterialButton btnAuth, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnAuth = findViewById(R.id.btn_auth);
        btnBack = findViewById(R.id.btn_back);
    }

    private void setupClickListeners() {
        btnAuth.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            if (username.isEmpty()) {
                Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, StudentDashboardActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            finish();
        });

        btnBack.setOnClickListener(v -> finish());
    }
}