package com.example.demo.service;


import com.example.demo.domain.ModuleInfo;

import java.util.List;

public interface ModuleService {
    /**
     * 获取角色模块
     *
     * @param userId
     * @return
     */
    List<ModuleInfo> findModuleByUserId(int userId);
}
