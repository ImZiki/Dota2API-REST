# Dota2API-REST
Trabajo de DAW para DWES

## **Nombre del proyecto**

Dota 2 API

## **Idea**

API REST que brinde informacion sobre heroes y objetos de Dota2


## **Justificacion del proyecto**

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
---
## **Endpoints de la API**
### 1. Endpoints para Héroes

### GET /dota2/heroes
Este endpoint devolvería una lista de todos los héroes en el sistema. Es útil para obtener un resumen de todos los héroes disponibles.

- **Método**: GET
- **Descripción**: Recupera la información básica de todos los héroes, como su nombre, estadísticas básicas y quizás una breve descripción de su historia.

### GET /dota2/heroes/{id}
Este endpoint proporcionaría detalles de un héroe específico, incluyendo su nombre, estadísticas (fuerza, agilidad, inteligencia, vida, mana) y una descripción completa de su historia.

- **Método**: GET
- **Descripción**: Devuelve toda la información sobre un héroe específico.
- **Parámetro**: id del héroe.

### **POST /dota2/heroes**

- **Método**: POST  
- **Descripción**: Crea un nuevo héroe en el sistema con los datos proporcionados en el cuerpo de la solicitud.  
- **Parámetros**:  
  - **Cuerpo**: Datos del héroe (nombre, estadísticas, historia, etc.).  


### **PUT /dota2/heroes/{id}**

- **Método**: PUT  
- **Descripción**: Actualiza los datos de un héroe específico identificado por su ID.  
- **Parámetros**:  
  - **URL**: `id` del héroe a actualizar.  
  - **Cuerpo**: Datos del héroe actualizados (nombre, estadísticas, historia, etc.).  



### **DELETE /dota2/heroes/{id}**

- **Método**: DELETE  
- **Descripción**: Elimina un héroe específico del sistema usando su ID.  
- **Parámetro**:  
  - **URL**: `id` del héroe a eliminar.  

---


### 2. Endpoints para Objetos

### GET /dota2/objetos
Este endpoint devolvería una lista de todos los objetos disponibles en el sistema.

- **Método**: GET
- **Descripción**: Recupera la información básica de todos los objetos disponibles en el juego (nombre, atributos como daño físico, mágico, vida, mana, etc.).

### GET /dota2/objetos/{id}
Este endpoint proporcionaría los detalles de un objeto específico, como su nombre, estadísticas y una breve descripción.

- **Método**: GET
- **Descripción**: Devuelve toda la información sobre un objeto específico.
- **Parámetro**: id del objeto.

### **PUT /dota2/objects/{id}**

- **Método**: PUT  
- **Descripción**: Actualiza los datos de un objeto específico identificado por su ID.  
- **Parámetros**:  
  - **URL**: `id` del objeto a actualizar.  
  - **Cuerpo**: Datos del objeto actualizados (nombre, atributos, descripción, etc.).  



### **DELETE /dota2/objects/{id}**

- **Método**: DELETE  
- **Descripción**: Elimina un objeto específico del sistema usando su ID.  
- **Parámetro**:  
  - **URL**: `id` del objeto a eliminar.
 
  ### **POST /dota2/objects**

- **Método**: POST  
- **Descripción**: Crea un nuevo objeto en el sistema con los datos proporcionados en el cuerpo de la solicitud.  
- **Parámetros**:  
  - **Cuerpo**: Datos del objeto (nombre, atributos, descripción, etc.).  

---

### 3. Endpoints para las Relaciones Heroe-Objeto

### GET /dota2/heroes/{id}/objetos
Este endpoint devolvería todos los objetos que un héroe específico posee, de acuerdo a la relación en la tabla heroe_objeto. Devolvería el nombre de los objetos y la cantidad que tiene el héroe.

- **Método**: GET
- **Descripción**: Devuelve una lista de objetos para un héroe específico, incluyendo la cantidad de cada objeto.
- **Parámetro**: id del héroe.

### GET /dota2/objetos/{id}/heroes
Este endpoint devolvería todos los héroes que tienen un objeto específico, y la cantidad que tienen de dicho objeto.

- **Método**: GET
- **Descripción**: Devuelve una lista de héroes que tienen un objeto específico, incluyendo la cantidad que poseen.
- **Parámetro**: id del objeto.

### **POST /dota2/heroes/{id}/objects**

- **Método**: POST  
- **Descripción**: Asigna un objeto a un héroe específico. Si el héroe ya posee el objeto, aumenta la cantidad en lugar de crear una nueva relación.  
- **Parámetros**:  
  - **URL**:  
    - `id`: ID del héroe al que se le asignará el objeto.  
  - **Cuerpo**:  
    - `objectId`: ID del objeto a asignar.  
    - `cantidad`: Cantidad del objeto a añadir.



### **PUT /dota2/heroes/{id}/objects/{objectId}**

- **Método**: PUT  
- **Descripción**: Actualiza la cantidad de un objeto asignado a un héroe.  
- **Parámetros**:  
  - **URL**:  
    - `id`: ID del héroe.  
    - `objectId`: ID del objeto asignado.  
  - **Cuerpo**:  
    - `cantidad`: Nueva cantidad del objeto asignado.  

### **DELETE /dota2/heroes/{id}/objects/{objectId}**

- **Método**: DELETE  
- **Descripción**: Elimina un objeto asignado a un héroe específico.  
- **Parámetros**:  
  - **URL**:  
    - `id`: ID del héroe.  
    - `objectId`: ID del objeto asignado.  


### **POST /dota2/objects/{id}/heroes**

- **Método**: POST  
- **Descripción**: Asigna un héroe a un objeto específico (relación inversa a la anterior).  
- **Parámetros**:  
  - **URL**:  
    - `id`: ID del objeto.  
  - **Cuerpo**:  
    - `heroId`: ID del héroe a asignar.  
    - `cantidad`: Cantidad asignada al héroe.  


### **PUT /dota2/objects/{id}/heroes/{heroId}**

- **Método**: PUT  
- **Descripción**: Actualiza la cantidad de un héroe relacionado con un objeto específico (relación inversa a la anterior).  
- **Parámetros**:  
  - **URL**:  
    - `id`: ID del objeto.  
    - `heroId`: ID del héroe asignado.  
  - **Cuerpo**:  
    - `cantidad`: Nueva cantidad asignada al héroe.  



### **DELETE /dota2/objects/{id}/heroes/{heroId}**

- **Método**: DELETE  
- **Descripción**: Elimina la relación entre un objeto y un héroe específico.  
- **Parámetros**:  
  - **URL**:  
    - `id`: ID del objeto.  
    - `heroId`: ID del héroe.  


