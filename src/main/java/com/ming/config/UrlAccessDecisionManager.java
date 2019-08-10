package com.ming.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * 进行访问控制权限验证
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {
    /**
     *
     * @param authentication
     * @param object
     * @param configAttributes  相关配置信息
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while(iterator.hasNext()){
            ConfigAttribute configAttribute = iterator.next();
            String needRole = configAttribute.getAttribute();
            if("ROLE_LOGIN".equals(needRole)){
                // 判断auth是否是匿名用户
                if(authentication instanceof AnonymousAuthenticationToken){
                    throw new BadCredentialsException("未登录");
                }else{
                    return;
                }
            }
            // 判断当前用户的角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for(GrantedAuthority authority: authorities){
                if(authentication.getAuthorities().equals(needRole)){
                    return;
                }
            }
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
