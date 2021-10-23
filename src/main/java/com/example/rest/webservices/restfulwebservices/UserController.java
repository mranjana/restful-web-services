package com.example.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;


    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return userService.retrieveAllUsers();
    }
    @GetMapping("/jpa/users/{id}")
    public Optional<User> retrieveUser(@PathVariable int id){
        return userService.retrieveUser(id);
    }
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);

    }
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User saveUser= userService.createUser(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("jpa/users/{id}/posts")
    public List<Post> retrieveAllUser(@PathVariable int id){
       return userService.retrieveAllUser(id);
    }
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id,@Valid @RequestBody Post post){
        Post savePost= userService.createPost(id,post);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savePost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}
