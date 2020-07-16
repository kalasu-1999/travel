package com.example.demo.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.Guest;
import com.example.demo.service.JWTService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


@Service
public class JWTServiceImpl implements JWTService {
    @Override
    public String createToken(Integer guestId, String username,Integer flag){
        Map<String,Object> map = new HashMap<>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        try {
            return JWT.create()
                    .withHeader(map)
                    .withClaim("guestId", Double.valueOf(guestId))
                    .withClaim("username",username)
                    .withClaim("flag",Double.valueOf(flag))
                    .sign(Algorithm.HMAC256("secret"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Guest verifyToken(HttpServletRequest request, String key){
        String token = request.getHeader("token");
        JWTVerifier verifier;
        try {
            verifier = JWT.require(Algorithm.HMAC256(key)).build();
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> claimMap = jwt.getClaims();
            return new Guest(claimMap.get("guestId").asInt(),claimMap.get("username").asString(),null,claimMap.get("flag").asInt());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
