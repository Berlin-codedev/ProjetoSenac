package Senac.projeto.service;

import Senac.projeto.dto.TrabalhoDto;
import Senac.projeto.entity.Cliente;
import Senac.projeto.entity.Trabalho;
import Senac.projeto.exception.ClienteNaoEncontradoException;
import Senac.projeto.repository.ClienteRepository;
import Senac.projeto.repository.TrabalhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrabalhoCadastro {
    private final TrabalhoRepository trabalhoRepository;
    private final ClienteRepository clienteRepository;
    public void cadastrarTrabalho(TrabalhoDto dados){
        Cliente cliente = clienteRepository.findById(dados.clienteId())
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado."));
        Trabalho trabalho = new Trabalho();
        trabalho.setTrabalho(dados.trabalho());
        trabalho.setTipoTrabalho(dados.tipoTrabalho());
        trabalho.setDataEntrega(dados.dataEntrega());
        trabalho.setCliente(cliente);
        trabalhoRepository.save(trabalho);
    }
}
