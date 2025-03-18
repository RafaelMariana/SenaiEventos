package com.evento.resources;

import com.evento.dtos.ProdutoraDTO;
import com.evento.services.ProdutoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtoras")
public class ProdutoraResource {

    @Autowired
    private ProdutoraService produtoraService;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoraDTO> buscarProdutoraPorId(@PathVariable Long id){
        return ResponseEntity.ok(produtoraService.buscarProdutoraDTOPorId(id));

    }

    @PostMapping()
    public ResponseEntity<ProdutoraDTO> cadastrarProdutora(@RequestBody ProdutoraDTO produtoraDTO){
        ProdutoraDTO produtora = produtoraService.cadastrarProdutora(produtoraDTO);
        return ResponseEntity.ok(produtora);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarProdutora(@RequestBody ProdutoraDTO produtoraDTO){
        produtoraService.deletarProdutora(produtoraDTO.getId());
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<ProdutoraDTO> atualizarProdutora(@RequestBody ProdutoraDTO produtoraDTO){
        return ResponseEntity.ok(produtoraService.atualizarProdutora(produtoraDTO));
    }

    @GetMapping("/buscar")
    public ResponseEntity<ProdutoraDTO> buscarProdutoraPorNome(@RequestParam String nome){
        return ResponseEntity.ok(produtoraService.buscarProdutoraPorNome(nome));
    }
}
