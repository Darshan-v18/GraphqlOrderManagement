package com.example.Graphql.GraphqlOrderManagement.Resolver;

import java.time.LocalDate;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.example.Graphql.GraphqlOrderManagement.Model.Order;
import com.example.Graphql.GraphqlOrderManagement.Model.User;
import com.example.Graphql.GraphqlOrderManagement.Repository.OrderRepository;
import com.example.Graphql.GraphqlOrderManagement.Repository.UserRepository;

@Controller
public class OrderMutationResolver {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderMutationResolver(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @MutationMapping
    public Order placeOrder(@Argument Long userId, @Argument Double totalAmount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setStatus("Pending");
        order.setTotalAmount(totalAmount);
        order.setUser(user);
        
        return orderRepository.save(order);
    }
}
