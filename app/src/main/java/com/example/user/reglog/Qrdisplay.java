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

public class Qrdisplay extends AppCompatActivity {

    /*EditText E1;
    EditText E2;
    EditText E3;
    EditText E6;
    EditText E7;
    */
    Button B3;
    ImageView image;
    String text2Qr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrdisplay);

       /* E1 = (EditText) findViewById(R.id.E1);
        E2 = (EditText) findViewById(R.id.E2);
        E3 = (EditText) findViewById(R.id.E3);
        E6 = (EditText) findViewById(R.id.E6);
        E7 = (EditText) findViewById(R.id.E7);
        */
        Bundle imptext = getIntent().getExtras();
        final String imtext1 = imptext.getString("impe1");
        final String imtext2 = imptext.getString("impe2");
        final String imtext3 = imptext.getString("impe3");
        final String imtext6 = imptext.getString("impe6");
        final String imtext7 = imptext.getString("impe7");
        B3 = (Button) findViewById(R.id.B3);
        image = (ImageView) findViewById(R.id.image);

        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //text2Qr = E1.getText().toString().trim() + E2.getText().toString().trim()+E3.getText().toString().trim()+E6.getText().toString().trim()+E7.getText().toString().trim();

                text2Qr = imtext1+imtext2+imtext3+imtext6+imtext7;
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode(text2Qr, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    image.setImageBitmap(bitmap);
                }
                catch (WriterException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
