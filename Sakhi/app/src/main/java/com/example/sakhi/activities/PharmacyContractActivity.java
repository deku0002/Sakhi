package com.example.sakhi.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sakhi.R;

public class PharmacyContractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_contract);

        Button btnContract = findViewById(R.id.btn_contract);
        btnContract.setOnClickListener(v ->
                Toast.makeText(this, "✅ 6-Month Contract Signed!", Toast.LENGTH_LONG).show()
        );
    }
}
