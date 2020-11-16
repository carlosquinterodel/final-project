package lunatic;

import java.util.PriorityQueue;
import java.util.Queue;

/*PRIORIDADES
 * 2->Cliente referido(Prioridad alta)
 * 1->Cliente general (Prioridad baja)
 * */
public class Pedidos {
	
	//Cola en la que se almacenan los pedidos entrantes
	Queue<Cliente>colaPedidos = new PriorityQueue<Cliente>();
	
	//Metodo para añadir un cliente a la cola de pedido
	public void agregar(Cliente cliente) {
		colaPedidos.add(cliente);
	}
	
	//Metodo que realiza la sumatoria de los saldos de todos los clientes
	public void totalPedidos() {
		float total = 0;
		for(Cliente cliente : colaPedidos) {
			total = total + cliente.saldo;
		}
		System.out.println("El valor total de pedidos es de $"+total);
	}
	
	//Metodo que realiza el promedio de los saldos de clientes
	public void promedioPedidos() {
		float total = 0;
		int cont = 0;
		for(Cliente cliente : colaPedidos) {
			cont++;
			total = total + cliente.saldo;
		}
		float promedio = total/cont;
		System.out.println("El promedio de pedidos es de $"+promedio);
	}
	
	//Metodo que imprime todos los pedidos con datos del cliente y 
	//referencias de los productos pedidos
	public void ver() {
		for(Cliente cliente : colaPedidos) {
			System.out.println("<PEDIDO> cel: "+cliente.telefono+" - "+cliente.nombre+" $"+cliente.saldo);
			//Imprime las referencias de los articulos pedidos por cliente
			for(Producto producto : cliente.productos) {
				System.out.println(" *"+producto.referencia);
			}
		}
	}
	
}
