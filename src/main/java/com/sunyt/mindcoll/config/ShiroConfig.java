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
        webSessionManager.setGlobalSessionTimeout(20000);
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("token");
        webSessionManager.setSessionIdCookie(simpleCookie);
        return webSessionManager;
    }
}
