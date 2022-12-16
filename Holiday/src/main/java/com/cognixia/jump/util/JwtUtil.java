package com.cognixia.jump.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


// Tool for JWTs
// Will create new jwts
// Pull up info from existing jwts

@Service
public class JwtUtil {

    // Use with algorithm to hash/code token
    private final String SECRET_KEY = "holiday";

    // Creates the token
    private String createToken(Map<String, Object> claims, String subject) {

        // Set claims
        // Subject (User that is being authenticated)
        // Set when the token was issued
        // Set expiration when token expires and can be no longer used (Set for 10 hr)
        // Sign it with particular algorithm and secret key that lets you know this
        // token is authentic

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

    }

    // extracting claims, getting all info stored in JWT
    private Claims extractAllClaims(String token) {

        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    // Checks if the token has expired yet by checking the current data & time and
    // comparing it to the expiration
    private Boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());

    }

    
    // takes a token and a claims resolver to find out what the claims are for that
    // particular token
    // so find that data that was passed in through the token and be able to access
    // it again (username, expiration date)
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);

    }

    // Get the username for this token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // get expiration date for this token
    public Date extractExpiration(String token) {

        // :: -> method reference
        // -> pointer, access a method in a class
        // -> that way we can pass a method as an argument
        return extractClaim(token, Claims::getExpiration);
    }

    // returns those generated tokens after a successful authentication
    public String generateTokens(UserDetails userDetails) {

        // Claims info/data you want to include in payload of token besides the user
        // info
        Map<String, Object> claims = new HashMap<>();

        // Returns token for user given along with any claims
        return createToken(claims, userDetails.getUsername());

    }

    // Will validate the token and check if the current token is for the right user
    // requesting it and that the token isn't expired
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
