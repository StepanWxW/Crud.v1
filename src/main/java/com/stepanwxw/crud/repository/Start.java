package main.java.com.stepanwxw.crud.repository;

import main.java.com.stepanwxw.crud.model.Post;
import main.java.com.stepanwxw.crud.model.Region;

import java.io.IOException;
import java.sql.Timestamp;


public class Start {
    public static void main(String[] args) throws IOException {
        PostRepositoryImp posts = new PostRepositoryImp();
//        posts.create(new Post(posts.generateId(),"Вася",posts.tm(), posts.tm()));
    }
}
