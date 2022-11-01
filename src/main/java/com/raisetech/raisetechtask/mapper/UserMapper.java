package com.raisetech.raisetechtask.mapper;

import com.raisetech.raisetechtask.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM names")
    List<User> findAll();

    @Select("SELECT * FROM names WHERE id = #{id}")
    Optional<User> findById(int id);

    @Select("SELECT * FROM names WHERE age = #{age}")
    List<User> findByAge(Integer age);

    @Insert("INSERT INTO names (name, age) values (#{name}, #{age})")
    void createUser(User user);

    @Delete("DELETE FROM names where id = #{id}")
    void deleteUserId(int id);

    @Update("UPDATE names SET name = #{name}, age = #{age} WHERE id = #{id}")
    void updateUser(User user);
}
