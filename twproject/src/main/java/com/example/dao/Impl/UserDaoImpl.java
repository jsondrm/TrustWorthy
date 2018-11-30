package com.example.dao.Impl;

import com.example.bean.User;
import com.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User findUserByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }

    /**
     * 根据用户名更新
     * @param user
     */
    @Override
    public void update(User user) {
        Query query = new Query(Criteria.where("username").is(user.getUsername()));
        Update update = Update.update("password",user.getPassword()).set("role",user.getRole());
        mongoTemplate.updateMulti(query,update,User.class);

    }

    @Override
    public void save(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public void delete(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        mongoTemplate.remove(query,User.class);

    }

    /**
     *
     * @param user 分页条件
     * @param pageable 分页bean
     * @return
     */
    @Override
    public List<User> findByPage(User user, Pageable pageable) {
        Query query = new Query();
        if(user != null && user.getUsername() != null){
            //模糊查询
            query = new Query(Criteria.where("username").regex("^"+user.getUsername()));
        }
        List<User> list = mongoTemplate.find(query.with(pageable),User.class);
        return list;
    }
}
