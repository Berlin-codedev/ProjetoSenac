package Senac.projeto.controller;

import Senac.projeto.dto.ClienteDto;
import Senac.projeto.service.ClienteCadastro;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteCadastro clienteCadastro;
    public ClienteController(ClienteCadastro clienteCadastro){
        this.clienteCadastro = clienteCadastro;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@Valid @RequestBody ClienteDto dados){
        clienteCadastro.cadastrarCliente(dados);
    }
}
