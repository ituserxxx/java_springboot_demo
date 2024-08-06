package org.example.xcx.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class JwtUtil {
    @Value("${jwt.tokenPrefix}")
    private String tokenPrefix;
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expireTime}")
    private int expireTime;

    public String createToken(Integer id, String sub) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, this.expireTime);
        String token = JWT.create().withClaim(sub, id).
                withExpiresAt(calendar.getTime()).
                sign(Algorithm.HMAC256(this.secret));
        return token;
    }

    public String verifyToken(String token) {
        return JWT.require(Algorithm.HMAC256(this.secret)).
                build().verify(token).getSubject();
    }
}
