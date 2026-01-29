# Orders - Microservicio de Órdenes

## Descripción

**Orders** es un microservicio desarrollado con Spring Boot 4.0.2 que proporciona funcionalidades completas para la gestión de órdenes de compra.

## Características Principales

- **Gestión de Órdenes**: Crear, consultar y actualizar órdenes de compra
- **Control de Estado**: Gestión de estados de órdenes (creada, pagada, cancelada, etc.)
- **Validación Optimista**: Implementación de versionado para evitar conflictos de concurrencia
- **Manejo de Errores**: Respuestas genéricas con códigos HTTP apropiados
- **API RESTful**: Endpoints documentados para operaciones de órdenes

## Tecnologías

- **Spring Boot**: 4.0.2
- **Java**: 17+
- **Hibernate**: 7.2.1
- **PostgreSQL**: Base de datos relacional
- **Maven**: Gestor de dependencias
- **JUnit 5**: Framework de testing

## Estructura del Proyecto

```
orders/
├── src/
│   ├── main/java/com/zetdev/orders/
│   │   ├── application/          # DTOs y casos de uso
│   │   ├── domain/               # Modelos de negocio
│   │   ├── infrastructure/       # Controladores y persistencia
│   │   └── OrdersApplication.java
│   └── resources/
│       └── application.properties
└── pom.xml
```

## Configuración

### Requisitos
- Java 17
- PostgreSQL 14
- Maven 3.8+

### Variables de Entorno
```
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/orders
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=tu_contraseña
```

## Compilación y Ejecución

```bash
# Compilar el proyecto
mvn clean package

# Ejecutar la aplicación
java -jar target/orders-0.0.1-SNAPSHOT.jar

# Ejecutar con Docker
docker-compose up
```

## Testing

```bash
# Ejecutar pruebas unitarias
mvn test
```

## Contribución

Para contribuir al proyecto, realiza un fork, crea una rama para tu feature y envía un pull request.

---

**Autor**: ZetDev  
**Licencia**: MIT
