
# transposition-trial

## Descripcion
Our data got corrupted on the way here. Luckily, nothing got replaced, but every block of 3 got scrambled around! The first word seems to be three letters long, maybe you can use that to recover the rest of the message.Download the corrupted message [here](https://artifacts.picoctf.net/c/192/message.txt).

## Pistas
Split the message up into blocks of 3 and see how the first block is scrambled
## Solucion
Al usar cat con el archivo .txt proporcionado se nos da: 

```bash()
┌──(kali㉿kali)-[~/notas-hacking/PicoCTf/crypto/TranspositionTrial]
└─$ cat message.txt      
heTfl g as iicpCTo{7F4NRP051N5_16_35P3X51N3_V091B0AE}2  
```
Como podemos ver la bandera esta codificada con una herramienta de cipher transposition. Al buscar una en linea jugamos con varios reacomodos hasta llegar a la que estamos buscando. que es 2,3,1. nos da la bandera. 

## Bandera

picoCTF{7R4N5P051N6_15_3XP3N51V3_109AB02E}

## Notas adicionales

| comando | descripcion |
| --- | --- |

## Referencias
