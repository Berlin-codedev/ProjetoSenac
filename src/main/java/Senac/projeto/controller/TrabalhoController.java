package Senac.projeto.controller;

import Senac.projeto.dto.TrabalhoDto;
import Senac.projeto.service.TrabalhoCadastro;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trabalho")
@RequiredArgsConstructor
public class TrabalhoController {
    private final TrabalhoCadastro trabalhoCadastro;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@Valid @RequestBody TrabalhoDto dados){
        trabalhoCadastro.cadastrarTrabalho(dados);
    }
}
