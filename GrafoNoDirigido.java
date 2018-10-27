/**
 * Universidad Simon Bolivar
 * Departamento de Computacion y Tecnologia de la Informacion
 * Laboratorio de Algoritmos y Estructuras III
 * Trimestre Septiembre-Diciembre 2017
 * 
 * Representacion del tipo de dato abstracto (TAD) correspondiente a un GrafoNoDirigido.
 * 
 * GrafoNoDirigido.java
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
 * Clase GrafoNoDirigido, implementa Grafo tal que GrafoNoDirigido es G si G = (V,E)
 * 
 * @param columnas: entero que representa numero de columnas de la ciudad cargada
 * @param filas: entero que representa numero de filas de la ciudad cargada
 * @param listaEdificios: lista de vertices que contiene a los edificios de la ciudad
 * @param listaModificacion: lista de vertices que contiene a los vertices mientras se modifica su altura
 * @param listaVerificacion: lista de vertices para comparar altura de edificios adyacentes
 * @param line: String usado para lectura de archivos .txt
 */

public class GrafoNoDirigido implements Grafo
{
  public int columnas ;
  public int filas ;
  public int numEdificios ;
  public List<Vertice> listaEdificios = new ArrayList<Vertice>();
  public List<Vertice> listaModificacion = new ArrayList<Vertice>();
  public List<Vertice> listaVerificacion = new ArrayList<Vertice>();
  String line = null;

    public GrafoNoDirigido()
    {

    }

/**
 * Metodo cargarGrafo
 * 
 * Carga un TAD GrafoNoDirigido a partir de un archivo de texto con un formato especifico.
 *
 * @param dirArchivo: String que indica el nombre+extension del archivo de texto a leer para formar el grafo
 * @return bool:      Indica si el archivo se cargo correctamente
 * 
 * Precondicion: dirArchivo es un String y dirArchivo es el nombre de un archivo con formato correcto
 * Postcondicion: El grafo no dirigido instanciado representa la ciudad descrita en el archivo
 * Orden: n^2
 *
 */

    public boolean cargarGrafo(String dirArchivo)
    {
    String fileName = dirArchivo;                                                                   

    try
    {
      FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      line = bufferedReader.readLine();
      filas = Integer.parseInt(line);

      line = bufferedReader.readLine();
      columnas = Integer.parseInt(line);

      numEdificios = filas * columnas ;

      int j = 0 ;
      while((line = bufferedReader.readLine()) != null)
      {
        String [] arregloColumnas = line.split(" ") ;

        for (int i = 0; i < arregloColumnas.length ; i++)
        {
          String id = i + "," + j ;
          double alturaEdificio = Double.parseDouble(arregloColumnas[i]) ;
          Vertice nuevoEdificio = new Vertice(id,alturaEdificio) ;
          nuevoEdificio.desague = true ;
          nuevoEdificio.frontera = false ;
          nuevoEdificio.visitado = false ; 
          listaEdificios.add(nuevoEdificio) ;

          if ((i == 0) ^ (i == columnas-1))
          {
            nuevoEdificio.frontera = true ;
            nuevoEdificio.desague = false ;
          }

          if ((j == 0) ^ (j == filas-1))
          {
            nuevoEdificio.frontera = true ;
            nuevoEdificio.desague = false ;
          }

          if (j != 0)
          {
            int k = j-1 ;
            this.agregarArista("N/A",0, i + "," + j,i + "," + k) ;
          }

          if (i != 0)
          {
            int k = i-1 ;
            this.agregarArista("N/A",0,i + "," + j,k + "," + j) ;
          }

        }

        j++ ;            
      }

    } 

    catch(FileNotFoundException ex)
    {
      System.out.println("Archivo no encontrado '" + fileName + "'") ;
    }

    catch(IOException ex)
    {
      System.out.println("Error leyendo archivo '" + fileName + "'") ; 

    }

    return (true) ;

    }

 /**
 * Metodo numeroDeVertices
 * 
 * No implementado
 */  
    
    public int numeroDeVertices()
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo numeroDeLados
 * 
 * No implementado
 */  

    public int numeroDeLados()
    {
		throw new UnsupportedOperationException();
    }
   
/**
 * Metodo agregarVertice
 * 
 * No implementado
 */  

    public boolean agregarVertice(Vertice v)
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo agregarVertice
 * 
 * No implementado
 */  

    public boolean agregarVertice(String id, double peso)
    {
		throw new UnsupportedOperationException();
    }
    
/**
 * Metodo obtenerVertice
 *
 * Obtiene un vertice del grafo a partir de su id
 *
 * @param id: String que indica el id del vertice a obtener
 * @return Vertice: El vertice cuyo id es "id"
 * 
 * Precondicion: El grafo esta inicializado
 * Postcondicion: El vertice de id "id" existe en el grafo
 * Orden: O(n)
 */  

    public Vertice obtenerVertice(String id)
    {																								
        for (int j=0; j < listaEdificios.size(); j++)												
        {
            if (listaEdificios.get(j).id.equals(id))
            {
                return (listaEdificios.get(j));
            }
        }      
        System.out.println("El edificio "+ id +" no existe en el grafo");
        throw new NoSuchElementException();
    }

/**
 * Metodo estaVertice
 * 
 * No implementado
 */  

    public boolean estaVertice(String id)
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo estaLado
 * 
 * No implementado
 */  

    public boolean estaLado(String u, String v)
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo eliminarVertice
 * 
 * No implementado
 */  

    public boolean eliminarVertice(String id)
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo vertices
 * 
 * No implementado
 */  

    public List<Vertice> vertices()
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo lados
 * 
 * No implementado
 */  

    public List<Lado> lados()
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo grado
 * 
 * No implementado
 */  

    public int grado(String id)
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo adyacentes
 * 
 * No implementado
 */  

    public List<Vertice> adyacentes(String id)
    {
		throw new UnsupportedOperationException();
    }
 
/**
 * Metodo incidentes
 * 
 * No implementado
 */  

    public List<Lado> incidentes(String id)
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo clone
 * 
 * No implementado
 */  

    public Grafo clone()
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo toString
 * 
 * No implementado
 */  

    public String toString()
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo agregarArista
 * 
 * No implementado
 */  

    public boolean agregarArista(Arista a)
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo agregarArista
 * 
 * Agrega una arista al grafo
 *
 * @param id: String que representa el id de la arista
 * @param peso: double que representa el peso de la arista
 * @param u: id de uno de los vertices de la arista
 * @param v: id del otro vertice de la arista
 * @return bool: Indica si la arista se agrega correctamente
 * 
 * Precondicion: El grafo esta inicializado
 * Postcondicion: La arista de id "id" pertenece al grafo
 * Orden: O(k)
 */


    public boolean agregarArista(String id, double peso, String u, String v)
    {																								
        Vertice vertice1 = obtenerVertice(u) ;														
        Vertice vertice2 = obtenerVertice(v) ;

        vertice1.listaAdyacencias.add(vertice2) ;
        vertice2.listaAdyacencias.add(vertice1) ;

        return (true) ;
    }

/**
 * Metodo eliminarArista
 * 
 * No implementado
 */ 

    public boolean eliminarArista(String id)
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo obtenerArista
 * 
 * No implementado
 */ 

    public Arista obtenerArista(String id)
    {
		throw new UnsupportedOperationException();
    }

/**
 * Metodo desague
 * 
 * Realiza la primera actividad, determinando donde es apropiado colocar un desague para
 * evitar que el agua se estanque. Imprime el resultado en pantalla
 *
 * @return void
 * 
 * Precondicion: El grafo esta inicializado
 * Postcondicion: La primera actividad es correcta
 *
 * Orden n^2
 */ 

    public void desague()																			
    {   																							
      for (int i = 0; i < listaEdificios.size(); i++)												
      {			
        if (listaEdificios.get(i).frontera == false)												// Evalua cada vertice (edificio) buscando alguno que no sea frontera												
        {
          	if (listaEdificios.get(i).visitado == false)											// Evalua tambien si ese vertice (edificio) ya fue visitado
          	{																						
            	listaEdificios.get(i).desague = verificarAdyacencias(listaEdificios.get(i)) ;		// Llama a la funcion verificarAdyacencias sobre ese vertice (edificio)

            	for (int k = 0; k < listaVerificacion.size(); k++)									// Busca en el grafo todos los vertices (edificios) que fueron
            	{																					// añadidos a la lista auxiliar "listaVerificacion" y actualiza
            		String vVerId = listaVerificacion.get(k).id ;									// su atributo .desague al resultado de la llamada a de
            		Vertice vVer = obtenerVertice(vVerId) ;											// verificarAdyacencias
            		vVer.desague = listaEdificios.get(i).desague ;	
            	}

            	while (listaVerificacion.size() > 0)												// Limpia la lista auxiliar "listaVerificacion"
            	{
            		listaVerificacion.remove(listaVerificacion.get(0)) ;
            	}
          	}
        }
      }
    }

/**
 * Metodo verificarAdyacencias
 * 
 * Basado en DFS, visita vertices adyacentes al vertice de entrada para verificar si v necesita un desague
 *
 * @param v: Vertice cuyas adyacencias han de ser verificadas
 * @return void
 * 
 * Precondicion: El grafo esta inicializado
 * Postcondicion: V es un desague o W pert a Ady(V) es un desague
 *
 * Orden n^2
 */ 

    public boolean verificarAdyacencias(Vertice v)
    {																								// Marca el edificio como visitado para no evaluarlo dos veces
      v.visitado = true ;
      listaVerificacion.add(v) ;

      if (v.frontera == true)
      {
        return(false) ;
      }

      for (int i = 0; i < v.listaAdyacencias.size(); i++)											// Verifica todas las adyacencias del edificio (Son 4)
      {
        if (v.listaAdyacencias.get(i).peso < v.peso)												// Si encuentra un edificio de menor altura, devuelve falso
        {
          return (false) ;
        }

        if (v.listaAdyacencias.get(i).peso == v.peso)												// Si encuentra un edificio de igual altura, evalua...
        {
          if (v.listaAdyacencias.get(i).desague == false)											// Si el adyacente no necesita desague, el edificio evaluado tampoco
          {
            return (false) ;
          }

          if (v.listaAdyacencias.get(i).visitado == false)											// Si el adyacente no ha sido evaluado, evalualo con verificarAdyacencias
          {
            v.desague = verificarAdyacencias(v.listaAdyacencias.get(i)) ;
          }
        }

      }

      return (v.desague) ;																			// Retorna true si necesita desague, falso en caso contrario
    }

/**
 * Metodo metrosCubicos
 * 
 * Analiza la lista de edificios y halla el volumen de agua estancada en caso de una fuerte lluvia
 * Imprime en pantalla el resultado.
 *
 * @return void
 *
 * Precondicion: El grafo esta inicializado
 * Postcondicion: El volumen de agua estancada se imprime en pantalla y es mayor o igual a cero
 *
 * Orden n^2 * n*log(n)
 */ 

    public void metrosCubicos()
    {
    	double metrosCubicos = 0 ;
    	double masBajo = 999999 ;
    	double alturaBaja = 0 ;

    	for (int j = 0; j < listaEdificios.size(); j++)												// Recorro todo el grafo y marco los vertices (edificios) como
    	{																							// no visitados
    		listaEdificios.get(j).visitado = false ;
    	}

    	for (int i = 0; i < listaEdificios.size(); i++)
    	{
	    	if (listaEdificios.get(i).desague == true)												// Recorro el grafo buscando un vertice que segun la funcion desague
	    	{																						// necesite un desague
	    		while (listaEdificios.get(i).desague == true)
	    		{
	    			masBajo = 999999 ;
		    		alturaBaja = calcularAltura(listaEdificios.get(i),masBajo) ;					// Llama a calcularAltura sobre el vertice encontrado

		    		if (alturaBaja < listaEdificios.get(i).peso)									// Si la altura mas baja retornada por calcularAltura es menor a la
		    		{																				// altura del vertice (edificio) evaluado, cambia su atributo .desague
		    			listaEdificios.get(i).desague = false ;										// a false

		    			for (int k = 0; k < listaModificacion.size(); k++)							// Busca en el grafo todos los vertices (edificios) que fueron
		    			{																			// añadidos a la lista auxiliar "listaModificacion" y actualiza
		    				String vModId = listaModificacion.get(k).id ;							// su atributo .visitado a false
		    				Vertice vMod = obtenerVertice(vModId) ;
		    				vMod.visitado = false ;
		    			}
		    		}

		    		if (alturaBaja > listaEdificios.get(i).peso)									// Si la altura mas baja retornada por calcularAltura es mayor a la
		    		{																				// altura del vertice (edificio) evaluado...
		    			for (int k = 0; k < listaModificacion.size(); k++)
		    			{																			// Busca en el grafo todos los vertices (edificios) que fueron
		    				String vModId = listaModificacion.get(k).id ;							// añadidos a la lista auxiliar "listaModificacion" y actualiza
		    				Vertice vMod = obtenerVertice(vModId) ;									// el valor de metrosCubicos, actualiza el atributo .peso de todos los
		    				metrosCubicos = metrosCubicos + (alturaBaja - vMod.peso) ;				// vertices (edificios) a la altura mas baja y actualiza el atributo
		    				vMod.peso = alturaBaja ;												// .visitado a false
		    				vMod.visitado = false ;		    				
		    			}
		    		}

		    		while (listaModificacion.size() > 0)											// Limpia la lista auxiliar "listaModificacion"
		    		{
		    			listaModificacion.remove(listaModificacion.get(0)) ;
		    		}

	    		}
	    	}	
    	}

    	System.out.println("El volumen es igual a " + metrosCubicos + " metros cubicos") ;
    }

/**
 * Metodo calcularAltura
 * 
 * Calcula la altura correspondiente a un vertice respecto a una altura de referencia
 *
 * @param v: Vertice cuya altura ha de ser verificada
 * @param masBajo: altura de referencia para el vertice
 * @return la altura correcta del vertice v
 * 
 * Precondicion: El grafo esta inicializado
 * Postcondicion: En las adyacencias de v hay un edificio con la altura mas baja del conjunto, de no ser v
 *
 * Orden n*log(n) 
 */ 

    public double calcularAltura(Vertice v, double masBajo)
    {
    	listaModificacion.add(v) ;																	// Añado el vertice en una lista de vertices auxiliar
    	v.visitado = true ;																			// Hago que el vertice (edificio) sea marcado como visitado
    	double alturaMasBaja = masBajo ;

    	for (int j = 0; j < v.listaAdyacencias.size(); j++) 										// Ciclo que evalua todos los vertices (edificios) adyacentes
    	{
    		if (v.listaAdyacencias.get(j).peso < alturaMasBaja)										// Si la altura del vertice (edificio) es menor a la más baja, evalua...
    		{																						
    			if (v.listaAdyacencias.get(j).peso == v.peso)										// Si la altura del adyacente es igual al actual...
    			{
    				if (v.listaAdyacencias.get(j).frontera == true)									// Evalua si el adyacente es frontera
    				{
    					return(0) ;
    				}

    				if (v.listaAdyacencias.get(j).visitado == false)								// Si el adyacente no ha sido visitado, lo visita
    				{
    					alturaMasBaja = calcularAltura(v.listaAdyacencias.get(j),alturaMasBaja) ;	// Llama a la funcion calcularAltura
    					v.listaAdyacencias.get(j).visitado = true ;
    				}
    			}

    			if (v.listaAdyacencias.get(j).peso > v.peso)										// Si el adyacente es de mayor altura al vertice actual, su altura es
    			{																					// la mas baja
    				alturaMasBaja = v.listaAdyacencias.get(j).peso ;
    			}

    			if (v.listaAdyacencias.get(j).peso < v.peso)										// Si el adyacente es de menor altura al actual, su altura es la mas
    			{																					// baja
    				alturaMasBaja = v.listaAdyacencias.get(j).peso ;
    			}
    		}
    	}

    	return(alturaMasBaja) ;																		// Retorna la altura mas baja conseguida en los adyacentes de los
    }																								// vertices evaluados

/**
 * Metodo imprimir
 * 
 * Imprime en pantalla el arreglo de desagues de la ciudad/grafo
 *
 * @return void
 * 
 * Precondicion: El grafo esta inicializado. 
 * Postcondicion: La actividad 1 esta correcta
 *
 * Orden n*log(n) 
 */ 

    public void imprimir()																			
    {																								// Crea una matriz de las mismas dimensiones de la ciudad
      String [][] matrizTablero = new String[columnas][filas] ;
      int idI ;
      int idJ ;

      for (int i = 0; i < listaEdificios.size(); i++)												// Añade posicion a posicion si necesita un desague o no
      {
        String [] arregloId = listaEdificios.get(i).id.split(",") ;
        
        idI = Integer.parseInt(arregloId[0]) ;
        idJ = Integer.parseInt(arregloId[1]) ;

        if (listaEdificios.get(i).desague == false)
        {
          matrizTablero [idI][idJ] = "0" ;															// Si el vertice (edificio) no necesita desague, muestra un "0"
        }

        if (listaEdificios.get(i).desague == true)
        {
          matrizTablero [idI][idJ] = "X" ;															// Si el vertice (edificio) necesita desague, muestra una "X"
        }
      }

      for (int i = 0; i < filas; i++)																// Imprime la matriz
      {
        for (int j = 0; j < columnas; j++)
        {
          System.out.print("[" + matrizTablero[j][i] + "]") ;
        } 

        System.out.printf("%n"); 
      }
    }

}
