
# Bit-O-Asm-2

## Descripcion
Can you figure out what is in the `eax` register? Put your answer in the picoCTF flag format: `picoCTF{n}` where `n` is the contents of the `eax` register in the decimal number base. If the answer was `0x11` your flag would be `picoCTF{17}`.Download the assembly dump [here](https://artifacts.picoctf.net/c/510/disassembler-dump0_b.txt).
## Pistas
`PTR`'s or 'pointers', reference a location in memory where values can be stored.
## Solucion
Se nos da un dump:
```bash()
┌──(kali㉿kali)-[~/notas-hacking/PicoCTf/reversing/BitOAsm2]
└─$ cat disassembler-dump0_b.txt 
<+0>:     endbr64 
<+4>:     push   rbp
<+5>:     mov    rbp,rsp
<+8>:     mov    DWORD PTR [rbp-0x14],edi
<+11>:    mov    QWORD PTR [rbp-0x20],rsi
<+15>:    mov    DWORD PTR [rbp-0x4],0x9fe1a
<+22>:    mov    eax,DWORD PTR [rbp-0x4]
<+25>:    pop    rbp
<+26>:    ret

```
Al buscar el valor de eax da que es rbp-0x4 pero dice en la linea anterior que el resultado de estos es 0x9fe1a. 

```python
┌──(kali㉿kali)-[~/notas-hacking/PicoCTf/reversing/BitOAsm2]
└─$ python3
Python 3.11.2 (main, Mar 13 2023, 12:18:29) [GCC 12.2.0] on linux
Type "help", "copyright", "credits" or "license" for more information.
>>> int(0x9fe1a)
654874
>>> 

```

tomamos este y lo convertimos a un entero lo cual nos  da la bandera.
## Bandera

picoCTF{654874}

## Notas adicionales

| comando | descripcion |
| --- | --- |

## Referencias
