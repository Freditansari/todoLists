package com.fredy.projectbackend.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
/*
*use jaxb-api, jaxb-impl, jaxb-core, javax-activation dependencies if we use java version >8
 */

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    AuthenticationManager authenticationManager;

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
