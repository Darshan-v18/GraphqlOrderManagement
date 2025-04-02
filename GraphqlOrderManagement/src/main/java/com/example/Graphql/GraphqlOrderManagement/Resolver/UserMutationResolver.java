package com.example.Graphql.GraphqlOrderManagement.Resolver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.example.Graphql.GraphqlOrderManagement.Model.User;
import com.example.Graphql.GraphqlOrderManagement.Repository.UserRepository;

@Controller
public class UserMutationResolver {

    private final UserRepository userRepository;

    public UserMutationResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @MutationMapping
    public User addUser(@Argument String name, @Argument String email) {
        User user = new User(null, name, email, null);
        return userRepository.save(user);
    }
}
