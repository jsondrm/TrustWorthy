package com.example.service.Impl;

import com.example.bean.User;
import com.example.dao.UserDao;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public void update(User user) {
       userDao.update(user);

    }

    @Override
    public void save(User user) {
        userDao.save(user);

    }

    @Override
    public void delete(String username) {
        userDao.delete(username);

    }

    @Override
    public List<User> findByPage(User user, Pageable pageable) {
        return userDao.findByPage(user,pageable);
    }
}
