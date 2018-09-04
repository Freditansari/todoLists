package com.fredy.projectbackend.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    private final String resourceId = "oauth2-resource";


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception{
        resources.resourceId(resourceId);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        //http.addFilterBefore(new AuthServerConfig.CorsFilter(), ChannelProcessingFilter.class).authorizeRequests().anyRequest().authenticated().and().anonymous().disable()
        http.addFilterBefore(new AuthServerConfig.CorsFilter(), ChannelProcessingFilter.class).exceptionHandling().
                and()
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/oauth/token/**").permitAll()
                .antMatchers("/api/getUserName/**").permitAll()
                .antMatchers("/src/main/image/book/**").permitAll()
                .antMatchers("/books/**").authenticated();


//        http
//                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling()
//                .authenticationEntryPoint(problemSupport)
//                .accessDeniedHandler(problemSupport)
//                .and()
//                .csrf()
//                .disable()
//                .headers()
//                .frameOptions()
//                .disable()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/rfb-locations").permitAll()
//                .antMatchers("/api/register").permitAll()
//                .antMatchers("/api/activate").permitAll()
//                .antMatchers("/api/authenticate").permitAll()
//                .antMatchers("/api/account/reset-password/init").permitAll()
//                .antMatchers("/api/account/reset-password/finish").permitAll()
//                .antMatchers("/api/profile-info").permitAll()
//                .antMatchers("/api/**").authenticated()
//                .antMatchers("/management/health").permitAll()
//                .antMatchers("/management/**").hasAuthority(AuthoritiesConstants.ADMIN)
//                .antMatchers("/v2/api-docs/**").permitAll()
//                .antMatchers("/swagger-resources/configuration/ui").permitAll()
//                .antMatchers("/swagger-ui/index.html").hasAuthority(AuthoritiesConstants.ADMIN)
//                .antMatchers("/").permitAll()
//                .and()
//                .apply(securityConfigurerAdapter());

    }


}
