# Proyecto Gratitude Message API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

## Descripción

Esta API permite a los usuarios enviar, almacenar y listar mensajes de agradecimiento. Está diseñada para facilitar la expresión de gratitud entre usuarios, permitiendo la creación, visualización, y gestión de estos mensajes. La API está documentada con **Swagger** para facilitar su uso y pruebas.

## Características

- **Creación de mensajes de agradecimiento** con atributos como el mensaje y el nombre del remitente.
- **Visualización de mensajes** con opciones de ordenación (por defecto está ordenado por `date` pero también puede ser ordenado por `popularity`).
- **Dar 'me gusta'** a los mensajes de agradecimiento.
- **Eliminación de mensajes** por su ID.
- **Swagger UI** para la documentación interactiva de la API.

## Endpoints Principales

### Mensajes de Agradecimiento

- **POST** `/gratitude`: Crear un nuevo mensaje de agradecimiento.
- **GET** `/gratitude`: Listar todos los mensajes de agradecimiento con opción de ordenación.
- **POST** `/gratitude/{id}/like`: Incrementar el contador de 'me gusta' de un mensaje.
- **DELETE** `/gratitude/{id}`: Eliminar un mensaje de agradecimiento por su ID.

## Documentación con Swagger

La documentación de la API está disponible en el endpoint `/swagger-ui.html`, donde puedes probar los diferentes endpoints y ver la estructura de los datos.

## Tecnologías Utilizadas

- **Java 21**
- **Spring Boot**
- **Swagger** para la documentación de la API.
- **JPA** para la persistencia de datos.
- **PostgreSQL** para la base de datos.

## Requisitos

- **Java JDK 21**
- **Maven 3**
- **PostgreSQL 14**

## Pasos para ejecutar el proyecto

1. **Instalar las dependencias** necesarias.

   Asegúrate de tener instalados Java JDK 21, Maven 3 y PostgreSQL 14.

2. **Configurar la base de datos**.

   Crea una base de datos en PostgreSQL y actualiza las credenciales en el archivo `application.properties`.

3. **Construir el proyecto** con Maven.

   ```sh
   mvn clean package
   ```

4. **Ejecutar el JAR** generado.

   ```sh
   java -jar target/gratitude-message-api.jar
   ```

5. **Acceder a la documentación de la API** en `http://localhost:8080/swagger-ui.html`.

## Documentacion de la API

Esta API proporciona puntos finales para gestionar mensajes de agradecimiento. A continuación se muestran los puntos finales disponibles y sus formatos de solicitud/respuesta esperados.

[Doc Gratitude Message API](https://m3lb1z.github.io/challenge-gratitude-message/)
