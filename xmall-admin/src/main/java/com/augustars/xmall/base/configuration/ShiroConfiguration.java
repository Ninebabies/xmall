package com.augustars.xmall.base.configuration;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.augustars.xmall.util.ShiroDBRealm;


@Configuration
public class ShiroConfiguration {
	//设置自定定义的认证域位置
	@Bean
	public ShiroDBRealm shiroDBRealm() {
		System.out.println("设置自定定义的认证域位置");
		return new ShiroDBRealm();
	}
	//获得securityManagerBean对象
	//设置shiro的核心认证对象
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = 
				new DefaultWebSecurityManager();
		securityManager.setRealm(shiroDBRealm());
		System.out.println("设置shiro的核心认证对象");
		return securityManager;
	}
	//设置认证规则过滤器
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
		System.out.println("判断请求");
		// 获得Shiro过滤Bean组件shiroFilter
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		// 设定核心管理对象，规定请求的方式是POST请求
		shiroFilter.setSecurityManager(securityManager);
		// 在shiroFilter中设定，当需要进行认证时，所需要进行的重定向路径地址
		// 配置当需要认证时，系统跳转到登录界面的请求地址
		shiroFilter.setLoginUrl("/user/userLogin");
		// 配置当认证成功后，默认的重定向的跳转地址
		// 若在认证之前，就已经存在要跳转的地址，则shiro框架会自动向该地址进行重定向
//		shiroFilter.setSuccessUrl("/index");
		//拦截器
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
			//静态资源无需认证anon
			// 	对于静态statis中的东西无需验证
			//	authc:所有url都必须认证通过才可以访问
			//	anon:所有的url都可以匿名访问
		filterChainDefinitionMap.put("/static/**", "anon");
		// 对于退出请求使用推出规则，无需认证，其中具体的退出代码Shiro已经替我们完成
		filterChainDefinitionMap.put("/user/logout", "logout");
		// 对于其他的请求需要认证
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilter;
	}
}
