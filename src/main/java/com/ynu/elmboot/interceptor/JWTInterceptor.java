package com.ynu.elmboot.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.ynu.elmboot.util.JwtUtil;
import com.ynu.elmboot.util.RedisCache;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;
import java.util.Objects;

@Component
public class JWTInterceptor implements HandlerInterceptor {
    private final RedisCache redisCache;

    @Autowired
    public JWTInterceptor(RedisCache redisCache) {
        this.redisCache = redisCache;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // 放行OPTIONS请求
        if ("OPTIONS".equals(request.getMethod())) {
            return true;
        }
        try {
            // 从Authorization中获取token
            String JWT = request.getHeader("Authorization");
            // 进行JWT验证
            Map<String, Claim> decodedJWT = JwtUtil.verifyToken(JWT);
            // 从redis中获取用户信息，验证是否处于登陆状态
            System.out.println(decodedJWT.get("id"));
            String id = decodedJWT.get("id").asString();
            String key = "user:" + id;
            if (!Objects.isNull(redisCache.getCacheObject(key))) {
                return true;
            }

        } catch (NullPointerException e) {
            System.out.println("无token");
            e.printStackTrace();
        } catch (SignatureVerificationException e) {
            System.out.println("无效签名");
            e.printStackTrace();
        } catch (TokenExpiredException e) {
            System.out.println("token已经过期");
            e.printStackTrace();
        } catch (AlgorithmMismatchException e) {
            System.out.println("算法不一致");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("token无效");
            e.printStackTrace();
        }
        return false;
    }
}

