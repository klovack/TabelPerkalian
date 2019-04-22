package com.mrizki.tabelperkalian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvTabelPerkalian;
    private TextView txtNumber;

    public int min = 0;
    public int max = 20;
    public int startPos = 10;
    public int jumlah = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar skBrTabelPerkalian = findViewById(R.id.skBrTabelPerkalian);

        lvTabelPerkalian = findViewById(R.id.lvTabelPerkalian);
        txtNumber = findViewById(R.id.txtNumber);

        skBrTabelPerkalian.setMax(max);
        skBrTabelPerkalian.setProgress(startPos);

        skBrTabelPerkalian.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int nomorTabelPerkalian;

                if (progress < min) {
                    nomorTabelPerkalian = min;
                } else {
                    nomorTabelPerkalian = progress;
                }

                txtNumber.setText("Perkalian " + nomorTabelPerkalian + " * i:");

                generateTabelPerkalian(nomorTabelPerkalian);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void generateTabelPerkalian(int nomorTabelPerkalian) {
        ArrayList<String> kontenTabelPerkalian = new ArrayList<>();

        for (int i = 0; i < jumlah; i++) {
            kontenTabelPerkalian.add(nomorTabelPerkalian + " x " + i + " = " + (i * nomorTabelPerkalian));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, kontenTabelPerkalian);

        lvTabelPerkalian.setAdapter(arrayAdapter);
    }
}
