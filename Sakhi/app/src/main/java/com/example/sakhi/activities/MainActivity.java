package com.example.sakhi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.sakhi.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private CardView cardStudent, cardDistributor;
    private MaterialButton btnGetStarted, btnSignIn;
    private FloatingActionButton btnChatbot;
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
        btnChatbot = findViewById(R.id.btn_chatbot); // chatbot FAB
    }

    /** Attach click listeners */
    private void setupClickListeners() {
        if (cardStudent != null) {
            cardStudent.setOnClickListener(v -> {
                selectedUserType = "student";
                updateCardSelection();
                showToast("Student selected");

                // ✅ Open StudentPadsActivity
                Intent intent = new Intent(MainActivity.this, StudentPadsActivity.class);
                startActivity(intent);
            });
        }

        if (cardDistributor != null) {
            cardDistributor.setOnClickListener(v -> {
                selectedUserType = "distributor";
                updateCardSelection();
                showToast("Distributor selected");

                // ✅ Open WardenActivity
                Intent intent = new Intent(MainActivity.this, WardenActivity.class);
                startActivity(intent);
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
                // For demo: directly go to student dashboard
                Intent intent = new Intent(MainActivity.this, StudentDashboardActivity.class);
                startActivity(intent);
            });
        }

        if (btnChatbot != null) {
            btnChatbot.setOnClickListener(v -> {
                // ✅ Open ChatbotActivity
                Intent intent = new Intent(MainActivity.this, ChatbotActivity.class);
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
