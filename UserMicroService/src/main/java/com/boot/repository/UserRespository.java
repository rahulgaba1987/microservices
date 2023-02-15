package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.UserEntity;


public interface UserRespository extends JpaRepository<UserEntity, String>
{

}
