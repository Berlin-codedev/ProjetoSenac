package Senac.projeto.entity;

import Senac.projeto.entity.Alocacao;
import Senac.projeto.entity.Cliente;
import Senac.projeto.entity.Compra;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrabalho;

    @Column(nullable = false)
    private String trabalho;

    @Column(nullable = false, length = 200)
    private String tipoTrabalho;

    @Column(nullable = false)
    private OffsetDateTime dataEntrega;

    @CreationTimestamp
    @Column(name = "data_inicio", nullable = false, updatable = false)
    private OffsetDateTime inicioTrabalho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Builder.Default
    @OneToMany(mappedBy = "trabalho", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Compra> compras = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "trabalho", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alocacao> alocacaos = new ArrayList<>();
}