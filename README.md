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

### **PUT /dota2/objetos/{id}**

- **Método**: PUT  
- **Descripción**: Actualiza los datos de un objeto específico identificado por su ID.  
- **Parámetros**:  
  - **URL**: `id` del objeto a actualizar.  
  - **Cuerpo**: Datos del objeto actualizados (nombre, atributos, descripción, etc.).  



### **DELETE /dota2/objetos/{id}**

- **Método**: DELETE  
- **Descripción**: Elimina un objeto específico del sistema usando su ID.  
- **Parámetro**:  
  - **URL**: `id` del objeto a eliminar.
 
  ### **POST /dota2/objetos**

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

### **POST /dota2/heroes/{id}/objetos**

- **Método**: POST  
- **Descripción**: Asigna un objeto a un héroe específico. Si el héroe ya posee el objeto, aumenta la cantidad en lugar de crear una nueva relación.  
- **Parámetros**:  
  - **URL**:  
    - `id`: ID del héroe al que se le asignará el objeto.  
  - **Cuerpo**:  
    - `objectId`: ID del objeto a asignar.  
    - `cantidad`: Cantidad del objeto a añadir.



### **PUT /dota2/heroes/{id}/objetos/{objetoId}**

- **Método**: PUT  
- **Descripción**: Actualiza la cantidad de un objeto asignado a un héroe.  
- **Parámetros**:  
  - **URL**:  
    - `id`: ID del héroe.  
    - `objectId`: ID del objeto asignado.  
  - **Cuerpo**:  
    - `cantidad`: Nueva cantidad del objeto asignado.  

### **DELETE /dota2/heroes/{id}/objetos/{objetoId}**

- **Método**: DELETE  
- **Descripción**: Elimina un objeto asignado a un héroe específico.  
- **Parámetros**:  
  - **URL**:  
    - `id`: ID del héroe.  
    - `objectId`: ID del objeto asignado.  


### **POST /dota2/objetos/{id}/heroes**

- **Método**: POST  
- **Descripción**: Asigna un héroe a un objeto específico (relación inversa a la anterior).  
- **Parámetros**:  
  - **URL**:  
    - `id`: ID del objeto.  
  - **Cuerpo**:  
    - `heroId`: ID del héroe a asignar.  
    - `cantidad`: Cantidad asignada al héroe.  


### **PUT /dota2/objetos/{id}/heroes/{heroeId}**

- **Método**: PUT  
- **Descripción**: Actualiza la cantidad de un héroe relacionado con un objeto específico (relación inversa a la anterior).  
- **Parámetros**:  
  - **URL**:  
    - `id`: ID del objeto.  
    - `heroId`: ID del héroe asignado.  
  - **Cuerpo**:  
    - `cantidad`: Nueva cantidad asignada al héroe.  



### **DELETE /dota2/objetos/{id}/heroes/{heroeId}**

- **Método**: DELETE  
- **Descripción**: Elimina la relación entre un objeto y un héroe específico.  
- **Parámetros**:  
  - **URL**:  
    - `id`: ID del objeto.  
    - `heroId`: ID del héroe.  

## **Securización de los Endpoints**

### **Endpoints públicos (accesibles por `ROLE_USER`):**

Estos endpoints permiten a los usuarios autenticados con el rol `USER` acceder a información básica sobre héroes, objetos y sus relaciones, pero no permiten realizar modificaciones.

1. **GET /dota2/heroes**  
   - **Descripción**: Devuelve una lista de todos los héroes disponibles en el sistema con sus detalles básicos.  
   - **Uso**: Navegar por todos los héroes en una interfaz pública.

2. **GET /dota2/heroes/{id}**  
   - **Descripción**: Devuelve los detalles completos de un héroe específico, como sus estadísticas y su historia.  
   - **Uso**: Consultar información detallada de un héroe específico.

3. **GET /dota2/objetos**  
   - **Descripción**: Devuelve una lista de todos los objetos disponibles en el sistema con sus detalles básicos.  
   - **Uso**: Mostrar todos los objetos disponibles para los jugadores.

4. **GET /dota2/objetos/{id}**  
   - **Descripción**: Devuelve los detalles completos de un objeto específico, como sus atributos y su descripción.  
   - **Uso**: Consultar información detallada de un objeto específico.

5. **GET /dota2/heroes/{id}/objetos**  
   - **Descripción**: Devuelve la lista de objetos que posee un héroe específico, incluyendo las cantidades.  
   - **Uso**: Mostrar qué equipo tiene un héroe en particular.

6. **GET /dota2/objetos/{id}/heroes**  
   - **Descripción**: Devuelve una lista de héroes que poseen un objeto específico, incluyendo las cantidades.  
   - **Uso**: Mostrar qué héroes están utilizando un objeto en particular.

---

### **Endpoints protegidos (accesibles solo por `ROLE_ADMIN`):**

Estos endpoints están limitados a usuarios con el rol `ADMIN` porque implican la creación, actualización y eliminación de recursos. Se utilizan para tareas administrativas y gestión de datos.

1. **POST /dota2/heroes**  
   - **Descripción**: Permite a los administradores agregar un nuevo héroe al sistema.  
   - **Uso**: Añadir nuevos héroes al catálogo.

2. **PUT /dota2/heroes/{id}**  
   - **Descripción**: Permite actualizar la información de un héroe existente, como sus estadísticas o historia.  
   - **Uso**: Modificar datos de héroes según cambios en el juego.

3. **DELETE /dota2/heroes/{id}**  
   - **Descripción**: Elimina un héroe específico del sistema.  
   - **Uso**: Limpiar datos obsoletos o eliminar héroes no deseados.

4. **POST /dota2/objetos**  
   - **Descripción**: Permite a los administradores agregar un nuevo objeto al sistema.  
   - **Uso**: Añadir nuevos objetos al inventario del juego.

5. **PUT /dota2/objetos/{id}**  
   - **Descripción**: Permite actualizar la información de un objeto existente, como sus atributos o descripción.  
   - **Uso**: Modificar datos de objetos según actualizaciones del juego.

6. **DELETE /dota2/objetos/{id}**  
   - **Descripción**: Elimina un objeto específico del sistema.  
   - **Uso**: Limpiar datos obsoletos o eliminar objetos no utilizados.

---
## **Logica de negocio:**
### **1. Lógica de negocio para Héroes**

#### **a) Validación de datos de héroe**
-  Comprobación de que el nombre del héroe sea único antes de crear uno nuevo para evitar duplicidades
-  Las estadísticas de un héroe (fuerza, agilidad, inteligencia, vida, mana) deben estar dentro de un rango esperado para evitar valores inconsistentes, como valores negativos o extremadamente altos.
-  Verificar que el campo historia de cada heroe no esté vacío ni exceda un limite de caracteres.

#### **b) Creación de héroes**
- Cuando un administrador agregue un nuevo héroe, se debe verificar que todos los atributos del héroe sean válidos y completos. Si falta alguna información esencial (por ejemplo, nombre o estadísticas), se lanzará una excecpcion.
- Los héroes deben ser agregados a la base de datos, asociándolos correctamente con las estadísticas correspondientes y la historia.

#### **c) Actualización de héroes**
- Al actualizar un héroe, es necesario verificar que el héroe con el `id` proporcionado existe en la base de datos.
- Si el nombre o cualquier otra propiedad es modificada, se validarán las nuevas estadísticas y la unicidad de la información si asi se requiere.

#### **d) Eliminación de héroes**
- Al eliminar un héroe, se debe revisar si existen objetos con relaciones activas. Se eliminará cualquier relación dependiente antes de proceder con la eliminación del héroe para evitar inconsistencias.

---

### **2. Lógica de negocio para Objetos**

#### **a) Validación de objetos**
- Los nombres de los objetos deben ser únicos, por lo que, al agregar o actualizar un objeto, se debe verificar que el nombre no esté duplicado.
- Comprobación de los valores de los atributos como daño físico, daño mágico, vida adicional, mana adicional, etc., sean coherentes y estén dentro de los límites establecidos. Por ejemplo, los valores no deben ser negativos.
- Los atributos de un objeto pueden ser opcionales (por ejemplo, regeneración de mana), por lo que es necesario verificar que solo se incluyan aquellos que realmente tienen valores.

#### **b) Creación de objetos**
- Al crear un objeto, se debe validar que todos los parámetros sean correctos y que el objeto no exista ya en el sistema.
- Si el objeto contiene valores como daño físico o regeneración de vida, estos deben ser razonables (por ejemplo, un daño físico inferior o igual a un valor máximo predefinido).

#### **c) Actualización de objetos**
- La actualización de un objeto debe comprobar si el objeto ya existe y si el nuevo estado es válido (por ejemplo, nuevos valores de daño o vida).

#### **d) Eliminación de objetos**
- Al eliminar un objeto, se debe asegurar que no esté en uso por ningún héroe en el sistema, o bien, manejar correctamente las relaciones con la tabla de **heroe_objeto** para evitar que un héroe mantenga una referencia a un objeto inexistente.

---

### **3. Lógica de negocio para la relación Héroe-Objeto**

#### **a) Comprobación de relaciones existentes**
- Cuando un héroe recibe un objeto, se debe verificar si ese héroe ya tiene ese objeto. Si es así, la cantidad del objeto debe actualizarse, en lugar de duplicar la entrada en la tabla de relaciones.

#### **b) Creación de relaciones**
- Si un héroe aún no tiene un objeto asignado, debe crearse una nueva relación en la tabla **heroe_objeto**.
- La cantidad del objeto asignado debe ser controlada para evitar que un héroe tenga más de la cantidad permitida.

#### **c) Eliminación de relaciones**
- Al eliminar un objeto o héroe, la lógica debe asegurarse de que las relaciones asociadas a ese objeto o héroe se eliminen o actualicen de manera adecuada.
---
## **Excepciones**


### **1. HeroNotFoundException**
- **Descripción**: Esta excepción se lanzaría cuando se intenta acceder a un héroe que no existe en la base de datos, como por ejemplo al realizar un GET a `/dota2/heroes/{id}` con un ID que no corresponde a ningún héroe.
- **Razón**: Es fundamental tener una respuesta clara cuando un recurso solicitado no se encuentra. Devolvería un mensaje claro como "El héroe no fue encontrado" y su codigo de respuesta.
- **Uso**: Cuando no se encuentra un héroe específico por su ID.
- **Código de estado**: 404 Not Found


### **2. ObjectNotFoundException**
- **Descripción**: Similar a HeroNotFoundException, esta excepción se lanzaría cuando un objeto solicitado no se encuentra en la base de datos.
- **Razón**: Para la coherencia de los errores en la API, un GET a `/dota2/objetos/{id}` debe devolver un error adecuado si no existe un objeto con el ID proporcionado. Se devolvera un mensaje claro como "Objeto no encontrado" y su codigo de respuesta.
- **Uso**: Cuando no se encuentra un objeto específico por su ID.
- **Código de estado**: 404 Not Found


### **3. InvalidHeroDataException**
- **Descripción**: Esta excepción se lanzaría cuando los datos proporcionados para crear o actualizar un héroe no sean válidos. Esto podría ocurrir si un héroe tiene valores de estadísticas fuera de un rango permitido o si falta un campo obligatorio.
- **Razón**: Para validar los datos de entrada antes de intentar realizar una operación, garantizando que el héroe tiene valores válidos. Se devuelve un mensaje detallado sobre los datos incorrectos.
- **Uso**: Al crear o actualizar un héroe con datos inválidos.
- **Código de estado**: 400 Bad Request



### **4. InvalidObjectDataException**
- **Descripción**: Similar a la anterior, esta excepción se lanzaría cuando los datos proporcionados para crear o actualizar un objeto no son válidos.
- **Razón**: Es crucial validar los datos de los objetos antes de permitir su creación o actualización en la base de datos. El servicio debe asegurarse de que los valores como daño, vida, mana, etc., sean correctos y estén dentro de un rango lógico.
- **Uso**: Al crear o actualizar un objeto con datos inválidos.
- **Código de estado**: 400 Bad Request




### **5. UnauthorizedActionException**
- **Descripción**: Esta excepción se lanzaría cuando un usuario intenta realizar una acción para la cual no tiene permisos, como un usuario con rol de USER intentando crear o eliminar héroes y objetos.
- **Razón**: Para proteger los endpoints y asegurarse de que solo los administradores (ROLE_ADMIN) puedan realizar acciones sensibles (como eliminar o agregar héroes y objetos). Devolverrá un mensaje explicando que el usuario no tiene permisos.
- **Uso**: Cuando un usuario no autorizado intenta realizar una operación restringida.
- **Código de estado**: 403 Forbidden



### **6. InvalidTokenException**
- **Descripción**: Esta excepción se lanzaría cuando el token de autenticación proporcionado es inválido o ha expirado.
- **Razón**: Para manejar situaciones en las que el token JWT proporcionado no es válido o ha caducado. Esto aseguraría que las peticiones autenticadas sean correctas.
- **Uso**: Cuando un token de autenticación no es válido o ha expirado.
- **Código de estado**: 401 Unauthorized



### **7. ResourceAlreadyExistsException**
- **Descripción**: Se lanzaría cuando intentas crear un héroe u objeto que ya existe en la base de datos (basado en un campo único como el nombre_heroe o nombre_objeto).
- **Razón**: Para evitar la duplicación de héroes u objetos en la base de datos. Devolverá un mensaje indicando que el recurso ya existe.
- **Uso**: Al intentar crear un héroe u objeto con un nombre que ya existe.
- **Código de estado**: 409 Conflict



### **8. InsufficientDataException**
- **Descripción**: Esta excepción se lanzaría cuando los datos necesarios para una operación (como la creación o actualización de héroes/objetos) no se proporcionan completamente.
- **Razón**: Para garantizar que las operaciones siempre tengan los datos requeridos. Devolverá un mensaje con detalles sobre los campos faltantes.
- **Uso**: Cuando no se proporcionan todos los datos necesarios para crear o actualizar un héroe u objeto.
- **Código de estado**: 400 Bad Request



### **9. InternalServerErrorException**
- **Descripción**: Esta excepción es más genérica y se lanzaría cuando algo inesperado sucede en el servidor, como un fallo de base de datos o un error no controlado.
- **Razón**: Para capturar cualquier error inesperado y devolver una respuesta coherente al cliente.
- **Uso**: Para manejar errores internos en el servidor.
- **Código de estado**: 500 Internal Server Error

//Esta, no estoy completamente seguro si implementarla o no por la complejidad de uso que le veo, pero no sería mala idea. Te lo preguntaré el miercoles en clase
### **10. InvalidRelationshipException**
- **Descripción**: Esta excepción se lanzaría si se intenta realizar una operación inválida sobre la relación entre héroes y objetos, como intentar asignar un objeto que no corresponde a un héroe específico o eliminar un héroe que aún tiene objetos asignados en la base de datos.
- **Razón**: Es importante controlar las relaciones entre las entidades (por ejemplo, un héroe no debe poder ser eliminado si aún tiene objetos asignados). Debería devolver un HTTP **400 Bad Request** o HTTP **409 Conflict** con un mensaje explicativo.
- **Uso**: Al intentar realizar una operación inválida en la relación entre héroes y objetos.
- **Código de estado**: 400 Bad Request / 409 Conflict
