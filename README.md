# Universidad Católica del Uruguay

## Facultad de Ingeniería y Tecnologías

## Análisis y diseño de aplicaciones II

### Demo sobre ESTILOS DE ARQUITECTURA

GRUPO 5:

* Lucía Bonilla
* José Ignacio Lavecchia
* Leonardo Roy Arispe
* Gaspar Lamas
* Facundo Dutra

### Contexto

- Dos API REST para gestionar proyectos, tareas y usuarios. Se centra en proyectos que contienen tareas, y en tareas asignadas a usuarios. Además, en ``user-service`` hay un único endpoint SOAP para crear usuarios.
- El sistema utiliza el estilo de arquitectura basado en servicios (``user-service``, para usuarios; ``work-service``, para tareas y proyectos).
- El sistema utiliza una partición técnica en cada servicio y un enfoque ACID para garantizar la consistencia de los datos.
- Backends desarrollado en Java con el framework Spring Boot con Spring Data JPA para facilitar el acceso a datos.
- La base de datos es una única instancia de PostgreSQL, tecnología de base de datos relacionales. En este sentido, se siguen los principios ACID para garantizar la consistencia de los datos.
- El testing de la aplicación se realiza con Postman.
- Vease el informe de la TFU 5 en Webasignatura para más información.

### Endpoint SOAP formato de la request

El endpoint es POST http://localhost:8080/soap-user

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:user="http://example.com/user">
   <soapenv:Header/>
   <soapenv:Body>
      <user:CreateUserRequest>
         <username>...</username>
         <email>...</email>
      </user:CreateUserRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Requisitos

* [maven](https://maven.apache.org/install.html)

### Pasos:

1. A nivel raíz de ``user-service`` y ``work-service``, ejecutar ``mvn clean package -DskipTests``

    * clean → Elimina el directorio /target antiguo (clases compiladas, JAR, etc.) para que pueda empezar de cero.
    * package → Compila el código y crea un artefacto ejecutable (un archivo .jar dentro de target/).
    * -DskipTests → Omite la ejecución de las pruebas unitarias de integración durante la compilación.

2. A nivel raíz del repositorio, levantar los contenedores Docker con ``docker-compose up -d --build``

3. Verificar que los contenedores están ejecutándose con ``docker ps``

    * projectmanager_user-service → Spring Boot API en puerto 8080
    * projectmanager_work-service → Spring Boot API en puerto 8081
    * projectmanager_db → PostgreSQL en puerto 5432

### Test

Utilizar la colección de [Postman](UT5%20TFU.postman_collection.json) para testear los endpoints. Si se apaga un servicio, el resto de servicios deben funcionar.