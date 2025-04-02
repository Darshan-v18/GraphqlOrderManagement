package com.example.Graphql.GraphqlOrderManagement.Resolver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.Graphql.GraphqlOrderManagement.Model.User;
import com.example.Graphql.GraphqlOrderManagement.Repository.UserRepository;

@Controller
public class UserQueryResolver {

    private final UserRepository userRepository;

    public UserQueryResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}