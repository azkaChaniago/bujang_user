package com.example.root.bujang_user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CapitalPopupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital_popup);

        Button btn = (Button) findViewById(R.id.btn_cap_cont);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CapitalPopupActivity.this, NavigationActivity.class);
                startActivity(intent);
            }
        });
    }
}
