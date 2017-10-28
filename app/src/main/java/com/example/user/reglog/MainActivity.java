package com.example.user.reglog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    EditText E1;
    EditText E2;
    EditText E3;
    EditText E6;
    EditText E7;
    Button B2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B2 = (Button)findViewById(R.id.B2);

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gIntent = new Intent(MainActivity.this, Qrdisplay.class);
                E1 = (EditText) findViewById(R.id.E1);
                E2 = (EditText) findViewById(R.id.E2);
                E3 = (EditText) findViewById(R.id.E3);
                E6 = (EditText) findViewById(R.id.E6);
                E7 = (EditText) findViewById(R.id.E7);

                String e1 = E1.getText().toString().trim();
                String e2 = E2.getText().toString().trim();
                String e3 = E3.getText().toString().trim();
                String e6 = E6.getText().toString().trim();
                String e7 = E7.getText().toString().trim();

                gIntent.putExtra("impe1", e1);
                gIntent.putExtra("impe2", e2);
                gIntent.putExtra("impe3", e3);
                gIntent.putExtra("impe6", e6);
                gIntent.putExtra("impe7", e7);




                startActivity(gIntent);
            }
        });


    }
}
