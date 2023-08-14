#Proyecto Final Probabilidad y Estadistica
#Erick Arias Muñoz


#Examen 1
#Medidas de Tendencia Central y Dispersion.

#Ejemplo 1
datos = c(5,7,6,4,3,8,7)
mean(datos)
median(datos)
mode(datos)
range(datos)
max(datos)
min(datos)
max(datos)-min(datos)
var(datos)
sd(datos)
#coeficiente de variacion
sd(datos)/mean(datos)*100

#Ejemplo 2
datos = c(5,9,5,6,9,8,7)
mean(datos)
median(datos)
mode(datos)
range(datos)
max(datos)
min(datos)
max(datos)-min(datos)
var(datos)
sd(datos)
#coeficiente de variacion
sd(datos)/mean(datos)*100


#Examen 2 Medidas de Dispersion
#Ejemplo
library(moments)
datos= c(0.625,-0.375,-1.375,1.625,-0.375,-0.375,-0.375,0.625)
sd.p=function(datos){sd(datos)*sqrt((length(datos)-1)/length(datos))}
skewness(datos)
kurtosis(datos)
sd(datos)
sd.p(datos)


#Examen 3 Tablas de Correlacion
#Ejemplo:

LOC = c(121,30,27,520,220)
Hours = c(2.2,0.5,0.9,6,5)
mean(LOC)
mean(Hours)
sd(LOC)
sd(Hours)
cor(LOC,Hours)
boxplot(LOC,Hours)

#Examen 4 Regresion Lineal
#Ejemplo:
A = c(1.79,1.79,1.7,1.74,1.72,1.87,1.7,1.62,1.62,1.7)
B = c(81,63,80,70,54,85,78,56,70,67)
summary(A,B)
lm(A~B)
plot.default(A~B)

#Examen 5 y 6  Regresion Multiple
#Ejemplo: 

Facebook<- c(276.1,53.4,20.6,181.8)
Youtube<- c(45.4,47.2,55.1,49.6)
Ventas<- c(26.5,12.5,11.2,22.2)
model <- lm(Ventas ~ Facebook + Youtube)
summary(model)

#Examen 7 Densidad de Probabilidad
#Ejemplo:
x = c(300,335,489,120,66,98,452) #LOCS
y = c(9.8,8.9,12,4,1.8,3.2,13.2) #HOURS
par(mfrow = c(1, 1))
plot(density(x, bw = 100), lwd = 2,
     col = "red", main = "LOCS")
plot(density(y, bw = 100), lwd = 2,
     col = "red", main = "HOURS")


#Examen 8 Distribucion T
#Ejemplo:

# Generamos un vector de 100 valores entre -6 and 6
x <- seq(-6, 6, length = 100)

# Grados de libertad
df = c(1,4,10,30)
colour = c("red", "orange", "green", "yellow","black")

# Hacemos el plot de distribucion normal
plot(x, dnorm(x), type = "l", lty = 2, xlab = "t-value", ylab = "Density",
     main = "Comparison of t-distributions", col = "black")

# Agregamos la distribucion t al plot
for (i in 1:4){
  lines(x, dt(x, df[i]), col = colour[i])
}

# Agregamos la tabla de grados de libertad
legend("topright", c("df = 1", "df = 4", "df = 10", "df = 30", "normal"),
       col = colour, title = "t-distributions", lty = c(1,1,1,1,2))


#Examen 9 Naive Bayes:
teoremaBayes <- function(pA,pB,pBA){
  pAB <- pA*pBA/pB
  return(pAB)
}

pPasar <- 0.75
PExentar<- 0.2
PReprobrar<-0.4
teoremaBayes(pPasar,PExentar,PReprobrar)
