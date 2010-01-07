package org.expressme.webwind.demo;

import java.util.Date;

public class Post {

    private long id;
    private String title;
    private String content;
    private Date creation;

    public Post() {
    }

    public Post(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Post(long id, String title, String content, Date creation) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creation = creation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

}
