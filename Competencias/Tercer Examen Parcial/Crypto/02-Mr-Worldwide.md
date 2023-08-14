
# Mr-Worldwide

## Descripcion
A musician left us a [message](https://jupiter.challenges.picoctf.org/static/d5570d48262dbba2a31f2a940409ad9d/message.txt). What's it mean?
## Pistas

## Solucion
El archivo es de .txt y al realizar un cat nos da lo siguiente: 
```bash()
picoCTF{(35.028309, 135.753082)(46.469391, 30.740883)(39.758949, -84.191605)(41.015137, 28.979530)(24.466667, 54.366669)(3.140853, 101.693207)_(9.005401, 38.763611)(-3.989038, -79.203560)(52.377956, 4.897070)(41.085651, -73.858467)(57.790001, -152.407227)(31.205753, 29.924526)} 
```
Lo que parecen ser coordenadas. Al buscarlas en internet nos dan ciudades las cuales parece que la primera letra de cada una es nuestra bandera.  Las ubicaciones son: 
Kyoto, Japan
Odessa, Ukraine
Dayton, United States
Istanbul, Turkey
Abu Dhabi, UAE
Kuala Lumpur, Malaysia
Addis Ababa, Ethiopia
Loja, Ecuador
Amsterdam, Netherlands
Sleepy Hollow, USA
Kodiak, United States
Alexandria, Egypt

Lo cual nos da KODIAKALASKA
insertamos un guinbajo para el espacio y nos da la bandera. 

## Bandera

picoCTF{KODIAK_ALASKA}

## Notas adicionales

| comando | descripcion |
| --- | --- |

## Referencias
