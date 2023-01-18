package br.com.willBeDelivery.service;

import br.com.willBeDelivery.model.Endereco;
import br.com.willBeDelivery.model.Pedido;
import br.com.willBeDelivery.repository.EnderecoRepository;
import br.com.willBeDelivery.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido buscarPorId(long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.get();
    }

    @Override
    public void inserir(Pedido pedido) {
        salvarPedido(pedido);
    }

    @Override
    public void atualizar(long id, Pedido pedido) {
        Optional<Pedido> pedidoBd = pedidoRepository.findById(id);
        if (pedidoBd.isPresent()){
            salvarPedido(pedido);
        }
    }

    @Override
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    private void salvarPedido(Pedido pedido){
        String cep = pedido.getEnderecoEntrega().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        pedido.setEnderecoEntrega(endereco);
        pedidoRepository.save(pedido);
    }
}
