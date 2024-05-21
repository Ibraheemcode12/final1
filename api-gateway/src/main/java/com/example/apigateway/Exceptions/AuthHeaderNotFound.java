package com.example.apigateway.Exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthHeaderNotFound extends Exception {
    
public AuthHeaderNotFound(String msg){
super(msg);
}

}
