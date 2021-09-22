package com.cher.blog;

import com.cher.blog.dao.BlogMapper;
import com.cher.blog.dao.TypeMapper;
import com.cher.blog.dao.UserMapper;
import com.cher.blog.pojo.Blog;
import com.cher.blog.pojo.Type;
import com.cher.blog.pojo.User;
import com.cher.blog.service.TypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class CherBlogApplicationTests {

    @DisplayName("Mapper Test")
    @Nested
    class MapperTest {

        @DisplayName("TypeMapper Test")
        @Nested
        class TypeMapperTest {

            @Autowired
            TypeMapper typeMapper;

            @Test
            void getType() {
                Type type = typeMapper.getType(1);
                System.out.println(type);
            }

            @Test
            void getTypeByName() {
                Type type = typeMapper.getTypeByName("JavaSE基础");
                System.out.println(type);
            }

            @Test
            void getTypes() {
                List<Type> types = typeMapper.getTypes();
                for (Type type : types) {
                    System.out.println(type);
                }
            }

            @Test
            void addType() {
                Type type = new Type();
                type.setName("jQuery基础入门");
                Boolean res = typeMapper.addType(type);
                System.out.println("Type => " + type);
                System.out.println("res => " + res);
            }

            @Test
            void updateType() {
                Type type = new Type();
                type.setId(3);
                type.setName("HTML5基础入门");
                Boolean res = typeMapper.updateType(type);
                System.out.println("Type => " + type);
                System.out.println("res => " + res);
            }

            @Test
            void deleteType() {
                Boolean res = typeMapper.deleteType(4);
                System.out.println("res => " + res);
            }

        }

        @DisplayName("UserMapper Test")
        @Nested
        class UserMapperTest {

            @Autowired
            UserMapper userMapper;

            @Test
            void getUser() {
                User user = userMapper.getUser(1);
                System.out.println("User => " + user);
            }

            @Test
            void getUserByUsername() {
                User user = userMapper.getUserByUsername("cher_er");
                System.out.println("User => " + user);
            }

            @Test
            void getUsersByNickname() {
                List<User> users = userMapper.getUsersByNickname("%er%");
                for (User user : users) {
                    System.out.println("User => " + user);
                }
            }

            @Test
            void getUsers() {
                List<User> users = userMapper.getUsers();
                for (User user : users) {
                    System.out.println("User => " + user);
                }
            }

            @Test
            void addUser() {
                User user = new User();
                user.setUsername("hello_jack");
                user.setPassword("123123");
                user.setNickname("Jack");
                user.setPower(0);
                user.setEmail("321@163.com");
                user.setPhone("32132132132");

                Boolean res = userMapper.addUser(user);
                System.out.println("User => " + user);
                System.out.println("res => " + res);
            }

            @Test
            void updateUser() {
                User user = new User();
                user.setId(4);
                user.setUsername("hello_nice");
                user.setPassword("456456");
                user.setNickname("Nice");

                Boolean res = userMapper.updateUser(user);
                System.out.println("User => " + user);
                System.out.println("res => " + res);
            }

            @Test
            void deleteUser() {
                Boolean res = userMapper.deleteUser(2);
                System.out.println("res => " + res);
            }
        }

        @DisplayName("BlogMapper Test")
        @Nested
        class BlogMapperTest {

            @Autowired
            BlogMapper blogMapper;

            @Test
            void getBlog() {
                Blog blog = blogMapper.getBlog(1);
                System.out.println("Blog => " + blog);
            }

            @Test
            void getBlogs() {
                List<Blog> blogs = blogMapper.getBlogs();
                for (Blog blog : blogs) {
                    System.out.println("Blog => " + blog);
                }
            }

            @Test
            void getBlogsByTypeId() {
                List<Blog> blogs = blogMapper.getBlogsByTypeId(1);
                for (Blog blog : blogs) {
                    System.out.println("Blog => " + blog);
                }
            }

            @Test
            void getBlogsByUserId() {
                List<Blog> blogs = blogMapper.getBlogsByUserId(1);
                for (Blog blog : blogs) {
                    System.out.println("Blog => " + blog);
                }
            }

            @Test
            void addBlog() {
                Blog blog = new Blog();
                blog.setTitle("初识MySQL");
                blog.setDescription("对MySQL的简要介绍。");
                blog.setContent("MySQL是一门应用最为广泛的数据库语言之一。");
                blog.setViewCount(21);
                blog.setPicUrl("https://picsum.photos/id/1005/400/300");
                blog.setRecommend(false);
                blog.setAppreciate(true);
                blog.setStatus(1);
                blog.setCreateTime(new Date());
                blog.setUpdateTime(new Date());
                blog.setStatement(1);
                blog.setUser(new User(1));
                blog.setType(new Type(2));

                Boolean res = blogMapper.addBlog(blog);
                System.out.println("Blog => " + blog);
                System.out.println("res => " + res);
            }

            @Test
            void updateBlog() {
                Blog blog = new Blog();
                blog.setId(2);
                blog.setContent("MySQL是一门应用最为广泛的数据库语言之一（修正）。");
                blog.setViewCount(23);
                blog.setUpdateTime(new Date());

                Boolean res = blogMapper.updateBlog(blog);
                System.out.println("Blog => " + blog);
                System.out.println("res => " + res);
            }

            @Test
            void deleteBlog() {
                Boolean res = blogMapper.deleteBlog(2);
                System.out.println("res => " + res);
            }
        }

    }

    @DisplayName("Service Test")
    @Nested
    class ServiceTest {

        @DisplayName("TypeService Test")
        @Nested
        class TypeServiceTest {

            @Autowired
            TypeService typeService;

            @Test
            void getTypes() {
                List<Type> types = typeService.getTypes();
                System.out.println("Size => " + types.size());
            }

            @Test
            void getTypesByPage() {
                List<Type> types = typeService.getTypesByPage(2, 2);
                for (Type type : types) {
                    System.out.println(type);
                }
            }

        }

    }

}
