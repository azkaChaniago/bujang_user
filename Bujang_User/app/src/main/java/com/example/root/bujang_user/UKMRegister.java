package com.example.root.bujang_user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UKMRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ukmregister);

        Button btnContinue = (Button) findViewById(R.id.btn_reg_cont);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UKMRegister.this, RegisteredUKM.class);
                startActivity(intent);
            }
        });
    }
}
