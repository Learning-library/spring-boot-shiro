package cn.org.jetbrains.service.impl;

import cn.org.jetbrains.dao.ModelDao;
import cn.org.jetbrains.pojo.ModuleInfo;
import cn.org.jetbrains.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author changwenhu
 * @Date 2017/11/14
 * @Description ${todo}
 */
@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModelDao modelDao;

    @Override
    public List<ModuleInfo> findModuleByUserId(int userId) {
        return modelDao.findModuleByUserId(userId);
    }
}
