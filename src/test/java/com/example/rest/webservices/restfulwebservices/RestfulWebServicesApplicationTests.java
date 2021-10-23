package com.example.rest.webservices.restfulwebservices;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class RestfulWebServicesApplicationTests {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    @Test
    public void retrieveAllUsersTest() {
        when(userRepository.findAll()).thenReturn(Stream.of(new User(1, "Par", 24), new User(2, "Fab", 56)).collect(Collectors.toList()));
        assertEquals(2, userService.retrieveAllUsers().size());


    }
}
