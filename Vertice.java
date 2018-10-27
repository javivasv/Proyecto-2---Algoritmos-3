/**
 * Universidad Simón Bolıivar
 * Departamento de Computacion y Tecnologıia de la Informacion
 * Laboratorio de Algoritmos y Estructuras III
 * Trimestre Septiembre-Diciembre 2017
 * 
 * Vertice.java
 * 
 * Representacion de un objeto tipo vertice para el 
 * tipo de dato abstracto (TAD) correspondiente a un GrafoNoDirigido.
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
 * Clase Vertice
 * 
 * @param id: String que identifica al vertice.
 * @param peso: double que representa el peso del vertice.
 * @param frontera: booleano que dice si el vertice es frontera
 * @param desague: booleano que dice si el vertice tiene desague
 * @param visitado: booleano que dice si el vertice ha sido visitado
 * @param listaAdyacencias: ArrayList de Vertices que contiene a los vertices adyacentes al objeto instanciado
 */

public class Vertice
{
  public String id;
  public double peso;
  public boolean frontera ;
  public boolean desague ;
  public boolean visitado ;
  public List<Vertice> listaAdyacencias = new ArrayList<Vertice>() ;
  
  /**
  * Metodo constructor de Vertice
  *
  * @param id: String que representa el la coordenada del vertice
  * @param peso: double que representa el peso del vertice
  */

  public Vertice(String id, double peso)
  {
    this.id = id ;
    this.peso = peso ;

  }
}