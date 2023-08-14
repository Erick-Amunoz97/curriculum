
# Vigenere

## Descripcion
Can you decrypt this message?Decrypt this [message](https://artifacts.picoctf.net/c/159/cipher.txt) using this key "CYLAB".
## Pistas
https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher
## Solucion
La pista nos dice que esta cifrado con un cipher vigener el cual vamos a usar para desencriptar el texto. 
```bash()
┌──(kali㉿kali)-[~/notas-hacking/PicoCTf/crypto/Vigenere]
└─$ cat cipher.txt            
rgnoDVD{O0NU_WQ3_G1G3O3T3_A1AH3S_f85729e7}
```
Usamos cyberchef con la llave proporcionada "CYLAB" nos da la bandera
## Bandera

picoCTF{D0NT_US3_V1G3N3R3_C1PH3R_d85729g7}

## Notas adicionales

| comando | descripcion |
| --- | --- |

## Referencias
