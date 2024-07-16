# Foro Hub API

## Descripción del Proyecto
Foro Hub es una plataforma de foros diseñada para fomentar la interacción y el intercambio de conocimientos entre usuarios. Este proyecto se centra en el desarrollo de la API y el backend, proporcionando una infraestructura robusta para la gestión de usuarios y la creación y manejo de temas de discusión.

## Características de la Aplicación
- **Registro de Usuarios:** Los nuevos usuarios pueden registrarse proporcionando la información necesaria para crear una cuenta.
- **Autenticación:** Los usuarios registrados deben iniciar sesión para obtener un token válido, necesario para acceder a los endpoints protegidos de la API.
- **Gestión de Temas:**
  - Crear Temas: Los usuarios autenticados pueden crear nuevos temas de discusión.
  - Responder a Temas: Los usuarios pueden responder a temas existentes.
  - Marcar Temas como Resueltos: Los temas pueden ser marcados como resueltos, indicando que la discusión ha alcanzado una conclusión satisfactoria.

## API Reference
- **Obtener todos los temas:** `GET /topic`
  - Parámetro: `api_key` (cadena, requerido)
- **Publicar Usuario:** `POST /user`
  - Parámetro: `api_key` (cadena, requerido)

## Acceso al Proyecto
- **Clonar el Repositorio:** [https://github.com/CarlosRetamozoPinatti/OracleONEJavaChallenge03.git]
- **Directorio del Proyecto:** `cd foro_hub`
- **Construir el Proyecto con Maven:** `mvn clean install`
- **Configurar la Aplicación:** Modificar el archivo `application.properties` en `src/main/resources` para ajustarlo a tu entorno local, incluidas las configuraciones de la base de datos y otros ajustes necesarios.

## Ejecutar la Aplicación
- **Ejecutar con Maven:** `mvn spring-boot:run`
- **Acceder a la API:** Una vez que la aplicación esté en ejecución, accede a la API en [http://localhost:8080](http://localhost:8080).
- **Utilizar un Cliente API como Postman:** Interactúa con los endpoints de registro de usuario, autenticación, creación de temas y respuestas.

## Documentación de la API e Interfaz de Pruebas
- **Springdoc y Swagger:** El proyecto utiliza Springdoc y Swagger para la documentación de la API.
- **Acceder a Swagger UI:** Visita [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) para explorar y probar todos los endpoints disponibles directamente desde tu navegador.

## Tecnologías Utilizadas
- Java 17
- Spring Boot 3
- Maven
- Spring Security
- JWT (Tokens Web JSON)
- Spring Data JPA
- Bases de Datos H2 y MySQL
- Springdoc y Swagger

## Licencia
MIT

## Conclusión
Foro Hub representa un sólido backend de plataforma de foros construido con Java, Spring Boot 3 y Maven. Facilita un registro de usuario fluido, autenticación mediante tokens JWT y funcionalidades completas de gestión de temas. Con tecnologías como Spring Security, Spring Data JPA y bases de datos H2, el proyecto asegura un manejo seguro y eficiente de datos. La integración de Springdoc con Swagger ofrece una interfaz interactiva de documentación de API, mejorando la usabilidad y comprensión de los desarrolladores sobre los endpoints disponibles. Con estas características, Foro Hub proporciona una base sólida para construir una aplicación de foro escalable y fácil de usar.
