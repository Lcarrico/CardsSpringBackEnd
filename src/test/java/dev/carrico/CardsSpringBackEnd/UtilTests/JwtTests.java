package dev.carrico.CardsSpringBackEnd.UtilTests;

import com.auth0.jwt.interfaces.DecodedJWT;
import dev.carrico.utils.JwtUtil;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JwtTests {
    static String testjwt;

    @Test
    @Order(1)
    void creates_jwt(){
        String jwt = JwtUtil.generate("test",1);
        System.out.println(jwt);
    }

    @Test
    @Order(2)
    void create_jwt_manager(){
        String jwt = JwtUtil.generate("test username",2);
        System.out.println(jwt);
        testjwt = jwt;
    }

    @Test
    @Order(3)
    void decode_jwt(){
        DecodedJWT jwt = JwtUtil.isValidJWT(testjwt);
        String username = jwt.getClaim("username").asString();
        int id = jwt.getClaim("id").asInt();
        System.out.println(username);
        System.out.println(id);
        Assertions.assertEquals("test username",username);
        Assertions.assertEquals(2, id);
    }

}