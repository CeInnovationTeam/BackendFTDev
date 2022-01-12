package Models;

import java.util.List;

public class PedidoFinalizado {
	private List<Produto> itemsComprados;
	private double valortotal;
	
	public List<Produto> getItemsComprados() {
		return itemsComprados;
	}
	public void setItemsComprados(List<Produto> itemsComprados) {
		this.itemsComprados = itemsComprados;
	}
	public double getValortotal() {
		return valortotal;
	}
	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

}
