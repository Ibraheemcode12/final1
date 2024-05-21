package com.example.apigateway.Exceptions;

public class TokenExpiredException extends Exception {
    
public TokenExpiredException(String msg){
    super(msg);
}

}
