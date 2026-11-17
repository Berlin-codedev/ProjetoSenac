package Senac.projeto.service;

import Senac.projeto.dto.ClienteDto;
import Senac.projeto.entity.Cliente;
import Senac.projeto.exception.ClienteNaoEncontradoException;
import Senac.projeto.exception.CpfDuplicadoException;
import Senac.projeto.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClienteAtualizacao {
    private final ClienteRepository clienteRepository;
    @Transactional
    public void atualizarCliente(Long id, ClienteDto dados){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado!"));
                if (clienteRepository.existsByCpfAndIdClienteNot(dados.cpf(), id)){
                    throw new CpfDuplicadoException("Erro: este CPF ja esta cadastrado!");
                }
                cliente.setNomeCliente(dados.nomeCliente());
                cliente.setEmail(dados.email());
                cliente.setCpf(dados.cpf());
                cliente.setTelefone(dados.telefone());
    }
}
