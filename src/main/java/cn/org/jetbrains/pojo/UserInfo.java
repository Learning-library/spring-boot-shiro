package cn.org.jetbrains.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 730863452165463427L;

    private int id;
    private String account;
    private String password;
    private String name;
    private Date createTime;


}