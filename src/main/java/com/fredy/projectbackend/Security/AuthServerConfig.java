package com.fredy.projectbackend.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
*use jaxb-api, jaxb-impl, jaxb-core, javax-activation dependencies if we use java version >8
 */

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    AuthenticationManager authenticationManager;

    static class CorsFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {

            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

            res.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
            res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            res.setHeader("Access-Control-Max-Age","3600");
            res.setHeader("Access-Control-Allow-Headers","Authorization, Content-Type");
            res.setHeader("Access-Control-Expose-Headers","*");
            res.setHeader("Access-Control-Allow-Credentials","true");

            if (req.getMethod().equalsIgnoreCase("OPTIONS")){
                res.setStatus(200);
            }else {
                filter.doFilter(req, res);
            }
        }

        @Override
        public void destroy() {

        }
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception{
        security.addTokenEndpointAuthenticationFilter(new CorsFilter());
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        clients.inMemory().
                withClient("client").
                secret("{noop}secret").
                authorizedGrantTypes("password").
                resourceIds("oauth2-resource").
                scopes("read");

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endPoints) throws Exception{
        endPoints.authenticationManager(authenticationManager);
    }



}
