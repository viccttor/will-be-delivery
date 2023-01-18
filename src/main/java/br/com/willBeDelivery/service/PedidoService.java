package br.com.willBeDelivery.service;


import br.com.willBeDelivery.model.Pedido;

public interface PedidoService {

    Iterable<Pedido> buscarTodos();
    Pedido buscarPorId(long id);
    void inserir(Pedido pedido);
    void atualizar(long id, Pedido pedido);
    void deletar(Long id);
}
