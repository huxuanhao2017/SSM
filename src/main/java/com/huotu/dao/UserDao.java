package com.huotu.dao;

import com.huotu.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hxh on 2017-06-13.
 */
@Repository
public interface UserDao {

    @Select("select customer_name from customer where email= #{email}")
    String queryUserNameByEmail(@Param("email") String email);

    User queryUserInfoByEmail(@Param("email") String email);

    void save(User user);

    List<User> findALL();

}
