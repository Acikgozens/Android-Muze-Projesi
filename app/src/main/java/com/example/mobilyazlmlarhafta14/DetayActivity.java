package com.example.mobilyazlmlarhafta14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtHakkında;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        imgKapak = findViewById(R.id.imgKapak);
        txtHakkında = findViewById(R.id.txtHakkinda);

        Muze tasınanMuze =(Muze)getIntent().getParcelableExtra("TASINAN DATA");
        txtHakkında.setText(tasınanMuze.getHakkinda());
        GlideUtil.resmiIndiripGoster(getApplicationContext(),tasınanMuze.getDetayResimUrl(),imgKapak);
    }
}
