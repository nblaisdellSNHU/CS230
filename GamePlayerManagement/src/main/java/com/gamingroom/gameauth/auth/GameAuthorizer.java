package com.gamingroom.gameauth.auth;

import io.dropwizard.auth.Authorizer;

public class GameAuthorizer implements Authorizer<GameUser> 
{
    @Override
    public boolean authorize(GameUser user, String role) {    	
        // NB: Finish the authorize method based on BasicAuth Security Example
    	//	   This function takes in a GameUser object, and the name of a role as a String
    	//	   Since the user has an array of roles on it, accessed through getRoles(), we
    	//     can check if this user belongs to the provided role. If not, this will return false,
    	//     letting the rest of the application know that this is not an authorized user.
    	//	   Otherwise, it will return true.
    	return user.getRoles() != null && user.getRoles().contains(role);
    }
}