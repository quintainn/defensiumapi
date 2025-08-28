package br.com.quintain.defensiumapi.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.quintain.defensiumapi.entity.SistemaEntity;
import br.com.quintain.defensiumapi.entity.UsuarioEntity;
import br.com.quintain.defensiumapi.repository.SistemaRepository;
import br.com.quintain.defensiumapi.transfer.UsuarioRequestTransfer;
import br.com.quintain.defensiumapi.transfer.UsuarioResponseTransfer;

@Component
public class UsuarioMapper {

    private final PasswordEncoder passwordEncoder;

    private final SistemaRepository sistemaRepository;

    public UsuarioMapper(PasswordEncoder passwordEncoder, SistemaRepository sistemaRepository) {
        this.passwordEncoder = passwordEncoder;
        this.sistemaRepository = sistemaRepository;
    }

    public UsuarioEntity toEntity(UsuarioRequestTransfer usuarioTransfer) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
            usuarioEntity.setNome(usuarioTransfer.getNome());
            usuarioEntity.setUsuario(usuarioTransfer.getUsuario());
            usuarioEntity.setSenha(passwordEncoder.encode(usuarioTransfer.getSenha()).toString());
            usuarioEntity.setSistemaEntity(usuarioTransfer.getSistemaEntity());
        return usuarioEntity;
    }

    public UsuarioRequestTransfer toTransfer(UsuarioEntity usuarioEntity) {
        UsuarioRequestTransfer usuarioTransfer = new UsuarioRequestTransfer();
            usuarioTransfer.setNome(usuarioEntity.getNome());
            usuarioTransfer.setUsuario(usuarioEntity.getUsuario());
            usuarioTransfer.setSenha(usuarioEntity.getSenha());
        return usuarioTransfer;
    }

    public UsuarioResponseTransfer toTransferResponse(UsuarioEntity usuarioEntity) {
        UsuarioResponseTransfer usuarioResponseTransfer = new UsuarioResponseTransfer();
            usuarioResponseTransfer.setCodePublic(String.valueOf(usuarioEntity.getCodePublic()));
            usuarioResponseTransfer.setNome(usuarioEntity.getNome());
            usuarioResponseTransfer.setUsuario(usuarioEntity.getUsuario());
            usuarioResponseTransfer.setDataCriacao(usuarioEntity.getDataCriacao().toString());
            usuarioResponseTransfer.setActive(String.valueOf(usuarioEntity.getActive()));
            usuarioResponseTransfer.setSistema(getSistemaEntity(usuarioEntity.getSistemaEntity().getCode()));
        return usuarioResponseTransfer;
    }

    private String getSistemaEntity(Long sistemaID) {
        return this.sistemaRepository.findById(sistemaID)
            .map(SistemaEntity::getNome).orElse("Sistema não pode ser encontrado!");
    }

}
