package com.cher.blog.dao;

import com.cher.blog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {

    Integer getCount();

    Blog getBlog(@Param("id") Integer id);

    List<Blog> getBlogs();

    List<Blog> getBlogsByTypeId(@Param("typeId") Integer typeId);

    List<Blog> getBlogsByUserId(@Param("userId") Integer userId);

    Boolean addBlog(Blog blog);

    Boolean updateBlog(Blog blog);

    Boolean deleteBlog(@Param("id") Integer id);
}
