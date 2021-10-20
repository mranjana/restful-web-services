package com.example.rest.webservices.restfulwebservices;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users=new ArrayList<>();
    private static int count=3;
    static {
        users.add(new User(1,"Anjana", 23));
        users.add(new User(2,"Anu",30));
        users.add(new User(3,"Vaiga",6));

    }

    public  List<User> findAll() {
        return users;
    }
    public User save(User user){
        if(user.getId()==null){
            user.setId(++count);
        }

            users.add(user);
            return user;
        }

     public User findOne(int id){
        for(User user:users){
            if(user.getId()==id)
                return user;

        }
        return null;
     }
     public User deleteByID(int id){
         Iterator<User> iterator= users.iterator();
         while(iterator.hasNext()){
             User user= iterator.next();;
             if(user.getId()==id){
                 iterator.remove();
                 return user;
             }
         }
         return null;
     }
    }

