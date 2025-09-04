package com.example.sakhi.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sakhi.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;

public class StudentPadsActivity extends AppCompatActivity {

    TextView padName, padStock;
    Button orderButton;
    ImageView qrCodeImage;

    int stock = 25; // Example initial stock

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_pads);

        padName = findViewById(R.id.padName);
        padStock = findViewById(R.id.padStock);
        orderButton = findViewById(R.id.orderButton);
        qrCodeImage = findViewById(R.id.qrCodeImage);

        // Example product
        padName.setText("Reusable Cotton Pad");
        padStock.setText("Stock: " + stock);

        orderButton.setOnClickListener(v -> {
            // Generate a unique order ID
            String orderId = "ORDER_" + System.currentTimeMillis();

            // Info inside QR
            String orderData = orderId + "|" + padName.getText().toString();

            generateQRCode(orderData);

            // Update stock (local for demo)
            stock--;
            padStock.setText("Stock: " + stock);
        });
    }

    private void generateQRCode(String text) {
        QRCodeWriter writer = new QRCodeWriter();
        try {
            int width = 400, height = 400;
            com.google.zxing.common.BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bitmap.setPixel(x, y, bitMatrix.get(x, y) ? android.graphics.Color.BLACK : android.graphics.Color.WHITE);
                }
            }

            qrCodeImage.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
