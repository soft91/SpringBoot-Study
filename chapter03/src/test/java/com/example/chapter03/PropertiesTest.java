package com.example.chapter03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

// SpringBootTest에서 properties 재정의 가능.
@SpringBootTest(classes=BoardController.class,
                properties = {
                        "author.name = gurum",
                        "author.age = 45",
                        "author.nation = Korea"
                })
public class PropertiesTest {

    @Autowired
    Environment environment;
    // Environment = application.properties에 접근하기 위한 객체

    @Test
    public void testMethod(){
        System.out.println("이름 : " + environment.getProperty("author.name"));
        System.out.println("나이 : " + environment.getProperty("author.age"));
        System.out.println("국가 : " + environment.getProperty("author.nation"));
    }
}
