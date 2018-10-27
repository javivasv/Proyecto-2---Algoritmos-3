/**
 * Universidad Simon Bolıivar
 * Departamento de Computacion y Tecnologia de la Informacion
 * Laboratorio de Algoritmos y Estructuras III
 * Trimestre Septiembre-Diciembre 2017
 * 
 * Lado.java
 * 
 * Representacion del tipo de dato abstracto (TAD) correspondiente a un Lado de 
 * un TAD Grafo.
 * 
 * @Autores: Javier Vivas 12-11067, Daniel Francis 12-10863
 *
 * @Ultima_modificacion: 18.10.2017
 */

/**
 * Clase Lado
 * 
 * @param id: String que identifica al lado.
 * @param peso: double que representa el peso del lado.
 */


public abstract class Lado
{
  public String id;
  public double peso;

  public Lado(String id, double peso) {
  }

/**
 * Metodo getId
 * 
 * Retorna el id del objeto instanciado tipo Lado.
 *
 * @return id:    String identificador del lado.
 *
 * Precondicion: true
 * Postcondicion: El metodo retorna un String correspondiente al id del lado.
 * Orden: O(1)
 */

  public String getId() {
  	return(id);
  }

/**
 * Metodo getPeso
 * 
 * Retorna el peso del objeto instanciado tipo lado.
 *
 * @return peso:  Double representa el peso del lado.
 *
 * Precondicion: true
 * Postcondicion: El metodo retorna un entero correspondiente al peso del lado.
 * Orden: O(1)
 */

  public double getPeso() {
  	return(peso);
  }

/**
* Metodo abstracto toString 
* @see toString en Arco.java y en Arista.java
* Orden: O(1)
*/

  public abstract String toString();

}