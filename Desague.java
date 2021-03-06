/**
 * Universidad Simón Bolıivar
 * Departamento de Computacion y Tecnologıia de la Informacion
 * Laboratorio de Algoritmos y Estructuras III
 * Trimestre Septiembre-Diciembre 2017
 * 
 * Actividad 1 - Calcula los lugares donde se debe colocar un desagüe
 *				 para evitar que el agua se estanque.
 *				 
 * 
 * Desague.java
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
import java.io.PrintWriter;
import java.io.File ;

/**
 * Clase Charcos
 * 
 * Retorna en consola el resultado de la Actividad 1
 * 
 * @return void
 * 
 * Precondicion: true
 * Postcondicion: true
 */

public class Desague
{
	
	public static void main(String args[])
	{

		GrafoNoDirigido ciudad = new GrafoNoDirigido() ;

		ciudad.cargarGrafo(args[0]) ;
		ciudad.desague() ;
		ciudad.imprimir() ;

	}
}