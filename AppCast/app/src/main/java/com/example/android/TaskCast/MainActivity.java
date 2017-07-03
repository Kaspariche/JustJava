package com.example.android.TaskCast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.calls).setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CallsActivity.class));
            }
        });


        findViewById(R.id.likes).setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LikesActivity.class));
            }
        });


        findViewById(R.id.bids).setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BidsActivity.class));
            }
        });


        findViewById(R.id.negotations).setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NegotationsActivity.class));
            }
        });


        findViewById(R.id.promises).setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PromisesActivity.class));
            }
        });


        findViewById(R.id.accomplishments).setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AccomplishmentsActivity.class));
            }
        });

        findViewById(R.id.rewards).setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RewardsActivity.class));
            }
        });


    }
}
