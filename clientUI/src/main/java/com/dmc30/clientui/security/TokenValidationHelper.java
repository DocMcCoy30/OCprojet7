package com.dmc30.clientui.security;

import com.dmc30.clientui.proxy.UserServiceProxy;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

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

    /**
     * Vérifie le token envoyé par user-service
     *
     * @param jwt le token
     * @return un boolean selon le résultat positif/négatif de la vérification
     */
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

    /**
     * Récupère le token et l'utilise afin de définir l'utilisateur à intégrer dans le context de sécurité pour connexion.
     *
     * @param token le token envoyé par user-service
     * @param roles le(s) rôles de l'utilisateur.
     * @return un objet UsernamePasswordAuthenticationToken définissant l'utilisateur et ses roles si la vérification est un succès.
     */
    public UsernamePasswordAuthenticationToken getAuthentication(String token, String roles) {
        Set<String> roleList = stringTokenizerHelper(roles);
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

    /**
     * Permet de formater le(s) roles de l'utilisateur qui souhaite se connecter (string -> set<GrantedAuthorities>)
     *
     * @param subject le(s) role(s) de l'utilisateur sous forme d'une chaine de caracteres
     * @return un set de string roles
     */
    public Set<String> stringTokenizerHelper(String subject) {
        logger.info("String subject = " + subject);
        String st1 = subject.replace("[", "");
        String st2 = st1.replace("]", "");
        String st3 = st2.replace(" ", "");
        Set<String> rolesList = new HashSet<>();
        StringTokenizer st = new StringTokenizer(st3, ",");
        while (st.hasMoreTokens()) {
            rolesList.add(st.nextToken());
        }
//        List<String> result = new ArrayList<>();
//        List<String> result2 = new ArrayList<>();
//        Set<String> rolesList = new HashSet<>();
//        StringTokenizer st = new StringTokenizer(subject, ",");
//        while (st.hasMoreTokens()) {
//            result.add(st.nextToken());
//        }
//        String st2 = result.toString();
//        StringTokenizer st2 = new StringTokenizer(result.get(0), "=");
//        while (st2.hasMoreTokens()) {
//            result2.add(st2.nextToken());
//        }
//        rolesList.add(result2.get(1));
        return rolesList;
    }
}
