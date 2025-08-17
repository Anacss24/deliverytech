package com.deliverytech.delivery_api.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import lombok.Data;

// Transforma a classe em uma tabela
@Entity
@Data
public class Cliente {
    @Id
    // Indica que o ID será gerado automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private boolean ativo;
    
    // 1 para Muitos
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}
