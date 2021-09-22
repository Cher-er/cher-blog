package com.cher.blog.service;

import com.cher.blog.pojo.Blog;

import java.util.List;

public interface BlogService {

    Integer getCount();

    Integer getCountByTypeId(Integer typeId);

    Blog getBlog(Integer id);

    List<Blog> getBlog();

    List<Blog> getBlogsByTypeId(Integer typeId);

    List<Blog> getBlogsByPage(Integer offset, Integer limit);

    List<Blog> getBlogsByNew(Integer limit);

    List<Blog> getBlogsByRecommend();

    List<Blog> getBlogsByYear(String year);

    Boolean addBlog(Blog blog);

    Boolean updateBlog(Blog blog);

    Boolean deleteBlog(Integer id);
}
