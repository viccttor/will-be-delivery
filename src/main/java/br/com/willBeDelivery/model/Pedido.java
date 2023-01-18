package br.com.willBeDelivery.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String detinatario;
    @Enumerated(EnumType.STRING)
    private StatusEntrega statusEntrega;
    @ManyToOne
    private Endereco enderecoEntrega;
}
