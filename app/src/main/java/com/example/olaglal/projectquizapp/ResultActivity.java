package com.example.olaglal.projectquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        RatingBar bar = findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        TextView t = findViewById(R.id.textResult);
        Bundle b = getIntent().getExtras();
        Float score = b.getFloat("score");
        bar.setRating(score);
        double esp = 1e-6 ;
        if (Math.abs( score - 0f ) < esp ) {
            t.setText("You scored 0%, Keep learning ");
        } else if (Math.abs( score - 0.5f ) < esp ) {
            t.setText("You have 10%, Keep learning ");
        } else if (Math.abs( score - 1.0f ) < esp ) {
            t.setText("You have 20%, Keep learning ");
        } else if (Math.abs( score - 1.5f ) < esp ) {
            t.setText("You have 30%, Hmmmm keep practice");
        } else if (Math.abs( score - 2.0f ) < esp ) {
            t.setText("You have 40%, Hmmmm keep practice");
        } else if (Math.abs( score - 2.5f ) < esp ) {
            t.setText("You have 50%, Hmmmm keep practice");
        } else if (Math.abs( score - 3.0f ) < esp ) {
            t.setText("You have 60%, Not Bad!");
        } else if (Math.abs( score - 3.5f ) < esp ) {
            t.setText("You have 70%, Not Bad!");
        } else if (Math.abs( score - 4.0f ) < esp ) {
            t.setText("You have 80%, You are smart");
        } else if (Math.abs( score - 5.0f ) < esp ) {
            t.setText("You have 90%, You are SMART");
        } else {
            t.setText("Whao, you have 100%, Who are you?");
        }
        Toast.makeText(ResultActivity.this ,bar.getRating()+"",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
