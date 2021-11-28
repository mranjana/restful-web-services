package com.example.rest.webservices.restfulwebservices;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class RestfulWebServicesApplicationTests {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    @Test
    public void retrieveAllUsersTest() {

        //when(userRepository.findAll()).thenReturn(Stream.of(new User(1, "Par", 24), new User(2, "Fab", 56)).collect(Collectors.toList()));
        //List<User> userList= Arrays.asList(new User(1,"siva",4));
        List<User> userList= Arrays.asList(new User(1,"siva",4));
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals(1, userService.retrieveAllUsers().size());
    }

    @Test
    public void retrieveUserTest(){
        int id=1;
        User user=new User(1,"Appunni",5);
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        assertEquals(true,userService.retrieveUser(id).isPresent());

    }
    @Test
    public void deleteUserTest(){
        int id=1;
        User user=new User(1,"Appunni",5);
        userService.deleteUser(id);
        verify(userRepository,times(1)).deleteById(id);
    }
}
