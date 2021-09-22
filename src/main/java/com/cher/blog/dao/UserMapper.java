package com.cher.blog.dao;

import com.cher.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    User getUser(@Param("id") Integer id);

    User getUserByUsername(@Param("username") String username);

    List<User> getUsersByNickname(@Param("nickname") String nickname);

    List<User> getUsers();

    Boolean addUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUser(@Param("id") Integer id);

}
