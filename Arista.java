/**
 * Universidad Simon Bolıivar
 * Departamento de Computacion y Tecnologia de la Informacion
 * Laboratorio de Algoritmos y Estructuras III
 * Trimestre Septiembre-Diciembre 2017
 * 
 * Elemento arista, parte de la implementacion del TAD Grafo
 * 
 * Arista.java
 * 
 * Representacion del tipo de dato abstracto (TAD) correspondiente a una Arista de 
 * un TAD GrafoNoDirigido.
 * 
 * @Autores: Javier Vivas 12-11067, Daniel Francis 12-10863
 *
 * @Ultima_modificacion: 14.11.2017
 */

import java.io.IOException ;
import java.io.FileReader ;
import java.io.BufferedReader ;
import java.io.FileNotFoundException ;
import java.util.NoSuchElementException ;
import java.util.ArrayList ;
import java.util.List ;

/**
 * Clase Arista, se extiende de la clase Lado
 * 
 * @param u: Uno de los vertices de la arista.
 * @param v: El otro de los vertices de la arista.
 * @param id: String que identifica a la arista.
 * @param peso: double que representa el peso de la arista.
 */

public class Arista extends Lado
{
  public Vertice u;
  public Vertice v;
  public String idArista;
  public double pesoArista;

/**
 * Metodo constructor de Arista
 *
 * Crea una nueva Arista con un identificador id, peso p, y vertices de partida y llegada.
 * 
 * @param id: String que identifica al arco.
 * @param peso: double que representa el peso del arco.
 * @param u: Objeto tipo Vertice de salida/llegada del arista.
 * @param v: Opjeto tipo Vertice de llegada/salida del arco.
 *
 * Precondicion: 'id' es String, 'peso' es double, u y v son Vertice.
 * Postcondicion: La instanciacion de la clase es una Arista con id 'id', peso 'peso', y Vertice
 *                de partida u y de llegada v.
 * Orden: O(1)
 */
  
  public Arista(String id, double peso, Vertice u, Vertice v) {
    super(id,peso);
    this.idArista = id;
    this.pesoArista = peso;
    this.u = u;
    this.v = v;
  }

/**
 * Metodo getExtremo1
 * 
 * Retorna uno de los Vertices de la Arista instanciada.
 *
 * @return: Vertice que forma parte de la Arista instanciada.
 *
 * Precondicion: true
 * Postcondicion: El metodo retorna uno de los Vertices de la Arista instanciada.
 * Orden: O(1)
 */

  public Vertice getExtremo1() {
    return(u);
  }

/**
 * Metodo getExtremo2
 * 
 * Retorna uno de los Vertices de la Arista instanciada.
 *
 * @return: Vertice que forma parte de la Arista instanciada.
 *
 * Precondicion: true
 * Postcondicion: El metodo retorna uno de los Vertices de la Arista instanciada.
 * Orden: O(1)
 */

  public Vertice getExtremo2() {
    return(v);
  }

/**
 * Metodo toString
 * 
 * Representa a la Arista como una cadena de caracteres con su 'peso' y 'id'.
 *
 * @return: String representación de la arista instanciada como una cadena de caracteres.
 *
 * Precondicion: true
 * Postcondicion: Retorna una representación de la arista instanciada como una cadena de caracteres.
 * Orden: O(1)
 */

  public String toString() {
    return ("Arista ID:"+this.idArista+", PESO:"+this.pesoArista);
  }
}

