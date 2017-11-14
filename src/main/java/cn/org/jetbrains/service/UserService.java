package cn.org.jetbrains.service;

import cn.org.jetbrains.pojo.UserInfo;

import java.util.List;
import java.util.Set;

/**
 * @Author changwenhu
 * @Date 2017/11/14
 * @Description ${todo}
 */
public interface UserService {
    List<String> findPermissionUrl(String account);

    Set<String> findPermissions(String account);

    UserInfo findByAccount(String account);
}
