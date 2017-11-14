package cn.org.jetbrains.dao;

import cn.org.jetbrains.pojo.ModuleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author changwenhu
 * @Date 2017/11/14
 * @Description ${todo}
 */
@Mapper
public interface ModelDao {
    @Select(value = "select e.*from t_user_role b left join t_role c on b.role_id=c.id left join t_role_module d on c.id=d.role_id left join t_module e on d.module_id=e.id where b.user_id=#{userId}")
    List<ModuleInfo> findModuleByUserId(int userId);
}
