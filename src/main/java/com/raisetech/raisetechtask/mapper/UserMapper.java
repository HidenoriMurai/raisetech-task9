package com.raisetech.raisetechtask.mapper;

import com.raisetech.raisetechtask.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM names")
    List<User> findAll();

    @Select("SELECT * FROM names WHERE id = #{id}")
    Optional<User> findById(int id);

    @Select("SELECT * FROM names WHERE age = #{age}")
    List<User> findByAge(int age);

}
