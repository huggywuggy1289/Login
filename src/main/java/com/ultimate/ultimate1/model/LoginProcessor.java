package com.ultimate.ultimate1.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component // 스프링에 이 클래스가 빈이라고 지정하려고 스테레오타입 에너테이션을 사용한다
@RequestScope // 요청스코프
public class LoginProcessor {
    private String username;
    private String password;

    public boolean login(){
        String username = this.getUsername();
        String password = this.getPassword();

        if("natalie".equals(username) && "password".equals(password)){ // 아이디값과 비번을 모델에 저장
            return true;
        }else{
            return false;
        }
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
