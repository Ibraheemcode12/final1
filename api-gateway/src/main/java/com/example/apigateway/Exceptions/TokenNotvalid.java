package com.example.apigateway.Exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TokenNotvalid extends Exception{
    
public TokenNotvalid(String msg){
    super(msg);
}

}
