package cn.org.jetbrains.controller;

import cn.org.jetbrains.pojo.UserInfo;
import cn.org.jetbrains.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author changwenhu
 * @Date 2017/11/14
 * @Description ${todo}
 */
@RestController
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(HttpServletRequest request) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        UserInfo byAccount = userService.findByAccount(account);
        List<String> permissionUrl = userService.findPermissionUrl(account);
        UsernamePasswordToken upt = new UsernamePasswordToken(account, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(upt);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "您的账号或密码输入错误";
        }
        return "登录成功";
    }

    @GetMapping(value = "index")
    public String index() {
        return "登陆成功 index ";
    }

    @GetMapping(value = "permission")
    public String permission() {
        return "有权限";
    }

    @GetMapping(value = "unauthor")
    public String unauthor() {
        return "没有权限 ";
    }


    @GetMapping(value = "permissionMAX")
    public String permissionMAX() {
        return "有权限 ";
    }
}
