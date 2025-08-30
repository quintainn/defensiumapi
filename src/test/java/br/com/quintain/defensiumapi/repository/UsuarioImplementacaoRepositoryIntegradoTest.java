package br.com.quintain.defensiumapi.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import br.com.quintain.defensiumapi.entity.SistemaEntity;
import br.com.quintain.defensiumapi.entity.UsuarioEntity;

@ActiveProfiles("teste")
@Import(UsuarioImplementacaoRepository.class)
@SpringBootTest
@Transactional
public class UsuarioImplementacaoRepositoryIntegradoTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioImplementacaoRepository usuarioImplementacaoRepository;

    @Autowired
    private SistemaRepository sistemaRepository;

    @BeforeEach
    void setupSecurityContext() {

        Jwt jwt = mock(Jwt.class);
        when(jwt.getClaim("sistemaID")).thenReturn(1L);

        Authentication auth = mock(Authentication.class);
        when(auth.getPrincipal()).thenReturn(jwt);

        SecurityContext context = mock(SecurityContext.class);
        when(context.getAuthentication()).thenReturn(auth);

        SecurityContextHolder.setContext(context);
    }

//    @Test
    @WithMockUser(username = "teste", roles = { "USER" })
    public void deveRecuperarUsuariosSegregadosPorSistema() {
    	
    	List<SistemaEntity> sistemaEntityList = this.sistemaRepository.findAll();

        SistemaEntity sistema1 = sistemaRepository.findById(1L).orElseThrow();

        UsuarioEntity usuario1 = new UsuarioEntity();
        usuario1.setNome("Usuário 1");
        usuario1.setUsuario("usuario_1");
        usuario1.setSenha("senha_1");
        usuario1.setSistemaEntity(sistema1);

        UsuarioEntity usuario2 = new UsuarioEntity();
        usuario2.setNome("Usuário 2");
        usuario2.setUsuario("usuario_2");
        usuario2.setSenha("senha_2");

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        List<UsuarioEntity> resultado = usuarioImplementacaoRepository.findAll();

        assertEquals(1, resultado.size());
        assertEquals("Usuário 1", resultado.get(0).getNome());
    }

    @Test
    public void deveRecuperarTodosUsuariosSegregacaoSistemaComSucesso() {
    }

}
