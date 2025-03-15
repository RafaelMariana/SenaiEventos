package com.evento.resources;

import com.evento.dtos.EnderecoDTO;
import com.evento.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarEnderecoPorId(@PathVariable Long id){
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorId(id));

    }

    @PostMapping()
    public ResponseEntity<EnderecoDTO> cadastrarEndereco(@RequestBody EnderecoDTO EnderecoDTO){
        EnderecoDTO Endereco = enderecoService.cadastrarEndereco(EnderecoDTO);
        return ResponseEntity.ok(Endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@RequestBody EnderecoDTO EnderecoDTO){
        enderecoService.deletarEndereco(EnderecoDTO.getId());
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<EnderecoDTO> atualizarEndereco(@RequestBody EnderecoDTO EnderecoDTO){
        return ResponseEntity.ok(enderecoService.atualizarEndereco(EnderecoDTO));
    }

    @GetMapping("/buscar")
    public ResponseEntity<EnderecoDTO> buscarEnderecoPorNome(@RequestParam String cep){
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorCep(cep));
    }
}
