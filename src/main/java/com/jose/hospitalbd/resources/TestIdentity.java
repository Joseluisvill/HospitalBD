/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jose.hospitalbd.resources;

import static java.util.Arrays.asList;
import java.util.HashSet;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;

/**
 *
 * @author Jose Luis
 */
@ApplicationScoped
public class TestIdentity implements IdentityStore {
    
    public CredentialValidationResult validate(UsernamePasswordCredential user)
    {
        if(user.compareTo("jose", "jose"))
        {
            return new CredentialValidationResult("jose",new HashSet<>(asList("admin","todos")));
        }
        return INVALID_RESULT;
    }
    
}
