package com.example.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> retrieveUser(int id){
        Optional<User> user= userRepository.findById(id);
        if(!user.isPresent())
            throw new UserNotFoundException("id -"+id);
        return user;

    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
    public User createUser(User user){
       return userRepository.save(user);
    }
    public List<Post> retrieveAllUser(int id){
        Optional<User> userOptional=userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-" +id);
        }

        return userOptional.get().getPosts();
    }
    public Post createPost(int id,Post post){
        Optional<User> optionalUser=userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new  UserNotFoundException("id-"+id);
        }
        User user=optionalUser.get();
        post.setUser(user);
        Post savePost= postRepository.save(post);
        return savePost;
    }
}
