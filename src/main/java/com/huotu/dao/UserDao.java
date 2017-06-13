package com.huotu.dao;

import com.huotu.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by huxuanhao on 2017-06-13.
 */
@Repository("userDao")
public interface UserDao {

    @Select("select customer_name from customer where email= #{email}")
    String queryUserNameByEmail(@Param("email") String email);

    User queryUserInfoByEmail(@Param("email") String email);

}
