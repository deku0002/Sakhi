package com.example.sakhi.activities;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.example.sakhi.R;

public class StudentDashboardActivity extends AppCompatActivity {
    private TextView tvWelcome, tvOrdersCount, tvPadsSaved;
    private MaterialButton btnTakeQuiz, btnBrowseProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        initViews();
        setupUI();
        setupClickListeners();
    }

    private void initViews() {
        tvWelcome = findViewById(R.id.tv_welcome);
        tvOrdersCount = findViewById(R.id.tv_orders_count);
        tvPadsSaved = findViewById(R.id.tv_pads_saved);
        btnTakeQuiz = findViewById(R.id.btn_take_quiz);
        btnBrowseProducts = findViewById(R.id.btn_browse_products);
    }

    private void setupUI() {
        String username = getIntent().getStringExtra("username");
        if (username != null) {
            tvWelcome.setText("Welcome, " + username);
        } else {
            tvWelcome.setText("Welcome, Anonymous User");
        }

        tvOrdersCount.setText("0");
        tvPadsSaved.setText("0");
    }

    private void setupClickListeners() {
        btnTakeQuiz.setOnClickListener(v -> {
            Toast.makeText(this, "Quiz feature coming soon!", Toast.LENGTH_SHORT).show();
        });

        btnBrowseProducts.setOnClickListener(v -> {
            Toast.makeText(this, "Product catalog coming soon!", Toast.LENGTH_SHORT).show();
        });
    }
}