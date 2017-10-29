package com.example.root.fullinterfaceapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int REQUEST_SIGNUP = 0;

    @InjectView(R.id.user) EditText nameText;
    @InjectView(R.id.pass) EditText passText;
    @InjectView(R.id.login_btn) Button loginButton;
    @InjectView(R.id.register) TextView register;

    private View mProgressView;
    private View mLoginFormView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                login();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivityForResult(i, REQUEST_SIGNUP);
            }
        });

        mProgressView = findViewById(R.id.login_progress);
        mLoginFormView =findViewById(R.id.login_form);
    }

    private void login() {
        Log.d(TAG, "Login");
        if (!validate()) {
            onLoginFailed();
            return;
        }
        loginButton.setEnabled(false);
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = nameText.getText().toString();
        String password = passText.getText().toString();

        // TODO: Implement your own authentication logic here.
        if (email.equals("sudo@gmail.com") && password.equals("superuserdo")) {
            new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000
            );//showProgress(true);
        } else {
            new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginFailed();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000
            );
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }

    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        Intent i =new Intent(MainActivity.this, DashboardActivity.class);
        startActivity(i);
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_SHORT).show();
        loginButton.setEnabled(true);
    }

    private boolean validate() {
        boolean valid = true;
        String username = nameText.getText().toString();
        String password = passText.getText().toString();

        if (username.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            nameText.setError("Enter valid email address");
            valid = false;
        } else {
            nameText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4) {
            passText.setError("Password less than 4 character");
            valid = false;

        } else {
            passText.setError(null);
        }
        return valid;
    }

    /*Button loginBtn;
    EditText u, p;
    TextView reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button) findViewById(R.id.login_btn);
        reg = (TextView) findViewById(R.id.register);
        u = (EditText) findViewById(R.id.user);
        p = (EditText) findViewById(R.id.pass);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (u.getText().toString().equals("sudo") && p.getText().toString().equals("root")) {
                    Toast.makeText(getBaseContext(), "Redirecting..", Toast.LENGTH_LONG).show();

                    // Start activity after Toast
                    (new Handler()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                            startActivity(i);
                        }
                    }, 3000);

                } else {
                    Toast.makeText(getApplicationContext(),"Wrong Credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

    }
    */
}
