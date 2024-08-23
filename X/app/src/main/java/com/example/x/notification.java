package com.example.x;

public class notification {
    private String author;
    private String action;
    private String timeStamp;

    public notification(){};
    public notification(String author, String action, String timeStamp)
    {
        this.author=author;
        this.action=action;
        this.timeStamp=timeStamp;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author)
    {
        this.author=author;
    }

    public String getAction(){
        return action;
    }

    public void setAction(String action){
        this.action=action;
    }

    public String getTimeStamp(){
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp){
        this.timeStamp=timeStamp;
    }
}
