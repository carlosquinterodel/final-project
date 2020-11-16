package lunatic;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Pedidos colaPedidos = new Pedidos(); //Inicializa cola de pedidos
		ListaProductos listaProductos = new ListaProductos(); //Inicializa lista de produtos
		BufferedReader bf;
		
		//SE LLENA LA LISTA DE PRODUCTOS
		bf = new BufferedReader(new FileReader("productos.txt"));
		int cantProductos = Integer.parseInt(bf.readLine());
		String[] datos;
		for (int i = 0; i < cantProductos; i++) {
			datos = bf.readLine().split(",");
			//Se obtiene la llave o valor unico de cada producto
			int llave = Integer.parseInt(datos[0]);
			//Se obtienen la referencia y valor para crear el producto
			String referencia = datos[1];
			float valor = Float.parseFloat(datos[2]);
			//Crea el producto
			Producto producto = new Producto(referencia, valor);
			//se agrega el producto y su llave a la lista de productos
			listaProductos.agregar(llave, producto);
		}
		
		//SE LLENA LISTA DE PEDIDOS
		bf = new BufferedReader(new FileReader("datos.txt"));
		int cantPedidos = Integer.parseInt(bf.readLine());
		String[] datos2;

		for (int i = 0; i < cantPedidos; i++) {

			// Guarda en un array los datos de una linea donde cada posicion es el texto
			// antes de ','
			datos2 = bf.readLine().split(",");

			// Obtiene la cantidad de articulos de un cliente
			int cantArticulos = Integer.parseInt(datos2[3]);


			// Se almacena nombre y telefono de la linea
			String telefono = datos2[0];
			String nombre = datos2[1];
			int prioridad = Integer.parseInt(datos2[2]);
			//Se crea el cliente con los datos basicos
			Cliente cliente = new Cliente(telefono, nombre, prioridad);

				// Se avanza las siguientes lineas que son los articulos que seleccion el cliente y se almacenan en el vector
				for (int j = 0; j < cantArticulos; j++) {
					//Se almacena la linea en un array para acceder a cada atributo del producto
					datos2 = bf.readLine().split(",");
					//Se la llave o valor unico del producto 
					int llaveProducto = Integer.parseInt(datos2[0]);
					//Se busca con la llave del producto en la lista y se guarda
					Producto producto = listaProductos.hashProductos.get(llaveProducto);
					//Agrega el producto a la lista de productos del cliente
					cliente.productos.add(producto);

				}
				//Despues de agregar todos los productos de un cliente llama a la funcion que calcula el saldo
				cliente.saldo();
				//Se agrega el cliente a la lista de pedidos
				colaPedidos.agregar(cliente);

			// --------------------------------------------------

		}//Termina de leer y guardar los datos de los archivos
		
		//Llama al metodo que visualiza todos los pedidos registrados
		colaPedidos.ver();
		
		System.out.println();//Linea en blanco
		
		//llama al metodo que calcula el valor total de todos los pedidos
		colaPedidos.totalPedidos();
		
		System.out.println();//Linea en blanco
		
		//Llama al metodo que calcula el promedio de pedidos
		colaPedidos.promedioPedidos();
		
		System.out.println();//Linea en blanco
		
		//Imprime numero de pedidos
		int numPedidos = colaPedidos.colaPedidos.size();
		System.out.println("Se han registrado "+numPedidos+" en el sistema");

	}

}
