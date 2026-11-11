# MiniShop — Laboratorio 12: Pruebas de Integración

API REST para registrar y consultar productos con Spring Boot, Spring Data JPA y H2.

## Requisitos
- JDK 17 o superior
- Maven 3.8 o superior

## Ejecutar
```bash
mvn test
```
La suite contiene 13 pruebas: 4 para Repository con `@DataJpaTest`, 5 para Service con `@SpringBootTest` y `@MockBean`, y 4 para Controller con `MockMvc` y H2.

## Endpoints
- `POST /api/products` — registrar producto (JSON: `name`, `price`, `stock`)
- `GET /api/products` — listar productos
- `GET /api/products/{id}` — consultar por ID

## Conclusiones
Las pruebas de repositorio comprueban consultas y persistencia con una base de datos real en memoria. Las pruebas del servicio aíslan su lógica y validaciones mediante un mock del repositorio. Las pruebas del controlador recorren la petición HTTP, las capas de negocio y persistencia, y la respuesta JSON. Estos niveles se complementan: cada uno localiza fallos en una frontera distinta y la base H2 permite repetir las pruebas sin infraestructura externa.
