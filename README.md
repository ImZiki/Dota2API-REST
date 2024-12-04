# Dota2API-REST
Trabajo de DAW para DWES
**Idea**
-
API REST que brinde informacion sobre heroes y objetos de Dota2

**Tablas**
-
**Tabla usuario**

Guarda la informacion basica de los usuarios.

***Atributos de la tabla***

**uid**

cifra numerica unica autogenerada por la base de datos

**username**

 Cadena de 50 caracteres maximo, no nulable, unica.

**password** 

cadena de 255 caracteres maximo, no nulable.

**rol**

Cadena de texto que puede contener los valores *USER* , *ADMIN*

El rol USER será el rol asignado por defecto a los usuarios que se registren.

El rol ADMIN será el unico rol con permiso para añadir, borrar y actualizar los Heroes y/o Objetos en la base de datos.

---
**Tabla Heroes**

Guarda informacion sobre los heroes de Dota2, tal como el nombre, las estadisticas base y una breve descripcion de la historia del mismo.

***Atributos de la tabla***

**uid**

cifra numerica unica autogenerada por la base de datos

**nombre_heroe**

Cadena de 100 caracteres maximo, no nulable, unica.

**inteligencia**

numero entero representando la estadistica inteligencia del heroe si tuviese. No nulable, no unico, valor minimo 0

**fuerza**

numero entero representando la estadistica fuerza del heroe si tuviese. No nulable, no unico, valor minimo 0

**agilidad** 

numero entero representando la estadistica inteligencia del heroe si tuviese. No nulable, no unico, valor minimo 0

**vida**

numero entero representando la estadistica vida del heroe si tuviese. No nulable, no unico

**mana**

numero entero representando la estadistica mana del heroe si tuviese. Nulable, no unico

**historia_heroe**

tipo *TEXT*. Contiene una breve descripcion de la historia del heroe del heroe no nulable.

---
**Tabla Objetos**

Guarda informacion sobre los heroes de Dota2, tal como el nombre, las estadisticas base y una breve descripcion de la historia del mismo.

***Atributos de la tabla***

**uid**

cifra numerica unica autogenerada por la base de datos

**nombre_objeto**

Cadena de 100 caracteres maximo, no nulable, unica.

**daño_fisico**

numero entero representando la cantidad de daño fisico que añade al heroe si tuviese. No nulable, no unico, valor minimo 5

**daño_magico**

numero entero representando la cantidad de daño magico que añade al heroe si tuviese. nulable, no unico, valor minimo 5

**vida_adicional** 

numero entero representando la cantidad de vida que otorga. nulable, no unico, valor minimo 50

**mana_adicional**

numero entero representando la cantidad de mana que otorga. nulable, no unico, valor minimo 50

**regeneracion_mana**

numero decimal, nulable que representa si el objeto proporciona regeneracion de mana o no valor minimo 0.5

**regeneracion_vida**

numero decimal, nulable que representa si el objeto proporciona regeneracion de vida o no valor minimo 0.5


**descripcion_objeto**

tipo *TEXT*. Contiene una breve descripcion del objeto.

---
**Tabla heroe_objeto**
Contiene la relacion de que heroes tienen algun objeto


**id_objeto**

numero entero que guarda la id del objeto

**id_heroe**

numero entero que guarda la id del heroe


**cantidad_objeto**

guarda en forma de numero entero la cantidad de veces que un heroe tiene un objeto concreto


---
**Relacion entre tablas**

Cada heroe puede tener varios objetos y varios objetos pueden estar en varios heroes al mismo tiempo y multiples veces.

---
**Diagrama E/R**
![Captura de pantalla 2024-12-04 210901](https://github.com/user-attachments/assets/accc1fba-01ec-4e71-a1f4-3e15b544cc65)
