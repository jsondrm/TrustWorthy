package com.example.dao;

import com.example.bean.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findUserByUsername(String username);
    void update(User user);
    void save(User user);
    void delete(String username);
    List<User> findByPage(User user, Pageable pageable);
}
