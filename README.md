![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# LAB | SpringBoot REST API

## Instrucciones

1. Haz un **fork** de este repositorio.  
2. Clona tu **fork** en tu máquina local.  
3. Resuelve los desafíos.  

## Entregables  

- Una vez completado, agrega tu solución a **git**.  
- Luego, haz **commit** en git y **push** a tu repositorio en GitHub.  
- Crea un **pull request** y pega el enlace del pull request en el campo de entrega en el **Portal del Estudiante**.

## Tareas

### 1. Configuración del Proyecto

Crea una aplicación **Spring Boot** utilizando **Spring Initializr** con las siguientes dependencias:
- **Spring Web**
- **Spring Boot DevTools**
- **Spring Boot Starter Validation**

### 2. Clase `Product`

Crea una clase `Product` que represente un producto con diversas propiedades.  
Asegúrate de aplicar **validaciones adecuadas** en los atributos, como:
- Validar que el **nombre** no esté vacío y tenga una longitud mínima.
- Asegurar que el **precio** sea un número positivo.
- Verificar que la **categoría** no esté vacía.
- Garantizar que la **cantidad** sea un número válido y positivo.

### 3. Clase `ProductService`

Crea una clase `ProductService` que **gestione una lista de productos** con los siguientes métodos:
- **Agregar un nuevo producto**.
- **Obtener todos los productos**.
- **Buscar un producto por nombre**.
- **Actualizar un producto**.
- **Eliminar un producto**.
- **Obtener productos por categoría**.
- **Obtener productos por rango de precios**.

### 4. Clase `ProductController`

Crea un `ProductController` que:
- **Use inyección de dependencias por constructor** para recibir `ProductService`.
- **Requiera un encabezado "API-Key"** en todas las solicitudes (**valor requerido: `"123456"`**).
- Exponga los siguientes **endpoints**:

| **Método HTTP** | **Ruta**                               | **Descripción**                      |
|---------------|----------------------------------|----------------------------------|
| **POST**     | `/products`                      | Crea un nuevo producto          |
| **GET**      | `/products`                      | Obtiene todos los productos     |
| **GET**      | `/products/{name}`               | Obtiene un producto por nombre  |
| **PUT**      | `/products/{name}`               | Actualiza un producto por nombre |
| **DELETE**   | `/products/{name}`               | Elimina un producto por nombre  |
| **GET**      | `/products/category/{category}`  | Obtiene productos por categoría |
| **GET**      | `/products/price?min={min}&max={max}` | Obtiene productos por rango de precios |

### 5. Manejador Global de Excepciones
Crea un **manejador global de excepciones** (`@RestControllerAdvice`) que maneje:
- **Errores de validación** → Retorna **mensajes de error detallados**.
- **Falta del encabezado API-Key** → Retorna un error si no se envía la clave API.
- **Producto no encontrado** → Devuelve un error si el producto no existe.
- **Rango de precios inválido** → Maneja solicitudes con valores incorrectos.

### 6. Clase `Customer`
Crea una clase `Customer` con propiedades adecuadas y aplica validaciones como:
- Asegurar que el **nombre** no esté vacío.
- Verificar que el **email** tenga un formato válido.
- Garantizar que la **edad** mínima sea de **18 años**.
- Validar que la **dirección** no esté vacía.

### 7. Clase `CustomerController`
Crea un **`CustomerController`** con los siguientes **endpoints**:

| **Método HTTP** | **Ruta**                 | **Descripción**                   |
|---------------|------------------------|-------------------------------|
| **POST**     | `/customers`            | Crea un nuevo cliente con validación |
| **GET**      | `/customers`            | Obtiene todos los clientes     |
| **GET**      | `/customers/{email}`     | Obtiene un cliente por email   |
| **PUT**      | `/customers/{email}`     | Actualiza un cliente           |
| **DELETE**   | `/customers/{email}`     | Elimina un cliente             |

## Recuerda:

- Usa una **estructura de paquetes adecuada**.  
- **Usa inyección de dependencias por constructor** en lugar de `@Autowired`.  
- **Prueba todos los endpoints** en **Postman**.  
- **Incluye manejo de errores adecuado** con mensajes detallados.  
- Usa **nombres de variables y métodos significativos**.  
- **Devuelve códigos de estado HTTP adecuados**.  
- **Incluye mensajes de validación en las respuestas**.