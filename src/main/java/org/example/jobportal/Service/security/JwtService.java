package org.example.jobportal.Service.security;

import io.jsonwebtoken.Claims;
import org.example.jobportal.Model.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
@Service
public interface JwtService  {

    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Claims, T> resolver);

    List<String> getRolesFromToken(String token);

    boolean isValid(String token, UserDetails user);

    String generateToken(User user);



    ;


}
