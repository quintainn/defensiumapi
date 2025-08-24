package br.com.quintain.defensiumapi.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.quintain.defensiumapi.transfer.ExceptionTransfer;

@ControllerAdvice
public class DefeniumException {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionTransfer> dataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
        ExceptionTransfer exceptionTransfer = new ExceptionTransfer();
        String mensagemErro = dataIntegrityViolationException.getMostSpecificCause().getMessage();
        if (mensagemErro != null && mensagemErro.toLowerCase().contains("duplicate")) {
            exceptionTransfer.setMensagemSistema("Registro duplicado!");
            exceptionTransfer.setSituacao(409);
        } else {
            exceptionTransfer.setMensagemSistema("Ocorreu uma violação de integridade!");
            exceptionTransfer.setSituacao(400);
        }
        exceptionTransfer.setErro(dataIntegrityViolationException.getMostSpecificCause().getMessage());
        exceptionTransfer.setSituacao(400);
        exceptionTransfer.setDataHoraRequisicao(java.time.LocalDateTime.now().toString());
        return ResponseEntity.badRequest().body(exceptionTransfer);
    }

}
