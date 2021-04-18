# Accenture Challenge (online market)
 Proyecto para crear API usando Java y Spring

Arquitectura por capas orientada al dominio.

Capas:
1. Dominio: Objetos de dominio, especificación de repositorios y servicios
2. Web: Controladores API REST
3. Persistencia: Repositorios y entities

El puerto en el que se puede ver el API es `8090`.

Documentación hecha con Swagger en `localhost:8090/acc-dev/api/swagger-ui.html`

## Suposiciones

Se asumieron los siguientes comportamientos:
1. Los pedidos de pueden editar únicamente si se crearon hace menos de 5 horas.
2. Los pedidos se pueden editar solo si el valor nuevo es mayor que el valor anterior.
3. Cuando el valor del subtotal supera los $100.000, el valor del domicilio es cero.

En el archivo "Postman Collection.json" se encuentra la colección de requests hechos en Postman para probar los criterios de aceptación.
