
# Bit-O-Asm-4

## Descripcion
Can you figure out what is in the `eax` register? Put your answer in the picoCTF flag format: `picoCTF{n}` where `n` is the contents of the `eax` register in the decimal number base. If the answer was `0x11` your flag would be `picoCTF{17}`.Download the assembly dump [here](https://artifacts.picoctf.net/c/511/disassembler-dump0_d.txt).
## Pistas
1. Don't tell anyone I told you this, but you can solve this problem without understanding the compare/jump relationship.
2. Of course, if you're really good, you'll only need one attempt to solve this problem.
## Solucion

```bash()
<+0>:     endbr64 
<+4>:     push   rbp
<+5>:     mov    rbp,rsp
<+8>:     mov    DWORD PTR [rbp-0x14],edi
<+11>:    mov    QWORD PTR [rbp-0x20],rsi
<+15>:    mov    DWORD PTR [rbp-0x4],0x9fe1a
<+22>:    cmp    DWORD PTR [rbp-0x4],0x2710
<+29>:    jle    0x55555555514e <main+37>
<+31>:    sub    DWORD PTR [rbp-0x4],0x65
<+35>:    jmp    0x555555555152 <main+41>
<+37>:    add    DWORD PTR [rbp-0x4],0x65
<+41>:    mov    eax,DWORD PTR [rbp-0x4]
<+44>:    pop    rbp
<+45>:    ret

```

La unica variable que tiene un valor es la de `rbp-0x4` la cual tiene valor de `0x9fe1a`.

En la linea 22 hay una comparacion entre el valor de `rbp-0x4` y `0x2710` el cual es falso ya que no es menor igual  entonces nos saltamos la la linea 29 y nos vamos directo a la 35. 

En la linea 35 se le resta `0x65` al valor de `rbp-0x4` que es `0x9fe1a` . Al restarlos tiene un total de `0x9fdb5`

Al convertirlo en entero nos da la bandera. 

```pyton 
┌──(kali㉿kali)-[~/notas-hacking/PicoCTf/reversing/BitOAsm4]
└─$ python3
Python 3.11.2 (main, Mar 13 2023, 12:18:29) [GCC 12.2.0] on linux
Type "help", "copyright", "credits" or "license" for more information.
>>> 0x9fe1a<=0x2710
false
>>> 0x9fe1a-0x65
654773
>>> hex(654773)
'0x9fdb5'


```

## Bandera

picoCTF{654773}

## Notas adicionales

| comando | descripcion |
| --- | --- |

## Referencias
