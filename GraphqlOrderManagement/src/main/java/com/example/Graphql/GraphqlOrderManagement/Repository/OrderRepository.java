package com.example.Graphql.GraphqlOrderManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Graphql.GraphqlOrderManagement.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
