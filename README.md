# User Microservice

## Requisitos

- Java JDK 21
- Docker

### Base de datos

- **Host**: `localhost:3306`
- **Base**: `arquitectura`
- **Usuario**: `appuser`
- **Contraseña**: `password123`

### Puertos

| Servicio    | Puerto |
| ----------- | ------ |
| App         | 8085   |
| MySQL       | 3306   |
| RabbitMQ    | 5672   |
| RabbitMQ UI | 15672  |
| Eureka      | 8761   |

## Ejecución

### Mac / Linux

```bash
./scripts/mac-linux/docker.sh   # Solo si usás Docker
./scripts/mac-linux/start.sh    # Levantar la app
```

### Windows

```cmd
scripts\windows\docker.bat      # Solo si usás Docker
scripts\windows\start.bat       # Levantar la app
```

## Endpoints

| Método | URL            | Body                                                  |
| ------ | -------------- | ----------------------------------------------------- |
| POST   | `/users/crear` | `{ "nombre", "nombreUsuario", "contrasena", "mail" }` |
| POST   | `/users/login` | `{ "mail", "contrasena" }`                            |

Swagger UI: **http://localhost:8085/swagger-ui/index.html**
