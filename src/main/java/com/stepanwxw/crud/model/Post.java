package main.java.com.stepanwxw.crud.model;

import java.sql.Timestamp;

public class Post {
   long id;
   String content;
   Timestamp create;
   Timestamp update;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreate() {
        return create;
    }

    public void setCreate(Timestamp create) {
        this.create = create;
    }

    public Timestamp getUpdate() {
        return update;
    }

    public void setUpdate(Timestamp update) {
        this.update = update;
    }
    public Post(long id, String content, Timestamp create, Timestamp update) {
        this.id = id;
        this.content = content;
        this.create = create;
        this.update = update;
    }

    @Override
    public String toString() {
        return id + " : " + content + " : " + create + " : " + update;
    }
}
