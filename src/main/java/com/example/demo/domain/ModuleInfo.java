package com.example.demo.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ModuleInfo implements Serializable {
    /**
     * 路径
     */
    public static final int URL_TYPE = 1;
    /**
     * 功能点
     */
    public static final int FUNCTION_TYPE = 2;
    private static final long serialVersionUID = -4297656027873404254L;
    private int id;
    private String moduleName;
    private String modulePath;
    private int moduleType;
    private String moduleKey;
    private Date createTime;

}