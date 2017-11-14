package cn.org.jetbrains.config;

import cn.org.jetbrains.pojo.UserInfo;
import cn.org.jetbrains.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 验证用户登录
 *
 * @author Administrator
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    public UserRealm() {
        setName("UserRealm");
        // 采用MD5加密
        setCredentialsMatcher(new HashedCredentialsMatcher("md5"));
    }

    //权限资源角色
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(userService.findPermissions(username));
//        info.setRoles(w);
        return info;
//        return null;
    }

    //登录验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upt = (UsernamePasswordToken) token;
        String userName = upt.getUsername();
        UserInfo user = userService.findByAccount(userName);

        if (user == null) {
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, user.getPassword(), getName());
        return info;
    }
}