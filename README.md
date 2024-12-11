# Dota2API-REST
Trabajo de DAW para DWES

## **Nombre del proyecto**

Dota 2 API REST

## **Idea**

API REST que brinde informacion sobre heroes y objetos de Dota2 de manera actualizada


## **Justificacion del proyecto**

Esta API sería una herramienta util a la hora de construir paginas web como Dotabuff.com que se nutren de APIs REST de Dota 2 para mostrar informacion de jugadores, partidas, heroes y objetos aparte de noticias de interés en el mundillo de Dota.


# Tablas y Descripciones
## **Tabla Usuario**
Esta tabla representa a los usuarios de la API que podrán hacer uso de los diferentes endpoints en función de su rol. Define los permisos y credenciales básicos necesarios para interactuar con el sistema.

### **Atributos**
- **uid**
    - Tipo: `LONG`
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
    - Tipo: `LONG`
    - Descripción: Identificador único generado automáticamente por la base de datos. Clave primaria.

- **nombre_heroe**
    - Tipo: `VARCHAR(100)`
    - Descripción: Nombre único del héroe. Campo obligatorio y no nulo.

- **inteligencia**
    - Tipo: `LONG`
    - Descripción: Estadística de inteligencia del héroe. Campo obligatorio con un valor mínimo de `0`.

- **fuerza**
    - Tipo: `LONG`
    - Descripción: Estadística de fuerza del héroe. Campo obligatorio con un valor mínimo de `0`.

- **agilidad**
    - Tipo: `LONG`
    - Descripción: Estadística de agilidad del héroe. Campo obligatorio con un valor mínimo de `0`.

- **vida**
    - Tipo: `LONG`
    - Descripción: Vida base del héroe. Campo obligatorio.

- **mana**
    - Tipo: `LONG`
    - Descripción: Cantidad de maná base del héroe. Puede ser nulo.

- **historia_heroe**
    - Tipo: `TEXT`
    - Descripción: Breve descripción narrativa sobre el héroe. Campo obligatorio.

---

## **Tabla Objetos**
Guarda información sobre los objetos que los héroes pueden usar para mejorar sus habilidades y estadísticas en el juego.

### **Atributos**
- **uid**
    - Tipo: `LONG`
    - Descripción: Identificador único generado automáticamente por la base de datos. Clave primaria.

- **nombre_objeto**
    - Tipo: `VARCHAR(100)`
    - Descripción: Nombre único del objeto. Campo obligatorio y no nulo.

- **daño_fisico**
    - Tipo: `LONG`
    - Descripción: Daño físico adicional que proporciona el objeto. Campo obligatorio con un valor mínimo de `5`.

- **daño_magico**
    - Tipo: `LONG`
    - Descripción: Daño mágico adicional que proporciona el objeto. Campo opcional, pero si tiene valor, debe ser al menos `5`.

- **vida_adicional**
    - Tipo: `LONG`
    - Descripción: Vida adicional que otorga el objeto. Campo opcional, pero si tiene valor, debe ser al menos `50`.

- **mana_adicional**
    - Tipo: `LONG`
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
    - Tipo: `LONG`
    - Descripción: Identificador del objeto, clave foránea que enlaza con `uid` de la tabla **Objetos**.

- **id_heroe**
    - Tipo: `LONG`
    - Descripción: Identificador del héroe, clave foránea que enlaza con `uid` de la tabla **Héroes**.

- **cantidad_objeto**
    - Tipo: `LONG`
    - Descripción: Cantidad de veces que un héroe posee un objeto específico.

---

---
**Relacion entre tablas**

Cada heroe puede tener varios objetos y varios objetos pueden estar en varios heroes al mismo tiempo y multiples veces.

---
**Diagrama E/R**
![Captura de pantalla 2024-12-04 210901](https://github.com/user-attachments/assets/accc1fba-01ec-4e71-a1f4-3e15b544cc65)
# Endpoints de la API

## 1. Endpoints para Héroes

### **GET /dota2/heroes**
- **Método:** GET
- **Descripción:** Recupera la información básica de todos los héroes, como su nombre, estadísticas básicas y una breve descripción de su historia.
- **Uso:** Obtener un resumen de todos los héroes disponibles.

### **GET /dota2/heroes/{id}**
- **Método:** GET
- **Descripción:** Devuelve toda la información sobre un héroe específico, incluyendo su nombre, estadísticas (fuerza, agilidad, inteligencia, vida, mana) y su historia completa.
- **Parámetro:** `id` del héroe.

### **POST /dota2/heroes**
- **Método:** POST
- **Descripción:** Crea un nuevo héroe en el sistema.
- **Parámetros:**
    - **Cuerpo:** Datos del héroe (nombre, estadísticas, historia, etc.).

### **PUT /dota2/heroes/{id}**
- **Método:** PUT
- **Descripción:** Actualiza los datos de un héroe específico identificado por su ID.
- **Parámetros:**
    - **URL:** `id` del héroe a actualizar.
    - **Cuerpo:** Datos del héroe actualizados (nombre, estadísticas, historia, etc.).

### **DELETE /dota2/heroes/{id}**
- **Método:** DELETE
- **Descripción:** Elimina un héroe específico del sistema usando su ID.
- **Parámetro:**
    - **URL:** `id` del héroe a eliminar.

## 2. Endpoints para Objetos

### **GET /dota2/objetos**
- **Método:** GET
- **Descripción:** Recupera la información básica de todos los objetos disponibles en el juego (nombre, atributos como daño físico, mágico, vida, mana, etc.).

### **GET /dota2/objetos/{id}**
- **Método:** GET
- **Descripción:** Devuelve toda la información sobre un objeto específico, como su nombre, estadísticas y descripción.
- **Parámetro:** `id` del objeto.

### **POST /dota2/objetos**
- **Método:** POST
- **Descripción:** Crea un nuevo objeto en el sistema.
- **Parámetros:**
    - **Cuerpo:** Datos del objeto (nombre, atributos, descripción, etc.).

### **PUT /dota2/objetos/{id}**
- **Método:** PUT
- **Descripción:** Actualiza los datos de un objeto específico identificado por su ID.
- **Parámetros:**
    - **URL:** `id` del objeto a actualizar.
    - **Cuerpo:** Datos del objeto actualizados (nombre, atributos, descripción, etc.).

### **DELETE /dota2/objetos/{id}**
- **Método:** DELETE
- **Descripción:** Elimina un objeto específico del sistema usando su ID.
- **Parámetro:**
    - **URL:** `id` del objeto a eliminar.

## 3. Endpoints para las Relaciones Héroe-Objeto

### **GET /dota2/heroes/{id}/objetos**
- **Método:** GET
- **Descripción:** Devuelve una lista de objetos que posee un héroe específico, incluyendo la cantidad de cada objeto.
- **Parámetro:** `id` del héroe.

### **GET /dota2/objetos/{id}/heroes**
- **Método:** GET
- **Descripción:** Devuelve una lista de héroes que poseen un objeto específico, incluyendo la cantidad que tienen de dicho objeto.
- **Parámetro:** `id` del objeto.

### **POST /dota2/heroes/{id}/objetos**
- **Método:** POST
- **Descripción:** Asigna un objeto a un héroe específico o incrementa la cantidad si ya existe la relación.
- **Parámetros:**
    - **URL:** `id` del héroe.
    - **Cuerpo:**
        - `objectId`: ID del objeto a asignar.
        - `cantidad`: Cantidad del objeto a añadir.

### **PUT /dota2/heroes/{id}/objetos/{objetoId}**
- **Método:** PUT
- **Descripción:** Actualiza la cantidad de un objeto asignado a un héroe.
- **Parámetros:**
    - **URL:**
        - `id`: ID del héroe.
        - `objetoId`: ID del objeto asignado.
    - **Cuerpo:**
        - `cantidad`: Nueva cantidad del objeto.

### **DELETE /dota2/heroes/{id}/objetos/{objetoId}**
- **Método:** DELETE
- **Descripción:** Elimina un objeto asignado a un héroe específico.
- **Parámetros:**
    - **URL:**
        - `id`: ID del héroe.
        - `objetoId`: ID del objeto asignado.

### **POST /dota2/objetos/{id}/heroes**
- **Método:** POST
- **Descripción:** Asigna un héroe a un objeto específico (relación inversa).
- **Parámetros:**
    - **URL:** `id` del objeto.
    - **Cuerpo:**
        - `heroId`: ID del héroe a asignar.
        - `cantidad`: Cantidad asignada al héroe.

### **PUT /dota2/objetos/{id}/heroes/{heroeId}**
- **Método:** PUT
- **Descripción:** Actualiza la cantidad de un héroe relacionado con un objeto específico (relación inversa).
- **Parámetros:**
    - **URL:**
        - `id`: ID del objeto.
        - `heroId`: ID del héroe asignado.
    - **Cuerpo:**
        - `cantidad`: Nueva cantidad asignada al héroe.

### **DELETE /dota2/objetos/{id}/heroes/{heroeId}**
- **Método:** DELETE
- **Descripción:** Elimina la relación entre un objeto y un héroe específico.
- **Parámetros:**
    - **URL:**
        - `id`: ID del objeto.
        - `heroId`: ID del héroe.



## **Endpoints públicos (accesibles por ROLE_USER):**
Estos endpoints permiten a los usuarios autenticados con el rol USER acceder a información básica, pero no realizar modificaciones.

- **GET /dota2/heroes**
    - Devuelve una lista de todos los héroes disponibles en el sistema con sus detalles básicos.

- **GET /dota2/heroes/{id}**
    - Devuelve los detalles completos de un héroe específico.

- **GET /dota2/objetos**
    - Devuelve una lista de todos los objetos disponibles en el sistema con sus detalles básicos.

- **GET /dota2/objetos/{id}**
    - Devuelve los detalles completos de un objeto específico.

- **GET /dota2/heroes/{id}/objetos**
    - Devuelve la lista de objetos que posee un héroe específico.

- **GET /dota2/objetos/{id}/heroes**
    - Devuelve una lista de héroes que poseen un objeto específico.

## Endpoints protegidos (accesibles solo por ROLE_ADMIN)

Estos endpoints están limitados a usuarios con el rol **ADMIN** porque implican la creación, actualización y eliminación de recursos. Se utilizan para tareas administrativas y gestión de datos.

### **POST /dota2/heroes**
- **Descripción:** Permite a los administradores agregar un nuevo héroe al sistema.
- **Uso:** Añadir nuevos héroes al catálogo.

### **PUT /dota2/heroes/{id}**
- **Descripción:** Permite actualizar la información de un héroe existente, como sus estadísticas o historia.
- **Uso:** Modificar datos de héroes según cambios en el juego.

### **DELETE /dota2/heroes/{id}**
- **Descripción:** Elimina un héroe específico del sistema.
- **Uso:** Limpiar datos obsoletos o eliminar héroes no deseados.

### **POST /dota2/objetos**
- **Descripción:** Permite a los administradores agregar un nuevo objeto al sistema.
- **Uso:** Añadir nuevos objetos al inventario del juego.

### **PUT /dota2/objetos/{id}**
- **Descripción:** Permite actualizar la información de un objeto existente, como sus atributos o descripción.
- **Uso:** Modificar datos de objetos según actualizaciones del juego.

### **DELETE /dota2/objetos/{id}**
- **Descripción:** Elimina un objeto específico del sistema.
- **Uso:** Limpiar datos obsoletos o eliminar objetos no utilizados.

## Lógica de negocio

### 1. Lógica de negocio para Héroes

#### a) Validación de datos de héroe
- Comprobación de que el **nombre del héroe** sea único antes de crear uno nuevo para evitar duplicidades.
- Las **estadísticas de un héroe** (fuerza, agilidad, inteligencia, vida, mana) deben estar dentro de un rango esperado para evitar valores inconsistentes, como valores negativos o extremadamente altos.
- Verificar que el campo **historia** de cada héroe no esté vacío ni exceda un límite de caracteres.

#### b) Creación de héroes
- Antes de agregar un nuevo héroe, se debe verificar que todos los atributos sean válidos y completos. Si falta información esencial (por ejemplo, nombre o estadísticas), se lanzará una excepción.
- Los héroes deben ser agregados a la base de datos, asociándolos correctamente con las estadísticas correspondientes y la historia.

#### c) Actualización de héroes
- Es necesario verificar que el héroe con el **ID proporcionado** exista en la base de datos antes de actualizarlo.
- Si se modifica el **nombre** u otra propiedad, se validarán las nuevas estadísticas y la unicidad de la información si aplica.

#### d) Eliminación de héroes
- Al eliminar un héroe, se debe revisar si existen **objetos con relaciones activas**.
- Se eliminará cualquier relación dependiente antes de proceder con la eliminación del héroe para evitar inconsistencias.

---

### 2. Lógica de negocio para Objetos

#### a) Validación de objetos
- Los **nombres de los objetos** deben ser únicos. Al agregar o actualizar un objeto, se debe verificar que no esté duplicado.
- Comprobación de que los **valores de los atributos** (como daño físico, daño mágico, vida adicional, mana adicional, etc.) sean coherentes y estén dentro de los límites establecidos. Por ejemplo, los valores no deben ser negativos.
- Los atributos opcionales (por ejemplo, regeneración de mana) solo deben incluirse si tienen valores válidos.

#### b) Creación de objetos
- Validar que todos los parámetros del objeto sean correctos y que no exista ya en el sistema.
- Comprobar que los valores como **daño físico** o **regeneración de vida** sean razonables (por ejemplo, no exceder un valor máximo predefinido).

#### c) Actualización de objetos
- Verificar que el objeto ya exista antes de actualizarlo.
- Comprobar que el nuevo estado del objeto sea válido (por ejemplo, nuevos valores de daño o vida).

#### d) Eliminación de objetos
- Asegurarse de que el objeto no esté en uso por ningún héroe. De lo contrario, gestionar adecuadamente las relaciones en la tabla `heroe_objeto` para evitar referencias inválidas.

---

### 3. Lógica de negocio para la relación Héroe-Objeto

#### a) Comprobación de relaciones existentes
- Al asignar un objeto a un héroe, verificar si este ya tiene dicho objeto. Si es así, actualizar la cantidad en lugar de duplicar la entrada en la tabla de relaciones.

#### b) Creación de relaciones
- Si un héroe no tiene un objeto asignado, crear una nueva relación en la tabla `heroe_objeto`.
- Controlar la cantidad del objeto asignado para evitar que un héroe tenga más de la cantidad permitida.

#### c) Eliminación de relaciones
- Al eliminar un objeto o un héroe, asegurarse de que las relaciones asociadas se eliminen o actualicen adecuadamente para evitar inconsistencias.

## Excepciones

### 1. `HeroNotFoundException`
- **Descripción**: Esta excepción se lanza cuando se intenta acceder a un héroe que no existe en la base de datos. Por ejemplo, al realizar un `GET /dota2/heroes/{id}` con un ID que no corresponde a ningún héroe.
- **Razón**: Es fundamental proporcionar una respuesta clara cuando un recurso solicitado no se encuentra. Devuelve un mensaje como: *"El héroe no fue encontrado"*.
- **Uso**: Cuando no se encuentra un héroe específico por su ID.
- **Código de estado**: `404 Not Found`.

---

### 2. `ObjectNotFoundException`
- **Descripción**: Similar a `HeroNotFoundException`, esta excepción se lanza cuando un objeto solicitado no existe en la base de datos.
- **Razón**: Asegura coherencia en los errores de la API. Un `GET /dota2/objetos/{id}` devuelve un mensaje como: *"Objeto no encontrado"* si el ID no existe.
- **Uso**: Cuando no se encuentra un objeto específico por su ID.
- **Código de estado**: `404 Not Found`.

---

### 3. `InvalidHeroDataException`
- **Descripción**: Esta excepción se lanza cuando los datos proporcionados para crear o actualizar un héroe no son válidos. Ejemplos:
    - Estadísticas fuera de rango permitido.
    - Campos obligatorios faltantes.
- **Razón**: Validar los datos de entrada asegura que el héroe tenga valores consistentes y completos.
- **Uso**: Al crear o actualizar un héroe con datos inválidos.
- **Código de estado**: `400 Bad Request`.

---

### 4. `InvalidObjectDataException`
- **Descripción**: Similar a `InvalidHeroDataException`, se lanza cuando los datos para crear o actualizar un objeto no son válidos.
- **Razón**: Garantiza que los datos de los objetos sean correctos, con valores dentro de rangos lógicos (ej.: daño, vida, mana).
- **Uso**: Al crear o actualizar un objeto con datos inválidos.
- **Código de estado**: `400 Bad Request`.

---

### 5. `UnauthorizedActionException`
- **Descripción**: Esta excepción se lanza cuando un usuario intenta realizar una acción para la cual no tiene permisos. Ejemplo:
    - Un usuario con rol `USER` intentando crear o eliminar héroes y objetos.
- **Razón**: Protege los endpoints restringidos, asegurando que solo los administradores (`ROLE_ADMIN`) puedan realizar acciones sensibles.
- **Uso**: Cuando un usuario no autorizado intenta realizar una operación restringida.
- **Código de estado**: `403 Forbidden`.

---

### 6. `InvalidTokenException`
- **Descripción**: Se lanza cuando el token de autenticación proporcionado es inválido o ha expirado.
- **Razón**: Asegura que solo las solicitudes con tokens válidos y activos sean procesadas.
- **Uso**: Cuando un token de autenticación no es válido o ha expirado.
- **Código de estado**: `401 Unauthorized`.

---

### 7. `ResourceAlreadyExistsException`
- **Descripción**: Se lanza cuando se intenta crear un héroe u objeto que ya existe en la base de datos (basado en un campo único, como `nombre_heroe` o `nombre_objeto`).
- **Razón**: Evita duplicación de recursos en la base de datos. Devuelve un mensaje como: *"El recurso ya existe"*.
- **Uso**: Al intentar crear un héroe u objeto con un nombre ya registrado.
- **Código de estado**: `409 Conflict`.

---

### 8. `InsufficientDataException`
- **Descripción**: Se lanza cuando no se proporcionan datos suficientes para una operación, como la creación o actualización de héroes/objetos.
- **Razón**: Garantiza que las operaciones tengan los datos requeridos. Devuelve un mensaje detallado sobre los campos faltantes.
- **Uso**: Cuando faltan datos esenciales al crear o actualizar un recurso.
- **Código de estado**: `400 Bad Request`.

---

### 9. `InternalServerErrorException`
- **Descripción**: Excepción genérica para situaciones inesperadas en el servidor, como fallos de base de datos o errores no controlados.
- **Razón**: Permite capturar errores internos y devolver una respuesta coherente al cliente.
- **Uso**: Para manejar errores internos en el servidor.
- **Código de estado**: `500 Internal Server Error`.

---
//Esta no se si meterla porque no se implementar la logica detras de ella
### 10. `InvalidRelationshipException`
- **Descripción**: Se lanza cuando se intenta realizar una operación inválida sobre la relación entre héroes y objetos. Ejemplos:
    - Asignar un objeto a un héroe incompatible.
    - Intentar eliminar un héroe que aún tiene objetos asignados.
- **Razón**: Controla la consistencia de las relaciones entre entidades. Devuelve un mensaje explicativo.
- **Uso**: Al realizar una operación inválida en la relación héroe-objeto.
- **Código de estado**: `400 Bad Request` / `409 Conflict`.