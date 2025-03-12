package com.evento.services;

import com.evento.dtos.UsuarioDTO;
import com.evento.exception.BussinesException;
import com.evento.models.Usuario;
import com.evento.repositories.UsuarioRepository;
import com.evento.specs.UsuarioSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class UsuarioService {
    private static final String MSG_ID= "Usuário já cadastrado com email: %s.";
    private static final String MSG_USUARIO = "Usuário não encontrado";

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioSpec usuarioSpec;

    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO){

        Usuario emailExistente = usuarioRepository.findByEmail(usuarioDTO.getEmail());
        usuarioSpec.verificarSeExisteUsuarioComEmailDuplicado(emailExistente);

        Usuario cpfExistente = usuarioRepository.findByCpf(usuarioDTO.getCpf());
        usuarioSpec.verificarSeExisteUsuarioComCpfDuplicado(cpfExistente);

        Usuario usuario = converterUsuarioDTOParaUsuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return converterUsuarioParaUsuarioDTO(usuario);
    }

    public UsuarioDTO converterUsuarioParaUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setSenha(usuario.getSenha());
        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setDataNascimento(usuario.getDataNascimento());
        usuarioDTO.setPerfil(usuario.getPerfis());
        usuarioDTO.setVerificado(usuario.isVerificado());
        return usuarioDTO;
    }

    public Usuario converterUsuarioDTOParaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        usuario.setPerfis(usuarioDTO.getPerfis());
        usuario.setVerificado(usuarioDTO.isVerificado());
        return usuario;

    }

    public UsuarioDTO deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
        return converterUsuarioParaUsuarioDTO(usuario);
    }

    public UsuarioDTO buscarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new BussinesException(MSG_ID));
        return converterUsuarioParaUsuarioDTO(usuario);

    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {


        usuarioSpec.verificarCampoIdNulo(usuarioDTO.getId());


        Usuario usuario = usuarioRepository.findById(usuarioDTO.getId()).orElseThrow(() -> new
                IllegalArgumentException(MSG_USUARIO));


        if((!(usuario.getEmail().equals(usuarioDTO.getEmail())))
                &&(nonNull(usuarioRepository.findByEmail(usuarioDTO.getEmail())))){
            throw new BussinesException(String.format("Usuário já cadstrado com email: %s.", usuarioDTO.getEmail()));

        }

        if ((!(usuario.getCpf().equals(usuarioDTO.getCpf())))
                &&(nonNull(usuarioRepository.findByCpf(usuarioDTO.getCpf())))) {
            throw new BussinesException(String.format("Usuário já cadstrado com CPF: %s.", usuarioDTO.getCpf()));
        }

        usuario = converterUsuarioDTOParaUsuario(usuarioDTO);
        usuarioRepository.save(usuario);
        return converterUsuarioParaUsuarioDTO(usuario);
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return converterUsuarioParaUsuarioDTO(usuario);
    }

}
