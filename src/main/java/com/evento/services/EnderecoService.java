package com.evento.services;

import com.evento.dtos.CidadeDTO;
import com.evento.dtos.EnderecoDTO;
import com.evento.exception.BussinesException;
import com.evento.models.Cidade;
import com.evento.models.Endereco;
import com.evento.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.evento.services.CidadeService.MSG_CIDADE;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private CidadeService cidadeService;




    public EnderecoDTO cadastrarEnderec(EnderecoDTO enderecoDTO) {
        Endereco endereco = converterEnderecoDTOParaEndereco(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return converterEnderecoParaEnderecoDTO(endereco);
    }

    private Endereco converterEnderecoDTOParaEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setRua(enderecoDTO.getRua());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setComplemento(enderecoDTO.getComplemento());
        endereco.setCidade(cidadeService.converterCidadeDTOParaCidade(enderecoDTO.getCidade()));
        return endereco;
    }

    public EnderecoDTO converterEnderecoParaEnderecoDTO(Endereco endereco) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setId(endereco.getId());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setRua(endereco.getRua());
        enderecoDTO.setBairro(endereco.getBairro());
        enderecoDTO.setComplemento(endereco.getComplemento());
        enderecoDTO.setCidade(cidadeService.converterCidadeParaCidadeDTO(endereco.getCidade()));
        return enderecoDTO;
    }

    public void deletarEndereco(Long id){enderecoRepository.deleteById(id);

    }
    public EnderecoDTO buscarEnderecoPorId(Long id){
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new BussinesException
                ("Endereco nao encontrado");
        return converterEnderecoParaEnderecoDTO(endereco);
    }


}
