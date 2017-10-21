package com.example.demo.repository;

import com.example.demo.entity.RegisterUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterUserRepository extends JpaRepository<RegisterUserEntity, Long> {

}
