package com.evento.services;

import com.evento.dtos.ProdutoraDTO;
import com.evento.exception.BussinesException;
import com.evento.models.Produtora;
import com.evento.repositories.ProdutoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoraService {
    @Autowired
    private ProdutoraRepository produtoraRepository;

    public ProdutoraDTO cadastrarProdutora(ProdutoraDTO produtoraDTO) {
        Produtora produtora = converterProdutoraDTOParaProdutora(produtoraDTO);
        produtora = produtoraRepository.save(produtora);
        return converterProdutoraParaProdutoraDTO(produtora);
    }

    public Produtora converterProdutoraDTOParaProdutora(ProdutoraDTO produtoraDTO) {
        Produtora produtora = new Produtora();
        produtora.setId(produtoraDTO.getId());
        produtora.setNome(produtoraDTO.getNome());
        produtora.setCpfCnpj(produtoraDTO.getCpfCnpj());
        return produtora;
    }

    public ProdutoraDTO converterProdutoraParaProdutoraDTO(Produtora produtora) {
        ProdutoraDTO produtoraDTO = new ProdutoraDTO();
        produtoraDTO.setId(produtora.getId());
        produtoraDTO.setNome(produtora.getNome());
        produtoraDTO.setCpfCnpj(produtora.getCpfCnpj());
        return produtoraDTO;
    }

    public void deletarProdutora(Long id){produtoraRepository.deleteById(id);
    }

    public ProdutoraDTO buscarProdutoraDTOPorId(Long id){
        Produtora produtora = buscarProdutoraPorId(id);
        return converterProdutoraParaProdutoraDTO(produtora);
    }

    public Produtora buscarProdutoraPorId(Long id){
        Produtora produtora = produtoraRepository.findById(id).orElseThrow(()
                -> new BussinesException("Não encontrado"));
        return produtora;
    }
    public ProdutoraDTO atualizarProdutora(ProdutoraDTO produtoraDTO){
        produtoraRepository.findById(produtoraDTO.getId()).orElseThrow(()
                -> new BussinesException("Produtora não encontrada"));
        Produtora produtora = converterProdutoraDTOParaProdutora(produtoraDTO);
        produtoraRepository.save(produtora);
        return converterProdutoraParaProdutoraDTO(produtora);
    }

    public ProdutoraDTO buscarProdutoraPorNome(String nome) {
        Produtora produtora = produtoraRepository.findByNome(nome).orElseThrow(()
                -> new BussinesException("Produtora não encontrada"));
        return converterProdutoraParaProdutoraDTO(produtora);
    }
}
