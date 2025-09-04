package com.example.sakhi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sakhi.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class WardenActivity extends AppCompatActivity {

    private Button btnScanQR;
    private TextView tvScanResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warden);

        btnScanQR = findViewById(R.id.btn_scan_qr);
        tvScanResult = findViewById(R.id.tv_scan_result);

        btnScanQR.setOnClickListener(v -> {
            IntentIntegrator integrator = new IntentIntegrator(WardenActivity.this);
            integrator.setPrompt("Scan Student QR Code");
            integrator.setBeepEnabled(true);
            integrator.setOrientationLocked(true);
            integrator.initiateScan(); // Start scanning
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                String qrData = result.getContents();
                tvScanResult.setText("Scanned QR: " + qrData);

                // ✅ Split data (orderId | padName)
                String[] parts = qrData.split("\\|");
                if (parts.length == 2) {
                    String orderId = parts[0];
                    String padName = parts[1];

                    Toast.makeText(this,
                            "Pad: " + padName + "\nOrder ID: " + orderId + "\nHanded over successfully!",
                            Toast.LENGTH_LONG).show();
                }
            } else {
                tvScanResult.setText("Scan cancelled");
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
