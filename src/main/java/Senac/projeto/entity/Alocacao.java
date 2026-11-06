package Senac.projeto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alocacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlocacao;
    @Column(nullable = false)
    private LocalDate entrada;
    @Column(nullable = false)
    private LocalDate vencimento;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal valorDiaria;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trabalho", nullable = false)
    private Trabalho trabalho;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipamento", nullable = false)
    private Equipamento equipamento;
}
