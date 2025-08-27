package br.com.quintain.defensiumapi.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.quintain.defensiumapi.transfer.ExceptionTransfer;
import br.com.quintain.defensiumapi.utility.DataHoraUtility;

@ControllerAdvice
public class DefeniumException {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionTransfer> dataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
        ExceptionTransfer exceptionTransfer = new ExceptionTransfer();
        String mensagemErro = dataIntegrityViolationException.getMostSpecificCause().getMessage();
        if (mensagemErro != null && mensagemErro.toLowerCase().contains("duplicate")) {
            exceptionTransfer.setMensagemSistema("Registro duplicado!");
            exceptionTransfer.setSituacao("409");
        } else {
            exceptionTransfer.setMensagemSistema("Ocorreu uma violação de integridade!");
            exceptionTransfer.setSituacao("400");
        }
        exceptionTransfer.setSituacao(HttpStatus.BAD_REQUEST.toString());
        exceptionTransfer.setDataHoraRequisicao(DataHoraUtility.obterDataHoraAtualFormatada());
        return ResponseEntity.badRequest().body(exceptionTransfer);
    }

}
