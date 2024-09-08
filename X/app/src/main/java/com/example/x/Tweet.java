package com.example.x;

import java.util.UUID;

public class Tweet {
    private String Id;
    private String author;
    private String content;
    private int likes;
    private int retweets;
    private int imp;

    public Tweet(){};
    public Tweet(String author, String content, int likes, int retweets, int imp)
    {
        this.Id= UUID.randomUUID().toString();
        this.author=author;
        this.content=content;
        this.likes=likes;
        this.retweets=retweets;
        this.imp=imp;
    }
    public String getId(){
        return Id;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String a){
        author=a;
    }
    public String getContent(){
        return  content;
    }

    public void setContent(String content)
    {
        this.content=content;
    }

    public int getLikes(){
        return likes;
    }

    public void upDateLike(){
        this.likes+=1;
    }

    public int getRetweets(){
        return retweets;
    }

    public void updateRetweets(){
        this.retweets+=1;
    }

    public int getImp(){
        return imp;
    }

    public void setImp(int imp)
    {
        this.imp=imp;
    }
}
