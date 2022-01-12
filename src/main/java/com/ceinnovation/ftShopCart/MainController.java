package com.ceinnovation.ftShopCart;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import Models.PedidoFinalizado;
import Models.Produto;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;




@RestController
public class MainController {
/**
{
	itens comprados: [],
	valor total: 100
}
*/
@RequestMapping(
	    value = "/processcart", 
	    method = RequestMethod.POST,
	    consumes = "application/json")
public String process(@RequestBody String payload) throws Exception {

	  //Pega o JSON e interpreta como lista de objetos
	  Gson g = new Gson();
	  Type listType = new TypeToken<ArrayList<Produto>>(){}.getType();
	  List<Produto> produtos = g.fromJson(payload, listType);
	  
	  
	  //Cria um novo objeto de pedido finalizado e popula com os produtos
	  PedidoFinalizado pedidoFinalizado = new PedidoFinalizado();
	  pedidoFinalizado.setItemsComprados(produtos);
	  double totalcarrinho = 0.0;
	  
	  //Soma todos os precos para valor total do carrinho
	  for(int i = 0; i<produtos.size();i++) {
		  totalcarrinho += produtos.get(i).getPreco();
	  }
	  
	  //Seta valor total do carrinho
	  pedidoFinalizado.setValortotal(totalcarrinho);
	  
	  //Retorna como JSON String
	  Type listTypeFinal = new TypeToken<ArrayList<PedidoFinalizado>>(){}.getType();
	  
	  
	  String jsonstr = g.toJson(pedidoFinalizado).toString();
	  
	  return jsonstr;

}

	
}
