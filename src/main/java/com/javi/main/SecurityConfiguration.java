package com.javi.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final static String USER_QUERY = "select email, password, confirmed from user where email = ?";

    private final static String ROLE_QUERY = "select u.email, r.name " +
            " from user u " +
            " inner join role r on r.id = u.role" +
            " where u.email = ?";

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().disable()
                .cors().and().csrf().disable()
//                .httpBasic()
//                .and()
                .headers().frameOptions().sameOrigin()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/javi/user/**").hasRole("ADMIN")
//                .antMatchers("/javi/role/**").hasRole("ADMIN")
//                .antMatchers("/javi/work/**").not().hasRole("user")
//                .anyRequest()
//                .authenticated()
                ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(USER_QUERY)
                .authoritiesByUsernameQuery(ROLE_QUERY)
//                .passwordEncoder(passwordEncoder())
        ;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return BCrypt.hashpw(charSequence + "javi¡¿?!", BCrypt.gensalt());
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return BCrypt.checkpw(charSequence + "javi¡¿?!", s);
//            }
//        };
//    }
}
