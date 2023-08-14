
# SRA

## Descripcion
I just recently learnt about the SRA public key cryptosystem... or wait, was it supposed to be RSA? Hmmm, I should probably check...

Connect to the program on our server: `nc saturn.picoctf.net 61570`Download the program: [chal.py](https://artifacts.picoctf.net/c/298/chal.py)
## Pistas

## Solucion
Se nos da un codigo: 
```bash()
┌──(kali㉿kali)-[~/picoCTF-Practice/cryptography/SRA]
└─$ ls
chal.py
                                                                                                                                                 
┌──(kali㉿kali)-[~/picoCTF-Practice/cryptography/SRA]
└─$ cat chal.py   
from Crypto.Util.number import getPrime, inverse, bytes_to_long
from string import ascii_letters, digits
from random import choice

pride = "".join(choice(ascii_letters + digits) for _ in range(16))
gluttony = getPrime(128)
greed = getPrime(128)
lust = gluttony * greed
sloth = 65537
envy = inverse(sloth, (gluttony - 1) * (greed - 1))

anger = pow(bytes_to_long(pride.encode()), sloth, lust)

print(f"{anger = }")
print(f"{envy = }")

print("vainglory?")
vainglory = input("> ").strip()

if vainglory == pride:
    print("Conquered!")
    with open("/challenge/flag.txt") as f:
        print(f.read())
else:
    print("Hubris!")
                                                                                                                                                 
┌──(kali㉿kali)-[~/picoCTF-Practice/cryptography/SRA]
└─$
```

el cual con a ayuda del siguiente codigo hallamos la bandera: 

```python
from sage.all import *
from pwn import *
from gmpy2 import is_prime
from string import ascii_letters, digits
from Crypto.Util.number import bytes_to_long, long_to_bytes, inverse

r = remote('saturn.picoctf.net', 53361)

def is_printable(text):
    alphabet = ascii_letters + digits
    for i in text:
        if i not in alphabet:
            return False
    return True

e = 65537
r.recvuntil(b'anger = ')
c = int(r.recvline().strip().decode())
r.recvuntil(b'envy = ')
d = int(r.recvline().strip().decode())
r.recvline()
print(c)
print(d)

K = divisors(d*e - 1)
print("Done")

list_prime = []
for k in K:
    pp = ((d*e - 1)//k) + 1

    if is_prime(pp) and int(pp).bit_length() == 128:
        list_prime.append(pp)

list_text = []
for p in list_prime:
    for q in list_prime:
        try:
            if inverse(e, (p - 1) * (q - 1)) == d:
                n = p*q
                list_text.append(long_to_bytes(int(pow(c, d, n))))
        except:
            pass


list_text = set(list_text)

for text in list_text:
    try:
        text = text.decode()
        if is_printable(text):
            print(text)
            r.recvuntil(b'> ')
            r.sendline(text.encode())
            print(r.recvline())
            print(r.recvline())
            print(r.recvline())
            break
    except:
        continue
r.close()

```
lo conectamos al servidor y nos da la bandera
```bash()
┌──(kali㉿kali)-[~/notas-hacking/PicoCTf/crypto/SRA]
└─$ python3 exp.py
[+] Opening connection to saturn.picoctf.net on port 58715: Done
12393896417896283356229647584791705625405436245755374020576642304420723719700
2235094049036125470697351232979118901017755448717439468667892011015978033953
Done
MXCPLJhGi8BGHZk0
b'MXCPLJhGi8BGHZk0\r\n'
b'Conquered!\r\n'
b'picoCTF{7h053_51n5_4r3_n0_m0r3_b2f9b414}\r\n'
[*] Closed connection to saturn.picoctf.net port 58715

```
## Bandera

picoCTF{7h053_51n5_4r3_n0_m0r3_b2f9b414}

## Notas adicionales

| comando | descripcion |
| --- | --- |

## Referencias
