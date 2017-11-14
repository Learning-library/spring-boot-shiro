package cn.org.jetbrains.service.impl;

import cn.org.jetbrains.dao.UserDao;
import cn.org.jetbrains.pojo.ModuleInfo;
import cn.org.jetbrains.pojo.UserInfo;
import cn.org.jetbrains.service.ModuleService;
import cn.org.jetbrains.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author changwenhu
 * @Date 2017/11/14
 * @Description ${todo}
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ModuleService moduleService;

    @Override
    public List<String> findPermissionUrl(String account) {
        List<String> list = new ArrayList<>();
        UserInfo user = findByAccount(account);
        List<ModuleInfo> modules = moduleService.findModuleByUserId(user.getId());

        for (ModuleInfo info : modules) {
            if (info.getModuleType() == ModuleInfo.URL_TYPE) {
                list.add(info.getModulePath());
            }
        }
        return list;
    }

    @Override
    public Set<String> findPermissions(String account) {
        return null;
    }

    @Override
    public UserInfo findByAccount(String account) {
        return userDao.findByAccount(account);
    }
}
