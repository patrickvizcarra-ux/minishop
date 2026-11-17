# MiniShop — Laboratorio 14: Calidad del software

API REST para registrar y consultar productos. Este repositorio conserva el trabajo del Laboratorio 13 y añade medición de cobertura con JaCoCo y análisis estático con SonarQube Cloud.

<!-- Badge del workflow de integración continua de MiniShop. -->
[![Build y pruebas](https://github.com/patrickvizcarra-ux/minishop/actions/workflows/ci.yml/badge.svg)](https://github.com/patrickvizcarra-ux/minishop/actions/workflows/ci.yml)

## Tecnologías y requisitos

- Java 17 o superior
- Maven 3.8 o superior
- Spring Boot 3.2.12, Spring Web, Spring Data JPA y H2
- JUnit 5, Mockito, Surefire y Failsafe
- JaCoCo Maven Plugin 0.8.13
- Git y GitHub Actions
- SonarQube Cloud para análisis estático

## Compilar y ejecutar las pruebas

```bash
mvn clean verify
```

Surefire ejecuta las pruebas unitarias y Failsafe ejecuta las pruebas de integración cuyos nombres terminan en `IT`. La ejecución `verify` genera el reporte de JaCoCo y detiene el build si la cobertura de líneas del proyecto es menor al 70 %.

Para ejecutar los grupos por separado:

```bash
mvn -B -DskipUTs=false test
mvn -B -DskipUTs=true verify
```

## Reporte de cobertura

```bash
mvn clean verify
open target/site/jacoco/index.html
```

El informe HTML queda en `target/site/jacoco/index.html` y el XML en `target/site/jacoco/jacoco.xml`. JaCoCo combina los datos de las pruebas unitarias y de integración en `target/jacoco.exec`.

## Pipeline de integración continua

El workflow `.github/workflows/ci.yml` conserva el job **Build y pruebas** y el job de publicación de releases. Compila con Java 17, ejecuta Surefire y Failsafe, verifica el umbral de cobertura, analiza el proyecto con SonarQube Cloud, y guarda los reportes y el JAR como artifacts. Las etiquetas `v*` siguen publicando una GitHub Release.

## SonarQube Cloud

El proyecto usa la organización `patrickvizcarra-ux` y la clave `patrickvizcarra-ux_minishop`. El workflow lee el token desde el secreto `SONAR_TOKEN` del repositorio; no se almacena en archivos del proyecto. La cobertura enviada a SonarQube Cloud proviene del XML de JaCoCo.

Para conectar o revisar el proyecto, inicia sesión en [SonarQube Cloud](https://sonarcloud.io), importa el repositorio `patrickvizcarra-ux/minishop` desde GitHub, verifica las claves indicadas y desactiva **Automatic Analysis** para que los análisis los realice GitHub Actions. El token debe existir como secreto `SONAR_TOKEN` en **Settings → Secrets and variables → Actions** del repositorio.

## Endpoints

- `POST /api/products` — registrar producto (JSON: `name`, `price`, `stock`)
- `GET /api/products` — listar productos
- `GET /api/products/{id}` — consultar por ID

## Protección de `main`

Las instrucciones para crear el ruleset `proteger-main` están en [`.github/BRANCH_PROTECTION.md`](.github/BRANCH_PROTECTION.md). La protección debe configurarse en GitHub; este repositorio local no puede confirmar si está activa.
