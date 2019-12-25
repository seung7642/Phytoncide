package com.pangtrue.user.model;

public class LoginDTO {

    private String userEmail;
    private String userPassword;
    private boolean useCookie;
    
    public String getUserEmail() {
        return userEmail;
    }
    
    public void setUserId(String userEmail) {
        this.userEmail = userEmail;
    }
    
    public String getUserPassword() {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public boolean isUseCookie() {
        return useCookie;
    }
    
    public void setUseCookie(boolean useCookie) {
        this.useCookie = useCookie;
    }
    
    @Override
    public String toString() {
        return "LoginDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", useCookie=" + useCookie +
                '}';
    }
}
