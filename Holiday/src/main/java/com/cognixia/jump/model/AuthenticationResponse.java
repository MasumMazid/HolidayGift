package com.cognixia.jump.model;

import java.io.Serializable;


// Response object for when we authenticate and return the JWT created
public class AuthenticationResponse implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String jwt;

    public AuthenticationResponse(){
        
    }
    
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "AuthenticationResponse [jwt=" + jwt + "]";
    }

    


}
