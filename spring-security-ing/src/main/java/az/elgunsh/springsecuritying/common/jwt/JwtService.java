package az.elgunsh.springsecuritying.common.jwt;

import az.elgunsh.springsecuritying.common.jwt.config.SecurityProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public final class JwtService {
    private final SecurityProperties applicationProperties;

    private Key key;

    @PostConstruct
    public void init() {
        byte[] keyBytes;
        keyBytes = Decoders.BASE64.decode(applicationProperties.getJwtProperties().getSecret());
        key = Keys.hmacShaKeyFor(keyBytes);
    }

    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String issueToken(Authentication authentication) {
        log.trace("Issue JWT token to {} for {}", authentication.getPrincipal(),
                applicationProperties.getJwtProperties().getTokenValidityInSeconds());


        List<String> collect = authentication.getAuthorities()
                .stream().map((authority) -> authority.getAuthority())
                .collect(Collectors.toList());

        final JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(
                        Duration.ofSeconds(applicationProperties.getJwtProperties().getTokenValidityInSeconds()))))
                .setHeader(Map.of("type", "JWT"))

                .addClaims(Map.of("role", collect))
                .signWith(key, SignatureAlgorithm.HS512);

        return jwtBuilder.compact();
    }

}

