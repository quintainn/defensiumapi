package br.com.quintain.defensiumapi.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.quintain.defensiumapi.entity.UsuarioEntity;
import br.com.quintain.defensiumapi.transfer.UsuarioRequestTransfer;
import br.com.quintain.defensiumapi.transfer.UsuarioResponseTransfer;

public class UsuarioMapper {

    private PasswordEncoder passwordEncoder;

    public UsuarioMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioEntity toEntity(UsuarioRequestTransfer usuarioTransfer) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
            usuarioEntity.setNome(usuarioTransfer.getNome());
            usuarioEntity.setUsuario(usuarioTransfer.getUsuario());
            usuarioEntity.setSenha(passwordEncoder.encode(usuarioTransfer.getSenha()).toString());
        return usuarioEntity;
    }

    public static UsuarioRequestTransfer toTransfer(UsuarioEntity usuarioEntity) {
        UsuarioRequestTransfer usuarioTransfer = new UsuarioRequestTransfer();
            usuarioTransfer.setNome(usuarioEntity.getNome());
            usuarioTransfer.setUsuario(usuarioEntity.getUsuario());
            usuarioTransfer.setSenha(usuarioEntity.getSenha());
        return usuarioTransfer;
    }

    public static UsuarioResponseTransfer toTransferResponse(UsuarioEntity usuarioEntity) {
        UsuarioResponseTransfer usuarioResponseTransfer = new UsuarioResponseTransfer();
            usuarioResponseTransfer.setCodePublic(String.valueOf(usuarioEntity.getCodePublic()));
            usuarioResponseTransfer.setNome(usuarioEntity.getNome());
            usuarioResponseTransfer.setUsuario(usuarioEntity.getUsuario());
            usuarioResponseTransfer.setDataCriacao(usuarioEntity.getDataCriacao().toString());
            usuarioResponseTransfer.setActive(String.valueOf(usuarioEntity.getActive()));
        return usuarioResponseTransfer;
    }

}
