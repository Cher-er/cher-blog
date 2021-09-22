package com.cher.blog.service;

import com.cher.blog.pojo.User;

import java.util.List;

public interface UserService {

    User getUser(Integer id);

    User getUserByUsername(String username);

    List<User> getUsersByNickname(String nickname);

    List<User> getUsers();

    Boolean addUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUser(Integer id);
}
