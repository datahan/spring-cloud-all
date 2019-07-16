package com.datahan.server.harbour;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LocalTest {

    @Test
    public void encode() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String han = encoder.encode("han");
        String jim = encoder.encode("jim");
        System.out.println("han:" + han);
        System.out.println("jim:" + jim);
    }
}
