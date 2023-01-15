package com.example.mobilyazlmlarhafta14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycleView();
    }

    private void initRecycleView() {
        recyclerView = findViewById(R.id.rcvMuzeler);
        MuzeAdaptor muzeAdaptor = new MuzeAdaptor(DataUtil.muzeDatasiAl(), getApplicationContext(), new MuzeAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(Muze tiklananMuze) {
                Toast.makeText(getApplicationContext(), "Tıklanan müze" + tiklananMuze.getIsim(), Toast.LENGTH_SHORT).show();

                Intent detayEkrani = new Intent(MainActivity.this, DetayActivity.class);
                detayEkrani.putExtra("TASINAN DATA", tiklananMuze);
                startActivity(detayEkrani);
            }
        });
        recyclerView.setAdapter(muzeAdaptor);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}