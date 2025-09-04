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

    private Button btnScanQR, btnPharmacyContract;
    private TextView tvScanResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warden);

        btnScanQR = findViewById(R.id.btn_scan_qr);
        btnPharmacyContract = findViewById(R.id.btn_pharmacy_contract);
        tvScanResult = findViewById(R.id.tv_scan_result);

        // ✅ Pharmacy button click
        btnPharmacyContract.setOnClickListener(v -> {
            Intent intent = new Intent(WardenActivity.this, PharmacyContractActivity.class);
            startActivity(intent);
        });

        // ✅ QR scanner button click
        btnScanQR.setOnClickListener(v -> {
            IntentIntegrator integrator = new IntentIntegrator(WardenActivity.this);
            integrator.setPrompt("Scan Student QR Code");
            integrator.setBeepEnabled(true);
            integrator.setOrientationLocked(true);
            integrator.initiateScan();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                String qrData = result.getContents();
                tvScanResult.setText("Scanned QR: " + qrData);
            } else {
                tvScanResult.setText("Scan cancelled");
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
