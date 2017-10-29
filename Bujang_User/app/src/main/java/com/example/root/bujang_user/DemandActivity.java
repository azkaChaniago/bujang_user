package com.example.root.bujang_user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class DemandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demand);

        LinearLayout linear = (LinearLayout) findViewById(R.id.link_1);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DemandActivity.this, ProceedActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout linear2 = (LinearLayout) findViewById(R.id.link_2);
        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DemandActivity.this, ProcessingActivity.class);
                startActivity(intent);
            }
        });
    }
}
