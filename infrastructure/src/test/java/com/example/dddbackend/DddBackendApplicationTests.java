package com.example.dddbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class DddBackendApplicationTests {

    @Test
    void contextLoads() {

        var am = ApplicationModules.of(DddBackendApplication.class);
        am.verify(); // is modular!

        System.out.println(am);

        new Documenter(am).writeDocumentation();
    }

}
