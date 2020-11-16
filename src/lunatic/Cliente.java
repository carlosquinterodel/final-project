package lunatic;

import java.util.ArrayList;

public class Cliente implements Comparable<Cliente>{
	
	String telefono;
	String nombre;
	float saldo;
	int prioridad;
	ArrayList<Producto> productos = new ArrayList<Producto>();
	
	
	
	public Cliente(String telefono, String nombre, int prioridad) {
		this.telefono = telefono;
		this.nombre = nombre;
		this.prioridad = prioridad;
	}

	
	//Metodo que obtiene el valor total de la listade productos de cada cliente
	public void saldo() {
		float total = 0;
		for(Producto producto : productos) {
			total = total + producto.valor;
		}
		
		this.saldo = total;
	}
	
	
	//Metodo por defecto que realiza el proceso de prioridad
	@Override
	public int compareTo(Cliente otroCliente) {
		// TODO Auto-generated method stub
		return otroCliente.prioridad - this.prioridad;
	}

}
