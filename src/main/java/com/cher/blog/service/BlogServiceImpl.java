package com.cher.blog.service;

import com.cher.blog.dao.BlogMapper;
import com.cher.blog.pojo.Blog;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Integer getCount() {
        return blogMapper.getCount();
    }

    @Override
    public Blog getBlog(Integer id) {
        return blogMapper.getBlog(id);
    }

    @Override
    public List<Blog> getBlog() {
        return blogMapper.getBlogs();
    }

    @Override
    public List<Blog> getBlogsByPage(Integer offset, Integer limit) {
        PageHelper.startPage(offset, limit);
        List<Blog> blogs = blogMapper.getBlogs();
        return blogs;
    }

    @Override
    public Boolean addBlog(Blog blog) {
        return blogMapper.addBlog(blog);
    }

    @Override
    public Boolean updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public Boolean deleteBlog(Integer id) {
        return blogMapper.deleteBlog(id);
    }

}
