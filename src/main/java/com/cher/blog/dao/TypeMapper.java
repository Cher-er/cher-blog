package com.cher.blog.dao;

import com.cher.blog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {

    Integer getCount();

    Type getType(@Param("id") Integer id);

    Type getTypeByName(@Param("name") String name);

    List<Type> getTypes();

    Boolean addType(Type type);

    Boolean updateType(Type type);

    Boolean deleteType(@Param("id") Integer id);

}
