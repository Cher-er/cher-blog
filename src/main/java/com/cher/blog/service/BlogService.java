package com.cher.blog.service;

import com.cher.blog.pojo.Blog;

import java.util.List;

public interface BlogService {

    Integer getCount();

    Blog getBlog(Integer id);

    List<Blog> getBlog();

    List<Blog> getBlogsByPage(Integer offset, Integer limit);

    Boolean addBlog(Blog blog);

    Boolean updateBlog(Blog blog);

    Boolean deleteBlog(Integer id);
}
