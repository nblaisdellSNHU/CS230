package com.gamingroom.gameauth.auth;


import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
 
import java.util.Map;
import java.util.Optional;
import java.util.Set;
 
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
 
public class GameAuthenticator implements Authenticator<BasicCredentials, GameUser> 
{
		
	private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
        "guest", ImmutableSet.of(),
        "user", ImmutableSet.of("USER"),
        "admin", ImmutableSet.of("ADMIN", "USER")
    );
 
    @Override
    public Optional<GameUser> authenticate(BasicCredentials credentials) throws AuthenticationException 
    {
        if (VALID_USERS.containsKey(credentials.getUsername()) && "password".equals(credentials.getPassword())) 
        {
            // NB: Finish the authorize method based on BasicAuth Security Example for new GameUser
        	//     In this example, we are given a set of credentials to see if this user exists and can be authenticated.
        	//	   First, we check to see if the username given exists in our VALID_USERS, and if the password they entered
        	//     is correct (currently, everyone's password is "password"!)
        	//     If the user exists and the password is valid, then we'll create and return a new GameUser
        	//	   with that username, and provide it with the appropriate roles, which are also found in VALID_USERS.
        	return Optional.of(new GameUser(credentials.getUsername(), VALID_USERS.get(credentials.getUsername())));

        }
        
        // If there was no user found, or the password given was invalid, return an empty object
        return Optional.empty();
    }
}
