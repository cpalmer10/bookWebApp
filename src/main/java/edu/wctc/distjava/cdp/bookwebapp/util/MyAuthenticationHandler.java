package edu.wctc.distjava.cdp.bookwebapp.util;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class MyAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, 
                HttpServletResponse response, Authentication authentication) 
                throws ServletException, IOException {
            
        String mgrTargetUrl = "/index.jsp"; // change to whatever you use
        String userTargetUrl = "/index.jsp";  // change to whatever you use and add more targetURLs if needed
        
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        
        // Change to accommodate whatever you need, such different or additional groups
        if (roles.contains("ROLE_MGR")) {
            getRedirectStrategy().sendRedirect(request, response, mgrTargetUrl);
        } else if (roles.contains("ROLE_USER")) {
            getRedirectStrategy().sendRedirect(request, response, userTargetUrl);
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
            return;
        }
    }
}