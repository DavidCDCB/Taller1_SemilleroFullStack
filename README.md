## Taller 1 aplicación java

1)	Construir una clase Factura que descienda de la clase Precio y que incluya dos atributos específicos llamados emisor y cliente y, al menos, un método llamado imprimirFactura.

2)	Desarrollar un programa que modele una cuenta bancaria que tiene los
siguientes atributos, que deben ser de acceso protegido:

- Saldo, de tipo float.
- Número de consignaciones con valor inicial cero, de tipo int.
- Número de retiros con valor inicial cero, de tipo int.
- Tasa anual (porcentaje), de tipo float.
- Comisión mensual con valor inicial cero, de tipo float.

La clase Cuenta tiene un constructor que inicializa los atributos saldo
y tasa anual con valores pasados como parámetros. La clase Cuenta tiene
los siguientes métodos:

- Consignar una cantidad de dinero en la cuenta actualizando su saldo.
- Retirar una cantidad de dinero en la cuenta actualizando su saldo.
- El valor a retirar no debe superar el saldo.
- Calcular el interés mensual de la cuenta y actualiza el saldo correspondiente.
- Extracto mensual: actualiza el saldo restándole la comisión mensual y calculando el interés mensual correspondiente (invoca el método anterior).
- Imprimir: muestra en pantalla los valores de los atributos.
- La clase Cuenta tiene dos clases hijas:

Cuenta de ahorros: posee un atributo para determinar si la cuenta
de ahorros está activa (tipo boolean). Si el saldo es menor a $10000,
la cuenta está inactiva, en caso contrario se considera activa. Los
siguientes métodos se redefinen:

- Consignar: se puede consignar dinero si la cuenta está activa.
Debe invocar al método heredado.
- Retirar: es posible retirar dinero si la cuenta está activa. Debe
invocar al método heredado.
- Extracto mensual: si el número de retiros es mayor que 4, por
cada retiro adicional, se cobra $1000 como comisión mensual.
Al generar el extracto, se determina si la cuenta está activa o no
con el saldo.
- Un nuevo método imprimir que muestra en pantalla el saldo
de la cuenta, la comisión mensual y el número de transacciones
realizadas (suma de cantidad de consignaciones y retiros).
Cuenta corriente: posee un atributo de sobregiro, el cual se inicializa en cero. Se redefinen los siguientes métodos:
- Retirar: se retira dinero de la cuenta actualizando su saldo. Se puede retirar dinero superior al saldo. El dinero que se debe queda
como sobregiro.
- Consignar: invoca al método heredado. Si hay sobregiro, la
cantidad consignada reduce el sobregiro.
- Extracto mensual: invoca al método heredado.
- Un nuevo método imprimir que muestra en pantalla el saldo
de la cuenta, la comisión mensual, el número de transacciones
realizadas (suma de cantidad de consignaciones y retiros) y el
valor de sobregiro.

Realizar un método main que implemente un objeto Cuenta de ahorros y llame a los métodos correspondientes.

3) Se requiere realizar un programa que modele diferentes tipos de inmuebles.
Cada inmueble tiene los siguientes atributos: identificador inmobiliario (tipo
entero); área en metros cuadrados (tipo entero) y dirección (tipo String).

Los inmuebles para vivienda pueden ser casas o apartamentos. Los inmuebles para vivienda tienen los siguientes atributos: número de habitaciones y número de baños.

## Taller 2 Exepciones

Se requiere definir una clase denominada CálculosNúmericos que realice las siguientes
operaciones
Calcular la raíz cuadrada recibiendo un valor double como parámetro. Este método
debe ser estático. Si el valor no es positivo se
genera una excepción aritmética.
Calcular la pendiente de una recta.
Calcular el punto medio de una recta.
Calcular las raíces de una ecuación cuadrática.
Convertir un número en base 10 a un número en base b.
Las casas pueden ser casas rurales o casas urbanas, su atributo es la cantidad de pisos que poseen.
Los atributos de las casas rurales son la distancia a la cabecera municipal y la altitud sobre el nivel del mar.
Las casas urbanas pueden estar en un conjunto cerrado o ser independientes. A su vez, las casas en conjunto cerrado tienen como atributo el valor de
la administración y si incluyen o no áreas comunes como piscinas y campos deportivos.

De otro lado, los apartamentos pueden ser apartaestudios
o apartamentos familiares. Los apartamentos pagan un valor de administración, mientras que los aparta estudios tienen una sola habitación.

Los locales se clasifican en locales comerciales y oficinas. Los locales
tienen como atributo su localización (si es interno o da a la calle). Los locales comerciales tienen un atributo para conocer el centro comercial donde
están establecidos. Las oficinas tienen como atributo un valor boolean para
determinar si son del Gobierno.

Cada inmueble tiene un valor de compra.
Este depende del área de cada inmueble según la tabla.

## Taller 3 Clases abstractas e interfaces

1. Usted debe escribir un método que calcula el valor que debe pagar una persona por
boletas de cine, lo cual depende de la cantidad de boletas que lleva. Si dentro del método
encuentra que la cantidad de boletas no está dentro de los rangos establecidos, ¿debería
lanzar una excepción o retornar cero? Explique brevemente su respuesta.

2. Usted debe escribir un método que consulta las materias que tiene inscritas un estudiante, a partir del código del estudiante. Si el estudiante no tiene materias inscritas, ¿debería lanzar una excepción o retornar null? Explique brevemente su respuesta.

3. Se desea crear un reproductor de Música, se tienen los formatos mp3 y wav. Ambos
tienen como atributos la duración (minutos: segundos), tamaño, artista, compositor y
genero musical. Ambos se reproducen de manera diferente.

- a. Para una implementación en código, ¿usaría una clase abstracta o una interfaz?
¿Por qué? Desarrolle en Java una posible solución.

- b. Si se decidiera agregar un formato de video en mp4, donde solo se quiere
reproducir su audio, y a diferencia de mp3 y wav este no posee artista, compositor
y género musical, sino creador y tipo de video. ¿Implementaría clase abstracta o
interfaz? ¿Por qué? ¿Como quedaría en código añadiendo el formato de video?

- c. Si cada vez se quiere añadir un nuevo formato diferente en el reproductor, el
código implementado por usted es capaz de adaptarse fácilmente. Para
referencias consultar sobre escalabilidad en programación.

4. Se requiere crear un Software para un banco, este maneja diferentes tipos de cuentas,
Ahorro y Corriente, tienen como atributos el numero de cuenta, saldo, y un propietario. Se
pueden realizar acciones como depositar y retirar.

Al momento de retirar dinero, en la cuenta de ahorros, deberá restar el monto solicitado, y si realiza más de 3 retiros, deberá
de restar un 1% del valor que retira, es decir si pide retirar un valor de 3000 unidades debe
sacar un 1% que son 30 unidades, y restar un total de 3030 unidades si se cumple que se
hacen más de 3 retiros. 

Para una cuenta corriente, no debe permitir realizar más de 5
retiros, además, al depositar en una cuenta de ahorros, se adicionará un 0.5% del valor
depositado en el saldo para sus 2 primeros depósitos. Implemente una solución en Java,
con clases abstractas o interfaces, y realice las validaciones correspondientes con el uso de
excepciones propias.

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
