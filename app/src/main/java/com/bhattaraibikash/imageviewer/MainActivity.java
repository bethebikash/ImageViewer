package com.bhattaraibikash.imageviewer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    RadioButton btnEt, btnGw, btnPyr;
    ImageView ivShow;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEt = findViewById(R.id.btnEt);
        btnGw = findViewById(R.id.btnGw);
        btnPyr = findViewById(R.id.btnPyr);

        ivShow = findViewById(R.id.ivShow);

        builder = new AlertDialog.Builder(this);

        btnEt.setOnClickListener(this);
        btnGw.setOnClickListener(this);
        btnPyr.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEt:
                builder.setMessage("Do you 'want to view this image?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ivShow.setImageResource(R.drawable.et);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "You 'clicked No", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.setTitle("Show image");
                alert.show();
                break;

            case R.id.btnGw:
                ivShow.setImageResource(R.drawable.gw);
                break;

            case R.id.btnPyr:
                ivShow.setImageResource(R.drawable.pyrimid);
                break;
        }

    }
}
