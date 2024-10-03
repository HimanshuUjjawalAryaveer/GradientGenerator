package com.example.gradientgenerator;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private AppCompatButton btn1, btn2;
    private TextView text;
    String first = "#28a3f4", firstRGB = "rgb(40, 163, 244)";
    String second = "#02be05", secondRGB = "rgb(2, 190, 5)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        inti();
        start();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String []st = randomColor();
                first = st[1];
                firstRGB = st[0];
                linearLayout.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{Color.parseColor(first), Color.parseColor(second)}));
                btn1.setText(first);
                text.setText(stringConvert());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String []st = randomColor();
                second = st[1];
                secondRGB = st[0];
                linearLayout.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{Color.parseColor(first), Color.parseColor(second)}));
                btn2.setText(second);
                text.setText(stringConvert());
            }
        });
    }

    private String stringConvert() {
        return "background-image: linear-gradient(to right, "+firstRGB+", "+secondRGB+";";
    }
    private void inti() {
        linearLayout = findViewById(R.id.main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        text = findViewById(R.id.text);
    }
    private String[] randomColor() {
        int red = (int)Math.floor(Math.random() * 256);
        int blue = (int)Math.floor(Math.random() * 256);
        int green = (int)Math.floor(Math.random() * 256);
        String redClr = Integer.toHexString(red);
        String blueClr = Integer.toHexString(blue);
        String greenClr = Integer.toHexString(green);
        if(redClr.length() < 2) {
            redClr = "0" + redClr;
        }
        if(blueClr.length() < 2) {
            blueClr = "0" + blueClr;
        }
        if(greenClr.length() < 2) {
            greenClr = "0" + greenClr;
        }
        String color = "rgb("+red+", "+blue+", "+green+")";
        String colorHex = "#" + redClr + blueClr + greenClr;
        return new String[]{color, colorHex};
    }
    private void start() {
        btn1.setText(first);
        btn2.setText(second);
        linearLayout.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{Color.parseColor(first), Color.parseColor(second)}));
        text.setText(stringConvert());
    }

}