package com.example.sakhi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.button.MaterialButton;
import com.example.sakhi.R;

public class MainActivity extends AppCompatActivity {

    private CardView cardStudent, cardDistributor;
    private MaterialButton btnGetStarted, btnSignIn;
    private String selectedUserType = "student"; // default selection

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupClickListeners();
        updateCardSelection(); // ensure default selection is visible
    }

    /** Initialize all views */
    private void initViews() {
        cardStudent = findViewById(R.id.card_student);
        cardDistributor = findViewById(R.id.card_distributor);
        btnGetStarted = findViewById(R.id.btn_get_started);
        btnSignIn = findViewById(R.id.btn_sign_in);
    }

    /** Attach click listeners */
    private void setupClickListeners() {
        if (cardStudent != null) {
            cardStudent.setOnClickListener(v -> {
                selectedUserType = "student";
                updateCardSelection();
                showToast("Student selected");
            });
        }

        if (cardDistributor != null) {
            cardDistributor.setOnClickListener(v -> {
                selectedUserType = "distributor";
                updateCardSelection();
                showToast("Distributor selected");
            });
        }

        if (btnGetStarted != null) {
            btnGetStarted.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, AuthActivity.class);
                intent.putExtra("user_type", selectedUserType);
                intent.putExtra("auth_mode", "register");
                startActivity(intent);
            });
        }

        if (btnSignIn != null) {
            btnSignIn.setOnClickListener(v -> {
                // For demo: directly go to dashboard
                Intent intent = new Intent(MainActivity.this, StudentDashboardActivity.class);
                startActivity(intent);
            });
        }
    }

    /** Update visual selection on cards */
    private void updateCardSelection() {
        if (cardStudent != null) {
            cardStudent.setAlpha(selectedUserType.equals("student") ? 1.0f : 0.7f);
        }
        if (cardDistributor != null) {
            cardDistributor.setAlpha(selectedUserType.equals("distributor") ? 1.0f : 0.7f);
        }
    }

    /** Helper to show Toasts */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
