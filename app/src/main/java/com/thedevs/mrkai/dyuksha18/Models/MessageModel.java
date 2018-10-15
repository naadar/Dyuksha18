package com.thedevs.mrkai.dyuksha18.Models;

public class MessageModel {
    String messages;
    public final static String MSG_TYPE_SENT = "MSG_TYPE_SENT";
    public final static String MSG_TYPE_RECEIVED = "MSG_TYPE_RECEIVED";
    private String msgType;

    public MessageModel(String msgType, String msgContent) {
        this.msgType = msgType;
        this.messages = msgContent;
    }

    public String getMsgContent() {
        return messages;
    }
    public String getMsgType() {
        return msgType;
    }
}
