package com.cher.blog.dao;

import com.cher.blog.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
@RequestMapping
public interface BlogMapper {

    Blog getBlog(Integer id);

    List<Blog> getBlogs();

    Boolean addBlog(Blog blog);

    Boolean updateBlog(Blog blog);

    Boolean deleteBlog(Integer id);
}
