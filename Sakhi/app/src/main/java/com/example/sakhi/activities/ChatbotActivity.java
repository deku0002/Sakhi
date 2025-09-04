package com.example.sakhi.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sakhi.R;

import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.Tensor;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class ChatbotActivity extends AppCompatActivity {

    private Interpreter tflite;
    private LinearLayout chatContainer;
    private ScrollView chatScroll;
    private EditText inputMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        chatContainer = findViewById(R.id.chatContainer);
        chatScroll = findViewById(R.id.chatScroll);
        inputMessage = findViewById(R.id.inputMessage);
        btnSend = findViewById(R.id.btnSend);

        try {
            tflite = new Interpreter(loadModelFile("chatbot_model.tflite"));
            logModelInfo(tflite); // 👉 log input/output specs to Logcat
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnSend.setOnClickListener(v -> {
            String userMessage = inputMessage.getText().toString().trim();
            if (!userMessage.isEmpty()) {
                addMessage("You: " + userMessage);

                String botResponse = getBotResponse(userMessage);
                addMessage("Bot: " + botResponse);

                inputMessage.setText("");
            }
        });
    }

    /** Show message in the chat UI */
    private void addMessage(String message) {
        TextView textView = new TextView(this);
        textView.setText(message);
        chatContainer.addView(textView);

        chatScroll.post(() -> chatScroll.fullScroll(ScrollView.FOCUS_DOWN));
    }

    /** Load .tflite model from assets */
    private MappedByteBuffer loadModelFile(String modelName) throws IOException {
        try (FileInputStream fis = new FileInputStream(getAssets().openFd(modelName).getFileDescriptor())) {
            FileChannel fileChannel = fis.getChannel();
            long startOffset = getAssets().openFd(modelName).getStartOffset();
            long declaredLength = getAssets().openFd(modelName).getDeclaredLength();
            return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("❌ Failed to load TFLite model: " + modelName);
        }
    }

    /** Log model input/output specs in Logcat */
    private void logModelInfo(Interpreter interpreter) {
        if (interpreter == null) return;

        for (int i = 0; i < interpreter.getInputTensorCount(); i++) {
            Tensor inputTensor = interpreter.getInputTensor(i);
            Log.d("TFLITE", "Input " + i + " shape: " + Arrays.toString(inputTensor.shape()) +
                    " type: " + inputTensor.dataType());
        }

        for (int i = 0; i < interpreter.getOutputTensorCount(); i++) {
            Tensor outputTensor = interpreter.getOutputTensor(i);
            Log.d("TFLITE", "Output " + i + " shape: " + Arrays.toString(outputTensor.shape()) +
                    " type: " + outputTensor.dataType());
        }
    }

    /** Run inference and get chatbot response */
    private String getBotResponse(String input) {
        if (tflite == null) {
            return "⚠️ Model not loaded!";
        }

        // 👉 TODO: Replace with real preprocessing + inference
        // Right now it only echoes input until we know model input/output
        return "I understand you said: " + input;
    }
}
