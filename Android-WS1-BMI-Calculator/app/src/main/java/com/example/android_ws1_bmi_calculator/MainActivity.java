package com.example.android_ws1_bmi_calculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        height = findViewById(R.id.editTextHeight);
        weight = findViewById(R.id.editTextWeight);
        result = findViewById(R.id.textViewResult);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemInsets.left, systemInsets.top, systemInsets.right, systemInsets.bottom);
            return WindowInsetsCompat.CONSUMED;
        });
    }

    public void calc(android.view.View v) {
        float h = Float.parseFloat(height.getText().toString());
        float w = Float.parseFloat(weight.getText().toString());
        float bmi = w / h / h;
        result.setText("Your BMI is: " + String.valueOf(bmi));
    }
}
