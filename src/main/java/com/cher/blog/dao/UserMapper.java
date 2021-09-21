package com.cher.blog.dao;

import com.cher.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
@RequestMapping
public interface UserMapper {

    User getUser(Integer id);

    User getUserByUsername(String username);

    List<User> getUsersByNickname(String nickname);

    List<User> getUsers();

    Boolean addUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUser(Integer id);

}
