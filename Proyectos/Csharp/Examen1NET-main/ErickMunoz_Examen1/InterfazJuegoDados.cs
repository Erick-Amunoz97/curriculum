using System;

namespace examen{
	public class InterfazJuegoDados
	{
        public InterfazJuegoDados()
        {
            Dados juegos = new Dados();
            int opcion;
            Console.WriteLine("**BIENVENIDO AL JUEGO DE AZAR DE LOS DADOS**\n");
            do
            {
                Console.WriteLine("POR FAVOR ELIGE UNA OPCION\n" +
                    "1-.Agregar dinero para apostar\n" +
                    "2-.Apostar a un numero especifico\n" +
                    "3.-Apostar a los Medios\n" +
                    "4-.Apostar a los Extremos\n" +
                    "5.-Apostar a un numero Par o Impar\n" +
                    "6.-Ver estadisticas de partida\n" +
                    "0.-Salir\n");
                string opcionS = Console.ReadLine();
                opcion = Int32.Parse(opcionS);

                switch (opcion)
                {
                    case 1:
                        Console.WriteLine("¿Cuanto es la cantidad de dinero que apostaras? ");
                        string montoNuevo = Console.ReadLine();
                        int apuesta = int.Parse(montoNuevo);
                        juegos.apostar(apuesta);
                        break;
                    case 2:
                        juegos.juegoNumeroEspecifico();
                        break;

                    case 3:
                        juegos.juegoMedios();
                        break;
                    case 4:
                        juegos.juegoExtremos();
                        break;
                    case 5:
                        juegos.juegoParesInpares();
                        break;
                    case 6:
                        juegos.estadisticas();
                        break;
                }

            }
            while (opcion != 0);
        }
    }
}
