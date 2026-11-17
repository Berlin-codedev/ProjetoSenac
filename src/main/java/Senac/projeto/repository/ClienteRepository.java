package Senac.projeto.repository;

import Senac.projeto.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByCpfAndIdClienteNot(String cpf, Long idCliente);
}
