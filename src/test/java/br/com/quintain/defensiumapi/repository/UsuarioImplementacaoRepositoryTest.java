package br.com.quintain.defensiumapi.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import br.com.quintain.defensiumapi.entity.UsuarioEntity;
import jakarta.persistence.EntityManager;

public class UsuarioImplementacaoRepositoryTest {

    @InjectMocks
    private UsuarioImplementacaoRepository repository;

    @Mock
    private EntityManager entityManager;

    @Mock
    private Session session;

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Authentication authentication;

    @Mock
    private Filter filter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        SecurityContextHolder.setContext(securityContext);
        when(securityContext.getAuthentication()).thenReturn(authentication);
    }

    @Test
    public void deveRecuperarTodosUsuariosComSucesso() {
        
        Long sistemaId = 10L;

        Jwt jwt = mock(Jwt.class);
        when(authentication.getPrincipal()).thenReturn(jwt);
        when(jwt.getClaim("sistemaID")).thenReturn(sistemaId);

        when(entityManager.unwrap(Session.class)).thenReturn(session);
        when(session.enableFilter("sistemaFilter")).thenReturn(filter);
        when(filter.setParameter(anyString(), eq(sistemaId))).thenReturn(filter);

        UsuarioEntity usuario = new UsuarioEntity();
        List<UsuarioEntity> usuariosMock = List.of(usuario);
        Query<UsuarioEntity> queryMock = mock(Query.class);
        when(session.createSelectionQuery(anyString(), eq(UsuarioEntity.class))).thenReturn(queryMock);
        when(queryMock.getResultList()).thenReturn(usuariosMock);

        List<UsuarioEntity> resultado = repository.findAll();

        assertEquals(1, resultado.size());
        verify(session).enableFilter("sistemaFilter");
        verify(filter).setParameter("id_sistema", sistemaId);
    }

}
