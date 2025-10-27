package com.example.dddbackendjd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class DddBackendJdApplicationTests {

    @Test
    void contextLoads() {

        var am = ApplicationModules.of(DddBackendJdApplication.class);
        am.verify(); // is modular!

        System.out.println(am);

        new Documenter(am).writeDocumentation();
    }

}
