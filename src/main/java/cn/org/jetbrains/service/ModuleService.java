package cn.org.jetbrains.service;

import cn.org.jetbrains.pojo.ModuleInfo;

import java.util.List;

/**
 * @Author changwenhu
 * @Date 2017/11/14
 * @Description ${todo}
 */
public interface ModuleService {


    List<ModuleInfo> findModuleByUserId(int id);
}
