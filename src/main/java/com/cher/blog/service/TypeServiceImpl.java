package com.cher.blog.service;

import com.cher.blog.dao.TypeMapper;
import com.cher.blog.pojo.Type;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Integer getCount() {
        return typeMapper.getCount();
    }

    @Override
    public Type getType(Integer id) {
        return typeMapper.getType(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    public List<Type> getTypes() {
        return typeMapper.getTypes();
    }

    @Override
    public List<Type> getTypesByPage(Integer offset, Integer limit) {
        PageHelper.startPage(offset, limit);
        List<Type> types = typeMapper.getTypes();
        return types;
    }

    @Override
    public Boolean addType(Type type) {
        return typeMapper.addType(type);
    }

    @Override
    public Boolean updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public Boolean deleteType(Integer id) {
        return typeMapper.deleteType(id);
    }
}
