package br.com.quintain.defensiumapi.filter;

import java.io.IOException;

import org.hibernate.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.persistence.EntityManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HibernateFilter extends OncePerRequestFilter {

    private final EntityManager entityManager;

    public HibernateFilter(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof Jwt jwt) {
            Long sistemaID = jwt.getClaim("sistemaID");
            if (sistemaID != null) {
                Session session = entityManager.unwrap(Session.class);
                session.enableFilter("sistemaFilter")
                        .setParameter("id_sistema", sistemaID);
            }
        }
        filterChain.doFilter(request, response);
    }

}
