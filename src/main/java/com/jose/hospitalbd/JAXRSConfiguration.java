package com.jose.hospitalbd;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures JAX-RS for the application.
 * @author Juneau
 */
//@ApplicationScoped
//@DeclareRoles({"admin","todos"})
//@BasicAuthenticationMechanismDefinition(realmName="foo-ee")
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {
    
}
