package com.dmc30.clientui.security;

import com.dmc30.clientui.proxy.UserServiceProxy;
import com.dmc30.clientui.shared.utilisateur.RoleDto;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
//public class TokenValidationHelper extends OncePerRequestFilter {
public class TokenValidationHelper extends BasicAuthenticationFilter {

    Logger logger = LoggerFactory.getLogger(TokenValidationHelper.class);

    @Autowired
    Environment environment;
    @Autowired
    UserServiceProxy userServiceProxy;

    public TokenValidationHelper(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    public boolean isJwtValid(String jwt) {
        boolean returnValue = true;
        String subject = Jwts.parser()
                .setSigningKey(environment.getProperty("token.secret"))
                .parseClaimsJws(jwt)
                .getBody()
                .getSubject();
        if (subject == null || subject.isEmpty()) {
            returnValue = false;
        }
        return returnValue;
    }

//    @Override
//    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws IOException, ServletException {
//        request = (HttpServletRequest) request;
//
//        //extract token from header
//        final String accessToken = request.getHeader("header-name");
//        if (null != accessToken) {
//            //get and check whether token is valid ( from DB or file wherever you are storing the token)
//
//            //Populate SecurityContextHolder by fetching relevant information using token
//            final User user = new User(
//                    "username",
//                    "password",
//                    true,
//                    true,
//                    true,
//                    true,
//                    authorities);
//            final UsernamePasswordAuthenticationToken authentication =
//                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        }
//
//        filterChain.doFilter(request, response);
//    }

    public UsernamePasswordAuthenticationToken getAuthentication(String token, String roles) {
        Set<String> roleList = stringTokenizerHelper(roles);
//        Set<RoleDto> roleList = userServiceProxy.findUtilisateurByPublicId(publicId).getRoles();
        List<GrantedAuthority> authorities = roleList
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        if (token != null) {
            String user = Jwts.parser().setSigningKey(environment.getProperty("token.secret"))
                    .parseClaimsJws(token.replace("Bearer", ""))
                    .getBody()
                    .getSubject();
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, authorities);

            }
            return null;
        }
        return null;
    }

    public Set<String> stringTokenizerHelper(String subject) {
        List<String> result = new ArrayList<>();
        List<String> result2 = new ArrayList<>();
        Set<String> rolesList = new HashSet<>();

        StringTokenizer st = new StringTokenizer(subject, ",");
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(result.get(0), "=");
        while (st2.hasMoreTokens()) {
            result2.add(st2.nextToken());
        }
        rolesList.add(result2.get(1));
        return rolesList;
    }
}
