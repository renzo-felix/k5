# Grupo HKT4 3
# Pasos para que funcione

## Paso 1: clona el repositorio
## Paso 2:
- Para que funciona app-name asegurate en el archivo .\app-name\src\api\dataService.js
- pueda usar el puerto 8090

```
const BASE_URL = 'http://localhost:8090';
```

## Paso 3:

- Para que funcione demo asegurese que en el archivo 
.\demo\src\main\resources\application.properties
- pueda usar las siguientes lineas de codigo
```
server.port=8090
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
```