package com.cher.blog.service;

import com.cher.blog.pojo.Type;
import com.cher.blog.pojo.TypeWithCount;

import java.util.List;

public interface TypeService {

    Integer getCount();

    Type getType(Integer id);

    Type getTypeByName(String name);

    List<Type> getTypes();

    List<TypeWithCount> getTypesWithCount();

    List<Type> getTypesByPage(Integer offset, Integer limit);

    Boolean addType(Type type);

    Boolean updateType(Type type);

    Boolean deleteType(Integer id);
}