package Senac.projeto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;
    @Column(length = 500)
    private String descricaoCompra;
    @Column(nullable = false)
    private int quantidadeCompra;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal valorCompra;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trabalho", nullable = false)
    private Trabalho trabalho;
    @Builder.Default
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedido> pedidos = new ArrayList<>();
}
