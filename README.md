### Tecnologías usadas
- Maven
- Spring Boot
- Java8
### Lanzar los tests

```
mvn clean test
```
### Arrancar aplicación en local
```
mvn clean spring-boot:run
```
###### Ejemplo llamada a operación
http://localhost:8080/communications-manager/api/clients
y pasar en el body los siguientes campos:
{
	"name": "Test",
	"communication": "fax",
	"recipient": "913345789"
}
