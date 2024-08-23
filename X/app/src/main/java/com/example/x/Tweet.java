package com.example.x;

public class Tweet {
    private String author;
    private String content;
    private String timestamp;
    private int likes;
    private int retweets;

    public Tweet(){};
    public Tweet(String author, String content, int likes, int retweets)
    {
        this.author=author;
        this.content=content;
        this.likes=likes;
        this.retweets=retweets;
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
}
