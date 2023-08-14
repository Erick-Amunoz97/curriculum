
# Bit-O-Asm-3

## Descripcion
Can you figure out what is in the `eax` register? Put your answer in the picoCTF flag format: `picoCTF{n}` where `n` is the contents of the `eax` register in the decimal number base. If the answer was `0x11` your flag would be `picoCTF{17}`.Download the assembly dump [here](https://artifacts.picoctf.net/c/530/disassembler-dump0_c.txt).
## Pistas
Not everything in this disassembly listing is optimal.
## Solucion
Se nos da un dump en el cual tenemos que encontrar el valor de eax:
```bash

<+0>:     endbr64 
<+4>:     push   rbp
<+5>:     mov    rbp,rsp
<+8>:     mov    DWORD PTR [rbp-0x14],edi
<+11>:    mov    QWORD PTR [rbp-0x20],rsi
<+15>:    mov    DWORD PTR [rbp-0xc],0x9fe1a
<+22>:    mov    DWORD PTR [rbp-0x8],0x4
<+29>:    mov    eax,DWORD PTR [rbp-0xc]
<+32>:    imul   eax,DWORD PTR [rbp-0x8]
<+36>:    add    eax,0x1f5
<+41>:    mov    DWORD PTR [rbp-0x4],eax
<+44>:    mov    eax,DWORD PTR [rbp-0x4]
<+47>:    pop    rbp
<+48>:    ret
```
No hay un valor concreto para eax, por lo cual tenemos que buscar cuales variables si lo tienen :
```bash
<+15>:    mov    DWORD PTR [rbp-0xc],0x9fe1a
<+22>:    mov    DWORD PTR [rbp-0x8],0x4
```
Despues de esto a eax se le asigna el valor de `rbp-0xc` que es `0x9fe1a`

Continuando eax entra en la linea 32 donde es una instruccion imul o de multiplicacion por lo cual eax se multiplica con  el valor de `rbp-0x8` que es `0x4` Que seria `0x9fe1a` x `0x4` lo cual seria `0x027f868`

Finalmente en la linea 36 hay una instruccion de add donde se tiene que sumar eax con `0x1f5` lo cual nos da `0x27fa5d`

Todas estas sumas y la conversion final a entere se hicieron en python 
```python
>>> 0x4*0x9fe1a
2619496
>>> hex(2619496)
'0x27f868'
>>> 0x27f868+0x1f5
2619997
>>> hex(2619997)
'0x27fa5d'
```

## Bandera

picoCTF{2619997}

## Notas adicionales

| comando | descripcion |
| --- | --- |

## Referencias
