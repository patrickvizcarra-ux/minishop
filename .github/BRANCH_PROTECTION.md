# Configurar protección para `main`

Esta configuración debe hacerse en GitHub después de subir el repositorio y de que el workflow haya ejecutado al menos una vez. No está aplicada ni verificada desde el proyecto local.

1. Abre el repositorio en GitHub y ve a **Settings → Rules → Rulesets**.
2. Crea un ruleset de ramas con nombre `proteger-main` y estado **Active**.
3. En **Target branches**, añade la rama `main`.
4. Activa **Require a pull request before merging**.
5. Activa **Require status checks to pass** y añade el check **Build y pruebas** (corresponde al job `build-and-test` de `ci.yml`).
6. Guarda el ruleset y confirma que aparezca como **Active** para `main`.

Si el check todavía no aparece en la lista, abre primero un Pull Request o ejecuta el workflow en GitHub, espera a que se registre el check y vuelve a editar el ruleset.
