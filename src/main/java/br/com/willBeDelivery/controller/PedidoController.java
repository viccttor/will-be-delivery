package br.com.willBeDelivery.controller;


import br.com.willBeDelivery.dto.PedidoDTO;
import br.com.willBeDelivery.model.Pedido;
import br.com.willBeDelivery.service.PedidoService;
import br.com.willBeDelivery.model.StatusEntrega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/buscarTodosPedidos")
    public ResponseEntity<Iterable<Pedido>> buscarTodos() {
        return ResponseEntity.ok(pedidoService.buscarTodos());
    }

    @GetMapping("/buscarPedido")
    public ResponseEntity<Pedido> buscarPorId(@RequestParam Long id) {
        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    @PostMapping("/inserirPedido")
    public ResponseEntity<Pedido> inserir(@RequestBody PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(pedidoService.inserir(pedidoDTO));
    }

    @PutMapping("/atualizarPedido")
    public ResponseEntity<Pedido> atualizar(@RequestParam Long id, @RequestParam StatusEntrega statusEntrega, @RequestBody PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(pedidoService.atualizar(id, statusEntrega, pedidoDTO));
    }

    @PatchMapping("/atualizarStatusEntrega")
    public ResponseEntity<Pedido> atualizarStatusEntrega(@RequestParam Long id, @RequestParam StatusEntrega status){
        return ResponseEntity.ok(pedidoService.atualizarStatusEntrega(id, status));
    }

    @DeleteMapping("/deletarPedido")
    public ResponseEntity<Void> deletar(@RequestParam Long id) {
        pedidoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
