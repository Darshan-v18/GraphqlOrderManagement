package com.example.Graphql.GraphqlOrderManagement.Resolver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.Graphql.GraphqlOrderManagement.Model.Order;
import com.example.Graphql.GraphqlOrderManagement.Repository.OrderRepository;

@Controller
public class OrderQueryResolver {

    private final OrderRepository orderRepository;

    public OrderQueryResolver(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @QueryMapping
    public Order getOrderById(@Argument Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
