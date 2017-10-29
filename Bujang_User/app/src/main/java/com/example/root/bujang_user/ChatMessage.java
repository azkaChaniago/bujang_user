package com.example.root.bujang_user;

import java.security.PublicKey;
import java.util.Date;

/**
 * Created by root on 28/10/17.
 */

public class ChatMessage {

    private String msgTxt;
    private String msgUsr = "John Doe";
    private long msgTime;

    public ChatMessage (String msgTxt, String msgUsr) {
        this.msgTxt = msgTxt;
        this.msgUsr = msgUsr;

        msgTime = new Date().getTime();
    }

    public ChatMessage(){}

    public String getMessageText() {
        return msgTxt;
    }

    public void setMessageText(String msgTxt) {
        this.msgTxt = msgTxt;
    }

    public String getMessageUser() {
        return msgUsr;
    }

    public void setMessageUser(String msgUsr) {
        this.msgUsr = msgUsr;
    }

    public long getMessageTime() {
        return msgTime;
    }

    public void setMessageTime(long msgTime) {
        this.msgTime = msgTime;
    }

}
