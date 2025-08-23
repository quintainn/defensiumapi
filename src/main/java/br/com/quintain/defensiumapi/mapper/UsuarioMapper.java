package br.com.quintain.defensiumapi.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.quintain.defensiumapi.entity.UsuarioEntity;
import br.com.quintain.defensiumapi.transfer.UsuarioTransfer;

public class UsuarioMapper {

    private PasswordEncoder passwordEncoder;

    public UsuarioMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioEntity toEntity(UsuarioTransfer usuarioTransfer) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
            usuarioEntity.setNome(usuarioTransfer.getNome());
            usuarioEntity.setUsuario(usuarioTransfer.getUsuario());
            usuarioEntity.setSenha(passwordEncoder.encode(usuarioTransfer.getSenha()).toString());
        return usuarioEntity;
    }

    public static UsuarioTransfer toTransfer(UsuarioEntity usuarioEntity) {
        UsuarioTransfer usuarioTransfer = new UsuarioTransfer();
            usuarioTransfer.setCodePublic(usuarioEntity.getCodePublic().toString());
            usuarioTransfer.setNome(usuarioEntity.getNome());
            usuarioTransfer.setUsuario(usuarioEntity.getUsuario());
            usuarioTransfer.setSenha(usuarioEntity.getSenha());
            usuarioTransfer.setDataCriacao(String.valueOf(usuarioEntity.getDataCriacao()));
            usuarioTransfer.setDataEdicao(String.valueOf(usuarioEntity.getDataEdicao()));
            usuarioTransfer.setDataDelecao(String.valueOf(usuarioEntity.getDataDelecao()));
            usuarioTransfer.setActive(String.valueOf(usuarioEntity.getActive()));
        return usuarioTransfer;
    }

}
