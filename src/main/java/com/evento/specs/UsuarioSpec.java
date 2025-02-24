package com.evento.specs;

import com.evento.exception.BussinesException;
import com.evento.models.Usuario;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class UsuarioSpec {

        private static final String MSG_EMAIL = "Usuário já cadastrado com email: %s.";

        public void verificarSeExisteUsuarioComEmailDuplicado(Usuario usuario){

            if(nonNull(usuario)){
                throw new BussinesException(
                        String.format(MSG_EMAIL,usuario.getEmail()));
            }

        }
    private static final String MSG_CPF = "Usuário já cadastrado com cpf: %s.";

    public void verificarSeExisteUsuarioComCpfDuplicado(Usuario usuario){

        if(nonNull(usuario)){
            throw new BussinesException(
                    String.format(MSG_CPF,usuario.getCpf()));
        }

    }

}