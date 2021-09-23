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

    Integer getCountByTypeId(@Param("typeId") Integer typeId);

    Blog getBlog(@Param("id") Integer id);

    List<Blog> getBlogs();

    List<Blog> getBlogsByTypeId(@Param("typeId") Integer typeId);

    List<Blog> getBlogsByUserId(@Param("userId") Integer userId);

    List<Blog> getBlogsByRecommend();

    List<Blog> getBlogsByYear(@Param("startTime") String startTime,
                              @Param("endTime") String endTime);

    Integer getCountByTitleLike(@Param("titleLike") String titleLike);

    List<Blog> getBlogsByTitleLike(@Param("titleLike") String titleLike);

    List<Blog> getBlogsByTitleLikeAndTypeId(@Param("titleLike") String titleLike,
                                            @Param("typeId") Integer typeId);

    Integer getCountByTitleLikeAndTypeId(@Param("titleLike") String titleLike,
                                         @Param("typeId") Integer typeId);

    Boolean addBlog(Blog blog);

    Boolean updateBlog(Blog blog);

    Boolean deleteBlog(@Param("id") Integer id);
}
