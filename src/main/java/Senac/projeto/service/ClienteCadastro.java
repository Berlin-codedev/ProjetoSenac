package Senac.projeto.service;

import Senac.projeto.dto.ClienteDto;
import Senac.projeto.entity.Cliente;
import Senac.projeto.exception.CpfDuplicadoException;
import Senac.projeto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteCadastro {
@Autowired
    private ClienteRepository clienteRepository;
public void cadastrarCliente(ClienteDto dados){
    boolean cpfJaExiste = clienteRepository.existsByCpf(dados.cpf());
    if (cpfJaExiste){
        throw new CpfDuplicadoException("Erro: este cpf esta cpadastrado");
    }
    Cliente novoCliente = new Cliente();
    novoCliente.setNomeCliente(dados.nomeCliente());
    novoCliente.setEmail(dados.email());
    novoCliente.setCpf(dados.cpf());
    novoCliente.setTelefone(dados.telefone());
    clienteRepository.save(novoCliente);

}
}
