package com.oms.cmm.security;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.RequiredArgsConstructor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author 안경수
 * @since 2023. 2. 13.
 * @see
 */

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private String secretKey  = "omsSecretKey";
    
    private final long tokenValidTime = 60 * 60 * 1000L; // 1시간
//    private final UserDetailsService userDetailsService;
    
    @PostConstruct
    protected void init() {
        secretKey  = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
    
    
    // JWT 토큰 생성
    public String createToken(String username, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(username); 
        claims.put("roles", roles); 
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims) 
                .setIssuedAt(now) 
                .setExpiration(new Date(now.getTime() + tokenValidTime)) 
                .signWith(SignatureAlgorithm.HS256, secretKey)  
                .compact();
    }

    // JWT 토큰에서 인증 정보 조회
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//    }

    // 토큰에서 회원 정보 추출
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // Request의 Header에서 token 값을 가져옵니다. "X-AUTH-TOKEN" : "TOKEN값'
    public String getToken(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }

    // 토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
    
}
