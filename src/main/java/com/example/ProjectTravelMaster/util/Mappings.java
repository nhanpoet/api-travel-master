package com.example.ProjectTravelMaster.util;

public final class Mappings {   
    public static final String API_User="/user";
    public static final String API_UserGetId="/user/{id}";
    
    public static final String API_UserPost="/postuser";
    public static final String API_UserPostGetId="/postuser/{id}";
     
    public static final String API_UserPostComment="/postusercomment";
    public static final String API_UserPostCommentGetId="/postusercomment/{id}";
    
    public static final String API_Enterprise="/enterprise";
    public static final String API_EnterpriseGetId="/enterprise/{id}";   
    
    public static final String API_EnterprisePost ="postenterprise";
    public static final String API_EnterprisePostGetId ="postenterprise/{id}";
    
    public static final String API_EnterprisePostComment ="commentpostenterprise";
    public static final String API_EnterprisePostCommentGetId ="commentpostenterprise/{id}";
    
    private Mappings() {
    }
}

