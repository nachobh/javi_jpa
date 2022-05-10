package com.javi.main;

import org.junit.jupiter.api.Test;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;


public class SecurityConfigurationTest extends WebSecurityConfigurerAdapter {

    @Test
    public void criptTest() {
        String hashed = BCrypt.hashpw("2204" + "2204¡¿?!", BCrypt.gensalt());
        System.out.println(hashed);
        org.junit.jupiter.api.Assertions.assertTrue(BCrypt.checkpw("2204" + "2204¡¿?!", hashed));
        org.junit.jupiter.api.Assertions.assertTrue(BCrypt.checkpw("2204" + "2204¡¿?!", "$2a$10$Ke7dQCn3gVOoVC7ILBpHlOVutNdq9zeYkhFvruudFZ860zRkB6oQW"));
        org.junit.jupiter.api.Assertions.assertTrue(BCrypt.checkpw("2204" + "2204¡¿?!", "$2a$10$wjonRw7QFM100VFZaBmcN./h/uA27WnpZluchyFPuqmOLmfz5ca.O"));
    }
}
