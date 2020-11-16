package lunatic;

import java.util.Hashtable;

public class ListaProductos {
	Hashtable<Integer, Producto> hashProductos = new Hashtable<Integer, Producto> ();
	
	public void agregar(int llave, Producto producto) {
		hashProductos.put(llave, producto);
	}

}
