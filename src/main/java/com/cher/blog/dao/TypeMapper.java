package com.cher.blog.dao;

import com.cher.blog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
@RequestMapping
public interface TypeMapper {

    Type getType(Integer id);

    Type getTypeByName(String name);

    List<Type> getTypes();

    Boolean addType(Type type);

    Boolean updateType(Type type);

    Boolean deleteType(Integer id);

}
