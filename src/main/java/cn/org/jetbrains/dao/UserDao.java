package cn.org.jetbrains.dao;

import cn.org.jetbrains.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author changwenhu
 * @Date 2017/11/14
 * @Description ${todo}
 */
@Mapper
public interface UserDao {
    @Select("select *from t_user where account=#{account}")
    UserInfo findByAccount(String account);
}
