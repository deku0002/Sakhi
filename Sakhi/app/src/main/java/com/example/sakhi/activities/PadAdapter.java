package com.example.sakhi.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sakhi.PadItem;   // ✅ import model
import com.example.sakhi.R;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.List;

public class PadAdapter extends RecyclerView.Adapter<PadAdapter.PadViewHolder> {

    private Context context;
    private List<PadItem> padList;

    public PadAdapter(Context context, List<PadItem> padList) {
        this.context = context;
        this.padList = padList;
    }

    @NonNull
    @Override
    public PadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pad, parent, false);
        return new PadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PadViewHolder holder, int position) {
        PadItem pad = padList.get(position);

        holder.padName.setText(pad.getName());
        holder.padStock.setText("Stock: " + pad.getStock());

        holder.orderButton.setOnClickListener(v -> {
            try {
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.encodeBitmap(
                        "Order: " + pad.getName(),
                        BarcodeFormat.QR_CODE,
                        300, 300);
                holder.qrCodeImage.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public int getItemCount() {
        return padList.size();
    }

    static class PadViewHolder extends RecyclerView.ViewHolder {
        TextView padName, padStock;
        Button orderButton;
        ImageView qrCodeImage;

        public PadViewHolder(@NonNull View itemView) {
            super(itemView);
            padName = itemView.findViewById(R.id.padName);
            padStock = itemView.findViewById(R.id.padStock);
            orderButton = itemView.findViewById(R.id.orderButton);
            qrCodeImage = itemView.findViewById(R.id.qrCodeImage);
        }
    }
}
