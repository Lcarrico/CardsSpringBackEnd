package dev.carrico.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {

    // never let anyone know your secret
    public static Algorithm getAlgorithm(){
        String secret = "98shg98h49g8h4g98yhw9hfsa98th04whjtg0wjg";
        Algorithm algo = Algorithm.HMAC256(secret);

        return algo;
    }

    // put in the parameters you want to be in the body of your jwt
    public static String generate(String username, int id){
        String token = JWT.create()
                .withClaim("username",username)
                .withClaim("id", id)
                .sign(getAlgorithm()); // this will generate a signature based off of those claims
        return token;
    }

    public static DecodedJWT isValidJWT(String token){
        DecodedJWT jwt = JWT.require(getAlgorithm()).build().verify(token);
        return jwt;
    }

}
