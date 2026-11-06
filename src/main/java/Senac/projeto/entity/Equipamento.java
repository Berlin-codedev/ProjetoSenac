package Senac.projeto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamento;
    @Column(nullable = false, length = 300)
    private String nomeEquipamento;
    @Column(nullable = false)
    private int quantidadeEquipamento;
    @Builder.Default
    @OneToMany(mappedBy = "equipamento", fetch = FetchType.LAZY)
    private List<Alocacao> alocacaos = new ArrayList<>();
    @Builder.Default
    @ManyToMany(mappedBy = "equipamentos", fetch = FetchType.LAZY)
    private List<Trabalho> trabalhos = new ArrayList<>();
}
