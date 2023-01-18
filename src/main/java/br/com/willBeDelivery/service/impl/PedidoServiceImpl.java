package br.com.willBeDelivery.service.impl;

import br.com.willBeDelivery.dto.PedidoDTO;
import br.com.willBeDelivery.model.Endereco;
import br.com.willBeDelivery.model.Pedido;
import br.com.willBeDelivery.repository.EnderecoRepository;
import br.com.willBeDelivery.repository.PedidoRepository;
import br.com.willBeDelivery.service.PedidoService;
import br.com.willBeDelivery.model.StatusEntrega;
import br.com.willBeDelivery.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
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
    public Pedido inserir(PedidoDTO pedidoDTO) {
       return salvarPedido(pedidoDTO);
    }

    @Override
    public Pedido atualizar(long id, StatusEntrega statusEntrega, PedidoDTO pedidoDTO) {
        Pedido pedidoBd = pedidoRepository.findById(id).orElse(null);
        if (pedidoBd == null) {return null;}
        pedidoBd.setDetinatario(pedidoDTO.getDestinatario());
        pedidoBd.setStatusEntrega(statusEntrega);
        pedidoBd.setEnderecoEntrega(getEndereco(pedidoBd.getEnderecoEntrega().getCep()));
        return pedidoRepository.save(pedidoBd);
    }

    @Override
    public Pedido atualizarStatusEntrega(long id, StatusEntrega status) {
        Pedido pedidoBd = pedidoRepository.findById(id).orElse(null);
        if (pedidoBd == null){return null;}

        pedidoBd.setStatusEntrega(status);
        return pedidoRepository.save(pedidoBd);

    }

    @Override
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    private Pedido salvarPedido(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();
        String cep = pedidoDTO.getEnderecoDTO().getCep();
        Endereco endereco = getEndereco(cep);
        pedido.setDetinatario(pedidoDTO.getDestinatario());
        pedido.setEnderecoEntrega(endereco);
        pedido.setStatusEntrega(StatusEntrega.RECEBIDO);
       return pedidoRepository.save(pedido);
    }

    private Endereco getEndereco(String cep) {
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        return endereco;
    }
}
