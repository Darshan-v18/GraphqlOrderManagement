package com.example.Graphql.GraphqlOrderManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Graphql.GraphqlOrderManagement.Model.User;;

public interface UserRepository extends JpaRepository<User, Long> {
}