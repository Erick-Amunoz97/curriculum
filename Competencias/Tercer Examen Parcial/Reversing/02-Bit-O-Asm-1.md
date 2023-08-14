
# Bit-O-Asm-1

## Descripcion
Can you figure out what is in the `eax` register? Put your answer in the picoCTF flag format: `picoCTF{n}` where `n` is the contents of the `eax` register in the decimal number base. If the answer was `0x11` your flag would be `picoCTF{17}`.Download the assembly dump [here](https://artifacts.picoctf.net/c/509/disassembler-dump0_a.txt).
## Pistas
As with most assembly, there is a lot of noise in the instruction dump. Find the one line that pertains to this question and don't second guess yourself!
## Solucion
Se nos da un texto con el assembler dump:
```bash
┌──(kali㉿kali)-[~/notas-hacking/PicoCTf/reversing/BitOAsm1]
└─$ cat disassembler-dump0_a.txt 
<+0>:     endbr64 
<+4>:     push   rbp
<+5>:     mov    rbp,rsp
<+8>:     mov    DWORD PTR [rbp-0x4],edi
<+11>:    mov    QWORD PTR [rbp-0x10],rsi
<+15>:    mov    eax,0x30
<+20>:    pop    rbp
<+21>:    ret

```
estamos buscando el valor dentro de eax, y vemos que en la liena +15 el eax esta recibiendo un valor de 0x30. 
```python
┌──(kali㉿kali)-[~/notas-hacking/PicoCTf/reversing/BitOAsm1]
└─$ python3       
Python 3.11.2 (main, Mar 13 2023, 12:18:29) [GCC 12.2.0] on linux
Type "help", "copyright", "credits" or "license" for more information.
>>> int(0x30)
48

```

Al convertir esto a notacion decimal seria 48. Siendo esta la bandera
## Bandera

picoCTF{48}

## Notas adicionales

| comando | descripcion |
| --- | --- |

## Referencias
