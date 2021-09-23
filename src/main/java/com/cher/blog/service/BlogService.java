package com.cher.blog.service;

import com.cher.blog.pojo.Blog;

import java.util.List;

public interface BlogService {

    Integer getCount();

    Integer getCountByTypeId(Integer typeId);

    Blog getBlog(Integer id);

    List<Blog> getBlogs();

    List<Blog> getBlogsByTypeId(Integer typeId);

    List<Blog> getBlogsByTypeIdByPage(Integer typeId, Integer offset, Integer limit);

    List<Blog> getBlogsByPage(Integer offset, Integer limit);

    List<Blog> getBlogsByNew(Integer limit);

    List<Blog> getBlogsByRecommend();

    List<Blog> getBlogsByYear(String year);

    Integer getCountByTitleLike(String titleLike);

    List<Blog> getBlogsByTitleLike(String titleLike);

    List<Blog> getBlogsByTitleLikeByPage(String titleLike, Integer offset, Integer limit);

    List<Blog> getBlogsByTitleLikeAndTypeId(String title, Integer typeId);

    List<Blog> getBlogsByTitleLikeAndTypeIdByPage(String title, Integer typeId, Integer offset, Integer limit);

    Integer getCountByTitleLikeAndTypeId(String title, Integer typeId);

    Boolean addBlog(Blog blog);

    Boolean updateBlog(Blog blog);

    Boolean deleteBlog(Integer id);
}
