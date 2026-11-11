# MiniShop — Laboratorio 13: Integración continua

API REST para registrar y consultar productos con Spring Boot 3.2.12, Spring Data JPA y H2.

<!-- Badge del workflow de integración continua de MiniShop. -->
[![Build y pruebas](https://github.com/patrickvizcarra-ux/minishop/actions/workflows/ci.yml/badge.svg)](https://github.com/patrickvizcarra-ux/minishop/actions/workflows/ci.yml)

## Requisitos

- JDK 17
- Maven 3.9.16 (o Maven 3.8 o superior)

## Compilar y probar

```bash
mvn clean verify
```

Surefire ejecuta las 3 pruebas unitarias de `ProductServiceTest`. Failsafe ejecuta las 13 pruebas de integración cuyos nombres terminan en `IT`: 4 de repositorio, 5 de servicio y 4 de controlador.

Para ejecutar cada grupo por separado:

```bash
mvn -DskipUTs=false surefire:test
mvn -DskipUTs=true failsafe:integration-test failsafe:verify
```

El workflow de GitHub Actions está en `.github/workflows/ci.yml`. En cada ejecución almacena reportes Maven y el JAR como artifacts. Cuando se publica una etiqueta `v*`, el job de Release adjunta el JAR a una GitHub Release.

## Endpoints

- `POST /api/products` — registrar producto (JSON: `name`, `price`, `stock`)
- `GET /api/products` — listar productos
- `GET /api/products/{id}` — consultar por ID

## Protección de `main`

Las instrucciones para crear el ruleset `proteger-main` están en [`.github/BRANCH_PROTECTION.md`](.github/BRANCH_PROTECTION.md). La protección debe configurarse en GitHub; este repositorio local no puede confirmar si está activa.
