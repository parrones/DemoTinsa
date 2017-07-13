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
Esta operación crea un nuevo cliente con el tipo de envío(fax,sms) que ha elegido para recibir las notificaciones. La operación recibe en el body un json con los datos. Para hacer una petición desde un cliente:
- Poner en la cabecera Content-Type y Accept igual a application/json.
- Añadir en el body el json con los datos a enviar, por ejemplo:
	* {
		"name": "Test",
		"communication": "fax",
		"recipient": "913345789"
	  }
- Por último hacer un POST a http://localhost:8080/communications-manager/api/clients
