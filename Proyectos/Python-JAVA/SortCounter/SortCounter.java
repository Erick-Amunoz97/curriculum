import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;



public class SortCounter{
    public static int cont,nn,zz;
    public static int n; //cantidad de elementos a ordenar
	public static int[] A = new int[n];
	public static int[] ordenado = new int[n];
	public static int conta = 0;
	public static int count = 0;
    public static int [] arr = new int[n];
    

	
    public static void main(String[] args) throws FileNotFoundException {
        
       int Datos[] = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25, 30, 35, 40, 50, 60, 70, 80, 90, 100};
       
       int n,max,i,j,key,y,z;
       double x =0;
       int contador = 0;

       //------------------------------------------------------------------------------Insertion Sort
       int[] pasos = new int[22]; 
       
        for (z = 0; z< Datos.length; z++){
        n = Datos[z];
        max = 1000;
        
        int A[] = new int[n];

        
        for( i=0; i<A.length-1;i++){
            x = Math.random();
           y = (int)(x*max+1);
           // y =(int)x;
            A[i] = y;
            
        }

         A[A.length-1] = max;

        
        

        for(j=1; j<A.length-1;j++){
            contador = contador+2 ;
            key = A[j];
            i = j-1;
            contador = contador +2;
            while(i>=0&& A[i]>key){
                contador = contador +2;
                A[i+1] = A[i];
                i = i-1;
                contador = contador +2;
               
            }
            A[i+1] = key;
            contador = contador +1;
            
            


        }
        System.out.println();
        System.out.print("A" +"["+n+"]"+  "Ordenado : ");
        

        for(i=0; i<A.length; i++){
            System.out.print(A[i]+" ");
        }
        
        System.out.println();
        System.out.println("Numero de pasos: " + contador);
        
        pasos[z] = contador;

    }
    System.out.print("pasos: ");

    for(i=0; i<pasos.length; i++){
        System.out.print(pasos[i]+" ");
    }

    File csvFile = new File("Complejidad.csv");
    PrintWriter out = new PrintWriter(csvFile);

    
    out.println("Insertion Sort Complejidad:");

    for(i=0; i<pasos.length; i++){
        y = pasos[i];
        j = Datos[i];
        out.println("n = " + j + " , " + "pasos: " +y);
    }

    //-------------------------------------------------------Bubble Sort
        contador = 0;
        pasos = new int[22];

        for (z = 0; z< Datos.length;z++){

            n = Datos[z];
            max = 1000;

            int A[] = new int[n];

            for( i=0; i<A.length-1;i++){
                x = Math.random();
               y = (int)(x*max+1);
                A[i] = y;
                
            }
    
             A[A.length-1] = max;


            for( i =0; i<A.length-1;i++){
                contador = contador +2;
                for(j =0;j<A.length-1;j++){
                    contador = contador +2;
                    if(A[j]>A[j+1]){
                        contador = contador +1;
                        A[j] = A[j+1];
                        contador = contador +1;

                    }
                }

            }
            System.out.print("A" +"["+n+"]"+  "Ordenado : ");
            for(i=0; i<A.length; i++){
                System.out.print(A[i]+" ");
            }
            System.out.println();
            System.out.println("Numero de pasos: " + contador);
            pasos[z] = contador;




        }

        System.out.print("pasos: " );
        for(i=0; i<pasos.length; i++){
            System.out.print(pasos[i]+" ");
        }



        out.println("------------------------------------------------------------------------------------------");
        out.println("Bubble Sort Complejidad:");
        out.println("");

    for(i=0; i<pasos.length; i++){
        y = pasos[i];
        j = Datos[i];
        out.println("n = " + j + " , " + "pasos: " +y);


    }

    //----------------------------------------------------------------MergeSort
   
	
	//Inicializamos el contador de instrucciones, solo se incrementará en los pasos que son propios del algoritmo
		//no de la implementación
        cont = 0;
		int maximo = 1000;
        pasos = new int[22]; 
        
		

        for (z = 0; z< Datos.length; z++){
            n = Datos[z];
            
            int []A = new int [n];
            int[] Ordenado = new int[n];

		//Llenamos el arreglo de n numeros aleatorios
		for( i=0;i<A.length;i++){
			A[i] = (int)Math.floor(Math.random()*maximo);
		}
	
		
	
		//Mandamos llamar al metodo mergeSort que devuelve un arreglo ordenado
		Ordenado = mergeSort(A); 

        
		
        
        System.out.println("n: " +n);
        System.out.println("pasos: " +cont);
		
		//System.out.println("Se ordenaron "+n+" datos usando "+cont+" instrucciones");
        pasos[z] = cont;
		
	}

    out.println("------------------------------------------------------------------------------------------");
    out.println("Merge Sort Complejidad:");
    out.println("");

for( i=0; i<pasos.length; i++){
     y = pasos[i];
     j = Datos[i];
    out.println("n = " + j + " , " + "pasos: " +y);
}

//------------------------------------HeapSort-------------------------------------------------------

pasos = new int[22]; 

for ( z = 0; z< Datos.length; z++){
    n = Datos[z];
    A = new int[n];
ordenado = new int[n];

 maximo = 1000;  //valor maximo para los elementos

//Llenamos el arreglo original con numeros aleatorios
for( i=0;i<A.length;i++){
    A[i] = (int)Math.floor(Math.random()*maximo);
}

//Imprimimos el arreglo original
System.out.println("Arreglo original:");
for( i=0;i<A.length;i++){
    System.out.print(" "+A[i]);
}

System.out.println("\n\nCantidad de elementos ordenados: "+n);
HeapSort(A);


System.out.println("\nArreglo Ordenado:");
for( i=0;i<ordenado.length;i++){
    System.out.print(" "+ordenado[i]);
}
    


System.out.println("\n\nEl contador fue: "+conta);

pasos[z] = conta;

}

out.println("------------------------------------------------------------------------------------------");
    out.println("Heap Sort Complejidad:");
    out.println("");

    for( i=0; i<pasos.length; i++){
        y = pasos[i];
        j = Datos[i];
       out.println("n = " + j + " , " + "pasos: " +y);
    }
    


	//------------------------------------QuickSort----------------------------------------------------
	
    pasos = new int[22]; 
	for( z =0; z<Datos.length; z++){
	n = Datos[z];

	 arr = new int [n];
	 maximo = 1000;

	for( i=0;i<arr.length;i++){
		arr[i] = (int)Math.floor(Math.random()*maximo);
	}
	 n = arr.length-1;
	System.out.println("Desordenado: ");
	printArray(arr, n);
	quickSort(arr, 0, n );
	System.out.println("Ordenado: ");
	printArray(arr, n);
	System.out.println("Contador: " + count);
	pasos[z] = count;
}
out.println("------------------------------------------------------------------------------------------");
out.println("QuickSort Complejidad:");
out.println("");

for( i=0; i<pasos.length; i++){
	y = pasos[i];
	j = Datos[i];
   out.println("n = " + j + " , " + "pasos: " +y);
}



    out.close();

	

    }
	static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        count = count +1;
        int i = (low - 1);
        count = count +2;
  
        for (int j = low; j <= high - 1; j++) {
            count = count +2;
            if (arr[j] < pivot) {
                count = count +1;
                i++;
                count = count +2;
                swap(arr, i, j);
                count = count +2;
            }
        }
        swap(arr, i + 1, high);
        count = count+2;
        return (i + 1);
    }
  
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
  
        System.out.println();
    }
	

	

    public static void HeapSort(int[] A ){
	
		int i = A.length;
		
		while(A.length>0){					//mientras haya elementos en el arreglo A
			
			//Creamos un heap con el arreglo A
			crear_Heap(A);
			//Una vez creado el heap, extremos el maximo (la raiz) y la guardamos en el arreglo de elementos ordenados
			ordenado[i-1] = extrae_Maximo(A);
			
			//Una vez que ya extragimos la raiz del heap, ponemos como raiz la ultima hoja (la cual obviamente se elimina como hoja)
			A = poner_Raiz(A);	
	
			i--;
	
		}
	}	
	
	public static void crear_Heap(int[] A){
	
		int n = A.length;
		for(int k = (n/2)-1;k>=0;k--){
			conta += 2;
			corregir_Cima(A,k);
		}

	}
	
	public static void corregir_Cima(int[] A, int k){
	
		int aux = 0;
		int n = A.length;						
		int j = 0;
		
		//modificaremos el pseudocodigo ya que alli tomaba el indice desde 1 y en java es desde 0
		int nodo = k;
		int hijo_izquierdo = (2*k)+1;
		int hijo_derecho = (2*k) + 2;
		
		//Para saber de que forma corregir la cima (si comparo con 0,1 o 2 hijos) obtengo el numero de hijos del nodo en posicion k
		int hijos_k = num_hijos(A,k);
		
		//corrijiendo cima cuando los nodos tienen 2 hijos
		if( hijos_k == 2){		
	
			//obtenemos el indice del elemento que sea mayor y lo asignamos a j
			if(A[k] > A[hijo_izquierdo]){
				if(A[k] > A[hijo_derecho]){
					j = k;
				}else{
					j = (2*k) + 2;
				}
			}else{
				if(A[hijo_izquierdo] > A[hijo_derecho]){
					j = (2*k)+1;
				}else{
					j = (2*k) + 2;
				}
			}
		
		}
		
		//corrigiendo cima cuando el nodo tiene solo un hijo (el izquierdo)
		if(hijos_k == 1){
			if(A[k] > A[hijo_izquierdo]){
				j = k;
			}
			else{
				j = (2*k)+1;
			}
		
		}
		
		//corrigiendo cima cuando queda solo 1 nodo (tiene 0 hijos)
		if(hijos_k == 0){
			j = k;
		}
		
		
		//Intercambiamos si algun hijo fue mayor que algun padre
		if(j!=k){	
			aux = A[k];
			A[k] = A[j];
			A[j] = aux;
			
			//Manda llamar recursivamente a corregir cima por si algo se desacomodo (solo la llama
			//si es una j valida, es decir, que tenga hijos)
			if(j <= (n/2)-1){
				conta ++;
				corregir_Cima(A,j);
			}
		}
		
	}
	
	//Metodo que recibe un heap y extrae el maximo, o sea la raiz
	public static int extrae_Maximo(int[] heap){
		int maximo = heap[0];
		return maximo;
		
	}
	
	
	
	//Metodo para colocar como raiz al ultimo nodo del heap, una vez que se haya extraido el maximo
	public static int[] poner_Raiz(int[] heap){
	
		//En este arreglo copiaremos los n-1 elementos del arreglo original
		int[] nuevo = new int[heap.length-1];
		//Pone como raiz a la ultima hoja
		heap[0] = heap[heap.length-1];		
		//Hace una copia del arreglo original, pero sin la ultima posicion, pues ese elemento ya es la raiz
		System.arraycopy(heap,0,nuevo,0,heap.length-1);
		
		return nuevo;
	}
	
	
	
	
	
	//metodo que recibe un arreglo y un indice k y calcula cuantos hijos tiene ese elemento con indice k
	public static int num_hijos(int[] A, int k){
		n = A.length;
		int hijos = 0;
		
		if (n == 1){
			hijos = 0;
		}else{
			if (n%2==0){				//cuando el numero de nodos es par es cuando puede haber nodos con un solo hijo
				if (k <= ((n-1)/2)-1 ){
					hijos = 2;
				}
				if (k == (n-1)/2 ){
					hijos = 1;
				}
			}else{					//cuando el numero de nodos es impar cualquier nodo tendra siempre 2 hijos
				hijos = 2;
			}
		}
		
		return hijos;
	}

    public static int[] mergeSort(int[] arreglo){
					
		//Declaramos arreglos para almacenar la mitad izquierda y la mitad derecha del arreglo actual
		//que se este procesando
		int[] mitadIzquierda = new int[arreglo.length/2];
		int[] mitadDerecha = new int[arreglo.length - mitadIzquierda.length];	
		//con estos dos ciclos dividimos el arreglo en las dos mitades
		for(int i=0;i<mitadIzquierda.length;i++){
			mitadIzquierda[i]=arreglo[i];
		}

		for(int j=0;j<mitadDerecha.length;j++){
			mitadDerecha[j]=arreglo[mitadIzquierda.length+j];
		}
		//Aqui empieza la recursividad
		//Mandamos llamar a mergeSort para cada una de las mitades y entonces el algoritmo
		//hara lo mismo para cada mitad
		//Ambas mitades se pasan al metodo merge
		if(arreglo.length > 1){
			//El metodo merge devuelve un arreglo ordenado		
			arreglo = merge(mergeSort(mitadIzquierda),mergeSort(mitadDerecha));	
		}
		return arreglo;
        
			
	}
    
	

	public static int[] merge(int[] arreglo2, int[] arreglo3){
		
	
		int i1=0, i2=0, i3=0, tamTotal = 0, contador = 0;
		int[] arreglo1 = new int[arreglo2.length + arreglo3.length];
		tamTotal = arreglo1.length; 			
		while(contador < tamTotal){
			//estos primeros dos ifs los pongo para cuando ya se termino de leer alguna de las mitades
			//y se quiera comparar el siguiente indice, marcara indice fuera de rango, por eso, si por ejemplo
			//el arreglo 2 ya se leyo todo, pues ya el ultimo elemento sera el de arreglo 3 y viceversa
			if (i2 == arreglo2.length){
				arreglo1[i1++] = arreglo3[i3++];
				cont = cont + 3;     //el cont se incrementa en 3 debido a que e la linea pasada la i1 e i3 se incrementan
						     //y también hay una asignación
				contador++;
				continue;
			}

			
			if (i3 == arreglo3.length){
				arreglo1[i1++] = arreglo2[i2++];
				cont = cont + 3;     //el cont se incrementa en 3 debido a que e la linea pasada la i1 e i2 se incrementan
						     //y también hay una asignación
				contador++;
				continue;
			}
			
	
						
      
			
			//Los ifs del algoritmo, donde compara los dos arreglos y forma el arreglo ordenado
			cont = cont + 1;     //se incrementa el cont por la comparación que hace el if
			if(arreglo2[i2] < arreglo3[i3]){
				arreglo1[i1++] = arreglo2[i2++];
				cont = cont + 3;     //el cont se incrementa en 3 debido a que e la linea pasada la i1 e i2 se incrementan
						     //y también hay una asignación
				contador++;
			}
			else{
				arreglo1[i1++] = arreglo3[i3++];
				cont = cont + 3;     //el cont se incrementa en 3 debido a que e la linea pasada la i1 e i3 se incrementan
						     //y también hay una asignación
				contador++;
			}	
			
		}	


		return(arreglo1);
	
	}



}