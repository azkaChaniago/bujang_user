package com.example.root.bujang_user;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class QAChatActivity extends AppCompatActivity {

    private int SIGN_IN_REQUEST_CODE;
    private FirebaseListAdapter<ChatMessage> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qachat);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.qa_chat_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText input = (EditText) findViewById(R.id.qa_chat_comment);
                FirebaseDatabase.getInstance()
                        .getReference()
                        .push()
                        .setValue(new ChatMessage(input.getText().toString(), FirebaseAuth.getInstance().getCurrentUser().getDisplayName()));

                input.setText("");
            }
        });
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivityForResult(
                    AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .build(),
                    SIGN_IN_REQUEST_CODE
            );
        } else {
            Toast.makeText(this,
                    "Welcome " +FirebaseAuth.getInstance()
            .getCurrentUser()
            .getDisplayName(),
                    Toast.LENGTH_LONG)
                    .show();
            displayChatMessages();
        }
    }

    private void displayChatMessages() {
        ListView listMessage = (ListView) findViewById(R.id.qa_chat_message);

        adapter = new FirebaseListAdapter<ChatMessage>(this, ChatMessage.class, R.layout.qa_message, FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                TextView textMsg = (TextView) findViewById(R.id.qa_message_text);
                TextView textUsr = (TextView) findViewById(R.id.qa_message_user);
                TextView textTime = (TextView) findViewById(R.id.qa_message_time);

                textMsg.setText(model.getMessageText());
                textUsr.setText(model.getMessageUser());

                textTime.setText(android.text.format.DateFormat.format("dd-MM-yyyy (HH:mm:ss)", model.getMessageTime()));
            }
        };

        listMessage.setAdapter(adapter);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Successfully signed in. Welcome!", Toast.LENGTH_LONG).show();
                displayChatMessages();
            } else {
                Toast.makeText(this, "Couldn't not sign in", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
}
