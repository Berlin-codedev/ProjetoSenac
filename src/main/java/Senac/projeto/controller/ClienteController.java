package Senac.projeto.controller;

import Senac.projeto.dto.ClienteDto;
import Senac.projeto.service.ClienteAtualizacao;
import Senac.projeto.service.ClienteCadastro;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteCadastro clienteCadastro;
    private final ClienteAtualizacao clienteAtualizacao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@Valid @RequestBody ClienteDto dados) {
        clienteCadastro.cadastrarCliente(dados);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @Valid @RequestBody ClienteDto dados) {
        clienteAtualizacao.atualizarCliente(id, dados);
    }
}