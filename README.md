# Dota2API-REST
Trabajo de DAW para DWES

## **Nombre del proyecto**
-
Dota 2 API

## **Idea**
-
API REST que brinde informacion sobre heroes y objetos de Dota2


## **Justificacion del proyecto**
-
Esta API sería una herramienta util a la hora de construir paginas web como Dotabuff.com que se nutren de APIs REST de Dota 2 para mostrar informacion de jugadores, partidas, heroes y objetos aparte de noticias de interés en el mundillo de Dota.


# Tablas y Descripciones
## **Tabla Usuario**
Esta tabla representa a los usuarios de la API que podrán hacer uso de los diferentes endpoints en función de su rol. Define los permisos y credenciales básicos necesarios para interactuar con el sistema.

### **Atributos**
- **uid**  
  - Tipo: `INTEGER`  
  - Descripción: Identificador único generado automáticamente por la base de datos. Clave primaria.  

- **username**  
  - Tipo: `VARCHAR(50)`  
  - Descripción: Nombre único de usuario. Campo obligatorio y no nulo.  

- **password**  
  - Tipo: `VARCHAR(255)`  
  - Descripción: Contraseña hasheada del usuario. Campo obligatorio y no nulo.  

- **rol**  
  - Tipo: `VARCHAR`  
  - Descripción: Rol del usuario. Puede contener los valores:  
    - **USER**: Rol por defecto asignado a los usuarios que se registran.  
    - **ADMIN**: Rol especial con permisos para añadir, borrar y actualizar héroes y objetos en la base de datos.  
  - Campo obligatorio.  

---
## **Tabla Héroes**
Guarda información sobre los héroes del videojuego Dota 2. Cada héroe tiene características base que definen su desempeño en el juego, como estadísticas y trasfondo narrativo.

### **Atributos**
- **uid**  
  - Tipo: `INTEGER`  
  - Descripción: Identificador único generado automáticamente por la base de datos. Clave primaria.  

- **nombre_heroe**  
  - Tipo: `VARCHAR(100)`  
  - Descripción: Nombre único del héroe. Campo obligatorio y no nulo.  

- **inteligencia**  
  - Tipo: `INTEGER`  
  - Descripción: Estadística de inteligencia del héroe. Campo obligatorio con un valor mínimo de `0`.  

- **fuerza**  
  - Tipo: `INTEGER`  
  - Descripción: Estadística de fuerza del héroe. Campo obligatorio con un valor mínimo de `0`.  

- **agilidad**  
  - Tipo: `INTEGER`  
  - Descripción: Estadística de agilidad del héroe. Campo obligatorio con un valor mínimo de `0`.  

- **vida**  
  - Tipo: `INTEGER`  
  - Descripción: Vida base del héroe. Campo obligatorio.  

- **mana**  
  - Tipo: `INTEGER`  
  - Descripción: Cantidad de maná base del héroe. Puede ser nulo.  

- **historia_heroe**  
  - Tipo: `TEXT`  
  - Descripción: Breve descripción narrativa sobre el héroe. Campo obligatorio.  

---

## **Tabla Objetos**
Guarda información sobre los objetos que los héroes pueden usar para mejorar sus habilidades y estadísticas en el juego.

### **Atributos**
- **uid**  
  - Tipo: `INTEGER`  
  - Descripción: Identificador único generado automáticamente por la base de datos. Clave primaria.  

- **nombre_objeto**  
  - Tipo: `VARCHAR(100)`  
  - Descripción: Nombre único del objeto. Campo obligatorio y no nulo.  

- **daño_fisico**  
  - Tipo: `INTEGER`  
  - Descripción: Daño físico adicional que proporciona el objeto. Campo obligatorio con un valor mínimo de `5`.  

- **daño_magico**  
  - Tipo: `INTEGER`  
  - Descripción: Daño mágico adicional que proporciona el objeto. Campo opcional, pero si tiene valor, debe ser al menos `5`.  

- **vida_adicional**  
  - Tipo: `INTEGER`  
  - Descripción: Vida adicional que otorga el objeto. Campo opcional, pero si tiene valor, debe ser al menos `50`.  

- **mana_adicional**  
  - Tipo: `INTEGER`  
  - Descripción: Maná adicional que otorga el objeto. Campo opcional, pero si tiene valor, debe ser al menos `50`.  

- **regeneracion_mana**  
  - Tipo: `DECIMAL`  
  - Descripción: Tasa de regeneración de maná proporcionada por el objeto. Campo opcional, pero si tiene valor, debe ser al menos `0.5`.  

- **regeneracion_vida**  
  - Tipo: `DECIMAL`  
  - Descripción: Tasa de regeneración de vida proporcionada por el objeto. Campo opcional, pero si tiene valor, debe ser al menos `0.5`.  

- **descripcion_objeto**  
  - Tipo: `TEXT`  
  - Descripción: Descripción narrativa sobre el objeto. Campo opcional.  

---

## **Tabla Héroe-Objeto**
Define la relación entre los héroes y los objetos, representando un vínculo *muchos a muchos*.

### **Atributos**
- **id_objeto**  
  - Tipo: `INTEGER`  
  - Descripción: Identificador del objeto, clave foránea que enlaza con `uid` de la tabla **Objetos**.  

- **id_heroe**  
  - Tipo: `INTEGER`  
  - Descripción: Identificador del héroe, clave foránea que enlaza con `uid` de la tabla **Héroes**.  

- **cantidad_objeto**  
  - Tipo: `INTEGER`  
  - Descripción: Cantidad de veces que un héroe posee un objeto específico.  

---

---
**Relacion entre tablas**

Cada heroe puede tener varios objetos y varios objetos pueden estar en varios heroes al mismo tiempo y multiples veces.

---
**Diagrama E/R**
![Captura de pantalla 2024-12-04 210901](https://github.com/user-attachments/assets/accc1fba-01ec-4e71-a1f4-3e15b544cc65)
