package com.sunyt.mindcoll.config;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    /**
     * @return realm
     */
    @Bean
    public Realm realm(){
        return new CustomRealm();
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        // all paths are managed via annotations
        chainDefinition.addPathDefinition("/guest/**", "anon");
        chainDefinition.addPathDefinition("/admin/**", "authc, roles[admin]");
        chainDefinition.addPathDefinition("/user/**", "authc, roles[user]");

        // all other paths require a logged in user
        chainDefinition.addPathDefinition("/**", "authc");

        return chainDefinition;
    }

    @Bean
    protected CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    @Bean
    protected SessionManager sessionManager(){
        DefaultWebSessionManager webSessionManager = new DefaultWebSessionManager();
        //过期时间（毫秒）
        webSessionManager.setGlobalSessionTimeout(18000000);
        //相隔多久检查session的有效性
        webSessionManager.setSessionValidationInterval(1800000);
        SimpleCookie simpleCookie = new SimpleCookie();
        //设置Cookie名字
        simpleCookie.setName("token");
        //设置Cookie的域名
        simpleCookie.setDomain("");
        //设置Cookie的过期时间，秒为单位，默认-1表示关闭浏览器时过期Cookie；
        simpleCookie.setMaxAge(3600);
        //如果设置为true，则客户端不会暴露给客户端脚本代码
        simpleCookie.setHttpOnly(true);
        //设置Cookie的路径，默认空，即存储在域名根下；
        simpleCookie.setPath("");
        webSessionManager.setSessionIdCookie(simpleCookie);
        return webSessionManager;
    }
}
