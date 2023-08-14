using System;

namespace examen
{
	public class Dados
	{
        int mediosCont = 0;
        int extremosCont = 0;
        int paresCont = 0;
        int inparesCont = 0;
        int girosCont = 0;
        int balance = 0;
        Random numeroAleatorio = new Random();
        List<int> numExtremos = new List<int>();
        List<int> numMedios = new List<int>();
        List<int> numPar = new List<int>();
        List<int> numImpar = new List<int>();
        List<int> numeroDados = new List<int>();
        public Dados()
        {
            guardarNumPorExtremoOMedio();//inicilalizamos el orden de los numeros
            guardarNumParImpar();

        }

        public void guardarNumParImpar()
        {
            for (int i = 2; i <= 11; i++)
            {
                if (i % 2 == 0)
                {
                    numPar.Add(i);
                }
                else
                {
                    numImpar.Add(i);
                }
            }
        }
        public void guardarNumPorExtremoOMedio()
        {
            for (int i = 2; i <= 11; i++)
            {
                if (i == 2 || i == 3 || i == 4 || i == 10 || i == 11 || i == 12 )
                {
                    numExtremos.Add(i); //se agregan los numeros extremos a una lista 
                }
                else
                {
                    numMedios.Add(i); //si no son extremos, significa que son medios
                }
            }
        }
       

        public void apostar(int apu)
        {
            balance += apu;
            
            while (balance < 300 || balance % 10 != 0)
            {
                Console.WriteLine("ERROR: La apuesta inicial no es valida");
                string montoNuevo = Console.ReadLine();
                balance = int.Parse(montoNuevo);
                


            }
            Console.WriteLine($"Apostaras ${balance}\n");
        }

        public void juegoNumeroEspecifico()
        {
            if (balance >= 300)
            {
                int dado1 = numeroAleatorio.Next(1,7); //el numero del dado sera entre el 1 y el 7
                int dado2= numeroAleatorio.Next(1, 7);
                int sumaDados = dado1 + dado2;
                Console.WriteLine("¿Cual numero escojeras?");
                string numeroS = Console.ReadLine();
                int numero = Int32.Parse(numeroS);
                girosCont++;
                while (numero < 2 || numero > 12)
                {
                    Console.WriteLine("Elige otro numero, este resultado nunca saldra");
                    numeroS = Console.ReadLine();
                    numero = Int32.Parse(numeroS);
                }
                numeroDados.Add(dado1);
                numeroDados.Add(dado2);
                Console.WriteLine("Agitando los dados....");
                if (numero == sumaDados)
                {
                    balance *= 10;
                    
                    Console.WriteLine("¡¡FELICIDADES!! Has ganado la apiuesta\n");
                }
                else
                {
                    balance -= balance;
                    Console.WriteLine($"Perdiste todo tu dinero, el numero ganador fue {sumaDados}\n");
                }
            }
            else
            {
                Console.WriteLine("No puedes apostar sin dinero.\n");
            }
        }

        public void juegoMedios()
        {
            if (balance >= 300)
            {
                int aleatorio2;
                Boolean encontrado = false; //la variable se utilizara para saber si salio la opcion
                Console.WriteLine("Jugaras con medios");
                girosCont++;
                int dado1 = numeroAleatorio.Next(1, 7); //el numero del dado sera entre el 1 y el 7
                int dado2 = numeroAleatorio.Next(1, 7);
                int sumaDados = dado1 + dado2;
                Console.WriteLine("Agitando los dados....");
                for (int i = 0; i < numMedios.Count; i++)
                {
                    if (sumaDados == numExtremos[i]) //el numero salio en la lista deseada
                    {
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado == true)
                {
                    balance *= 4;
                    
                    Console.WriteLine("¡¡FELICIDADES!! Has ganado la apuesta\n");
                    mediosCont++;
                }
                else
                {
                    balance -= balance;

                    Console.WriteLine($"Perdiste todo tu dinero, los numeros fueron extremos. Salio {sumaDados}\n");
                    extremosCont++;
                }




            }
            else
            {
                Console.WriteLine("No puedes apostar sin dinero.\n");
            }
        }
        public void juegoExtremos()
        {
            if (balance >= 300)
            {
                int aleatorio2;
                Boolean encontrado = false; //la variable se utilizara para saber si salio la opcion
                Console.WriteLine("Jugaras con Extremos");
                girosCont++;
                int dado1 = numeroAleatorio.Next(1, 7); //el numero del dado sera entre el 1 y el 7
                int dado2 = numeroAleatorio.Next(1, 7);
                int sumaDados = dado1 + dado2;
                Console.WriteLine("Agitando los dados....");
                for (int i = 0; i < numExtremos.Count; i++)
                {
                    if (sumaDados == numExtremos[i])
                    {
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado == true)
                {
                    balance *= 8;
                    
                    Console.WriteLine("¡¡FELICIDADES!! Has ganado la apiuesta\n");
                    extremosCont++;
                }
                else
                {
                    balance -= balance;

                    Console.WriteLine($"Perdiste todo tu dinero, los numeros fueron medios. Salio {sumaDados}\n");
                    mediosCont++;
                }


            }
            else
            {
                Console.WriteLine("No puedes apostar sin dinero.\n");
            }   
        }
        public void juegoParesInpares()
        {
            if (balance >= 300)
            {
                int aleatorio3;
                Boolean encontrado2 = false;
                Console.WriteLine("¿Vas Pares o Inpares?");
                string opcion = Console.ReadLine();
                girosCont++;
                while (opcion == "Pares" || opcion == "InPares")
                {
                    Console.WriteLine("Parece que escribiste mal la opcion, intentalo de nuevo.");
                    opcion = Console.ReadLine();
                }
                if (opcion == "Pares")
                {
                    int dado1 = numeroAleatorio.Next(1, 7); //el numero del dado sera entre el 1 y el 7
                    int dado2 = numeroAleatorio.Next(1, 7);
                    int sumaDados = dado1 + dado2;
                    Console.WriteLine("Agitando los dados....");
                    for (int i = 0; i < numPar.Count; i++)
                    {
                        if (sumaDados == numPar[i])
                        {
                            encontrado2 = true;
                            break;
                        }
                    }
                    if (encontrado2 == true)
                    {
                        balance *= 2;
                        
                        Console.WriteLine("¡¡FELICIDADES!! Has ganado la apiuesta\n");
                        paresCont++;
                    }
                    else
                    {
                        balance -= balance;

                        Console.WriteLine($"Perdiste todo tu dinero, los numeros fueron inpares. Salio {sumaDados}\n");
                        inparesCont++;
                    }

                }
                else if (opcion == "Inpares")
                {
                    int dado1 = numeroAleatorio.Next(1, 7); //el numero del dado sera entre el 1 y el 7
                    int dado2 = numeroAleatorio.Next(1, 7);
                    int sumaDados = dado1 + dado2;
                    for (int i = 0; i < numImpar.Count; i++)
                    {
                        if (sumaDados == numImpar[i])
                        {
                            encontrado2 = true;
                            break;
                        }
                    }
                    if (encontrado2 == true)
                    {
                        balance *= 2;
                        
                        Console.WriteLine("¡¡FELICIDADES!! Has ganado la apiuesta\n");
                        inparesCont++;
                    }
                    else
                    {
                        balance -= balance;

                        Console.WriteLine($"Perdiste todo tu dinero, los numeros fueron pares. Salio {sumaDados}\n");
                        paresCont++;
                    }
                }
            }
            else
            {
                Console.WriteLine("No puedes apostar sin dinero.\n");
            }
        }


        public void numeroMasRepetido()
        {
            int maximoNumRepeticiones = 0;
            double moda = 0;
            numeroDados.Sort();
            for (int i = 0; i < numeroDados.Count; i++)
            {
                int numRepeticiones = 0;
                for (int j = 0; j < numeroDados.Count; j++)
                {
                    if (numeroDados[i] == numeroDados[j])
                    {
                        numRepeticiones++;
                    }   //fin if
                    if (numRepeticiones > maximoNumRepeticiones)
                    {
                        moda = numeroDados[i];
                        maximoNumRepeticiones = numRepeticiones;
                    }   //fin if
                }
            }
            Console.WriteLine($"El valor que mas veces salio en los dados es {moda}");
        }
        public void numeroMenosRepetido()
        {
            numeroDados.Sort();
            int maximoNumRepeticiones = 0;
            double modaInversa = 0;
            numeroDados.Sort();
            for (int i = 0; i < numeroDados.Count; i++)
            {
                int numRepeticiones = 0;
                for (int j = 0; j < numeroDados.Count; j++)
                {
                    if (numeroDados[i] != numeroDados[j])
                    {
                        numRepeticiones++;
                    }   //fin if
                    if (numRepeticiones > maximoNumRepeticiones)
                    {
                        modaInversa = numeroDados[i];
                        maximoNumRepeticiones = numRepeticiones;
                    }   //fin if
                }
            }
            Console.WriteLine($"El valor que menos veces salio en los dados es {modaInversa}");
        }
        public void estadisticas()
        {
            int opcion2;
            do
            {
                Console.WriteLine("MENU DE ESTADISTICAS\n" +
        "1-.Balance\n" +
        "2.-Cantidad de giros realizadas\n" +
        "3.-Número que más veces se ha tirado\n" +
        "4.-Número que menos veces se ha tirado\n" +
        "5-.Cantidad de resultados rojos\n" +
        "6.-Cantidad de resultados negros\n" +
        "7.-Cantidad de resultados pares\n" +
        "8.-Cantidad de resultados impares\n" +
        "9.-Salir\n" +
        "POR FAVOR ELIGE UNA OPCION");

                string opcion2S = Console.ReadLine();
                opcion2 = Int32.Parse(opcion2S);
                switch (opcion2)
                {
                    case 1:
                        Console.WriteLine($"Tu balance Actual es ${balance}\n");
                        break;
                    case 2:
                        Console.WriteLine($"Agitaron los dados {girosCont} veces\n");
                        break;
                    case 3:
                        numeroMasRepetido();
                        break;
                    case 4:
                        numeroMenosRepetido();
                        break;
                    case 5:
                        Console.WriteLine($"La cantidad de resultados extremos en el juego de los dados es {extremosCont}");
                        break;
                    case 6:
                        Console.WriteLine($"La cantidad de resultados medios en el juego de los dados es {mediosCont}");
                        break;
                    case 7:
                        Console.WriteLine($"La cantidad de resultados pares en el juego de los dados es  {paresCont}");
                        break;
                    case 8:
                        Console.WriteLine($"La cantidad de resultados inpares en el juego de los dados es  {inparesCont}");
                        break;
                }
            }
            while (opcion2 != 9);

        }
    }
}
