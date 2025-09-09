package com.vivekt.kafka;

public class Message {

    private String id;
    private String content;

    // Default constructor, getters, setters
    public Message() {}

    public Message(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{id='" + id + "', content='" + content + "'}";
    }
}