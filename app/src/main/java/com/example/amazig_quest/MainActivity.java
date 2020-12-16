package com.example.amazig_quest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOK=(Button) findViewById(R.id.buttonScore);
        btnOK.setOnClickListener(this);
        btnOK=(Button) findViewById(R.id.buttonOefenen);
        btnOK.setOnClickListener(this);
        btnOK=(Button) findViewById(R.id.buttonQuiz);
        btnOK.setOnClickListener(this);
        btnOK=(Button) findViewById(R.id.buttonOver);
        btnOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent score = new Intent(this, ScoreActivity.class);
        Intent over = new Intent(this, OverActivity.class);
        Intent categorie = new Intent (this, CategorieActivity.class);

        switch(v.getId()) {
            case R.id.buttonOefenen:
            case R.id.buttonQuiz:
                startActivity(categorie);
                break;
            case R.id.buttonOver:
                startActivity(over);
                break;
            case R.id.buttonScore:
                startActivity(score);
                break;
        }
    }
}