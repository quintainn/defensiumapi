package br.com.quintain.defensiumapi.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.quintain.defensiumapi.entity.UsuarioEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsuarioImplementacaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<UsuarioEntity> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Long sistemaID = getSistemaIdDoUsuarioLogado();
        if (sistemaID != null) {
            session.enableFilter("sistemaFilter")
                    .setParameter("id_sistema", sistemaID);
        }
        return session.createQuery("""
                    SELECT usuarioEntity
                    FROM UsuarioEntity usuarioEntity
                """).getResultList();
    }

    private Long getSistemaIdDoUsuarioLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof Jwt jwt) {
            return jwt.getClaim("sistemaID");
        }
        return null;
    }

}
