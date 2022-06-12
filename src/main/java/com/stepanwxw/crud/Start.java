package main.java.com.stepanwxw.crud;

import main.java.com.stepanwxw.crud.model.Post;
import main.java.com.stepanwxw.crud.model.Region;
import main.java.com.stepanwxw.crud.model.Role;
import main.java.com.stepanwxw.crud.model.User;
import main.java.com.stepanwxw.crud.repository.PostRepositoryImpl;
import main.java.com.stepanwxw.crud.repository.RegionRepositoryImpl;
import main.java.com.stepanwxw.crud.repository.UserRepositoryImpl;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {
        RegionRepositoryImpl regionRepository = new RegionRepositoryImpl();

        PostRepositoryImpl postRepository = new PostRepositoryImpl();
//        postRepository.create(new Post(postRepository.generateId(),"сообщение",postRepository.tm(),postRepository.tm()));
//        postRepository.create(new Post(postRepository.generateId(),"сообщение еще одно",postRepository.tm(),postRepository.tm()));
       UserRepositoryImpl userRepository = new UserRepositoryImpl();
        userRepository.create(new User(userRepository.generateId(), "Вадик", "Петров", postRepository.getAll(),
                regionRepository.getByID(1L),Role.valueOf("ADMIN")));
        System.out.println(userRepository.getByID(1L));
        userRepository.update(new User(1L, "Вадик2", "ПетроФФ", postRepository.getAll(),
                regionRepository.getByID(2L),Role.valueOf("USER")));
        System.out.println(userRepository.getByID(1L));
        userRepository.remove(1L);

   }
}
