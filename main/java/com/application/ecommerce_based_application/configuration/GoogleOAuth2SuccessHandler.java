package com.application.ecommerce_based_application.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraintvalidation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.application.ecommerce_based_application.model.Role;
import com.application.ecommerce_based_application.model.User;
import com.application.ecommerce_based_application.model.ValidationGroups;
import com.application.ecommerce_based_application.repository.RoleRepository;
import com.application.ecommerce_based_application.repository.UserRepository;

@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler{
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private Validator validator;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
	    OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();
	    
	    String email = oauthUser.getAttribute("email");
	    String name = oauthUser.getAttribute("name");
	    
	    Optional<User> user = userRepository.findUserByEmail(email);
	    
	    if (!user.isPresent()) {
	    	User u=new User();
	        u.setEmail(email);
	        u.setFirstName(name);
	        
	        // Check and set a default password if none is provided
	        String password = oauthUser.getAttribute("password");
	        if (password == null) {
	            password = generateDefaultPassword();
	        }
	        u.setPassword(password);
	        List<Role>roles = new ArrayList<>();
			roles.add(roleRepository.findById(2).get());
			u.setRoles(roles);
	        userRepository.save(u);
	    }
	    
	    response.sendRedirect("/");
	}

	private String generateDefaultPassword() {
	    // Generate a secure default password or use a placeholder
	    return "defaultSecurePassword";
	}

	
}










