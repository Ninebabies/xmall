package com.augustars.xmall.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.alibaba.dubbo.config.annotation.Reference;
import com.augustars.xmall.entity.User;
import com.augustars.xmall.transport.UserTransport;
public class SecurityUtil extends AuthorizingRealm {
	@Reference(version="1.0.0")
	private UserTransport userTransport;
	
	//用户进行授权认证
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
		return null;
	}
//		用户进行授权认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("开始认证");
//		对于AuthenticationToken进行类型转换
		UsernamePasswordToken userToken = (UsernamePasswordToken) token;
		System.out.println(userToken);
		//	获得登录用户名
		String loginName = userToken.getUsername();
		String password = new String(userToken.getPassword());
//		password = Encr yptionUtil.encrypt(password);
		userToken.setPassword(password.toCharArray());
		
		if (loginName != null && !"".equals(loginName.trim()) && password != null && !"".equals(password.trim())) {
			userToken.setPassword(EncryptionUtil.encrypt(password).toCharArray());
			System.out.println(".......");
			
		// 使用登录名查找用户信息
				// 判断是否启用
				try {
					User user = userTransport.getUserByLoginName(loginName);
					System.out.println(user);
					if (user != null && ConstantUtil.STATUS_YES.equals(user.getStatus().getStatusCode())) {
						SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), getName());
						SecurityUtils.getSubject().getSession().setAttribute("user", user);
						return info;
					} else {
						throw new AuthenticationException("该用户无法正常登陆，请联系管理员");
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new AuthenticationException("系统错误请联系管理员");
				}
		} else {
			throw new AuthenticationException("请填写用户名和密码");
		}
	}
}


