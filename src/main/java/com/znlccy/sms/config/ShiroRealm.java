package com.znlccy.sms.config;

import com.znlccy.sms.common.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Administrator
 * @Datetime: 2018/9/14-17:42
 * @Version: v1.0.0
 * @Comment: Shiro安全连接桥梁
 */
public class ShiroRealm extends AuthorizingRealm {

    /* 授权用户权限 */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        /* 获取用户 */
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        /* 获取用户角色 */
        Set<String> roleSet = new HashSet<String>();
        roleSet.add("100002");
        info.setRoles(roleSet);

        /* 获取用户权限 */
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("权限添加");
        permissionSet.add("权限删除");
        info.setStringPermissions(permissionSet);

        return info;
    }

    /* 验证用户身份 */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        /* 用户密码生成token */
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nickname", username);

        /* 密码进行加密处理 */
        String pwd = password + username;
        String pawDES = pwd;
        map.put("pswd",pawDES);

        /* 创建用户 */
        User user = new User();
        user.setUid(111222);
        user.setUsername(username);
        user.setPassword(pawDES);

        return new SimpleAuthenticationInfo(user,password,getName());
    }
}
