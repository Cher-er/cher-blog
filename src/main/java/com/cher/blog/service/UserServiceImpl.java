package com.cher.blog.service;

import com.cher.blog.dao.UserMapper;
import com.cher.blog.pojo.Blog;
import com.cher.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public List<User> getUsersByNickname(String nickname) {
        return userMapper.getUsersByNickname(nickname);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public Boolean addUser(User user) {
        return null;
    }

    @Override
    public Boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }
}
