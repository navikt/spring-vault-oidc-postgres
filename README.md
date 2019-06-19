# spring-vault-oidc-postgres
Base application that serves as an baseline for Spring applications on NAIS.

Appen inkluderer oppsett for
* Vault
* Postgres (med HSQL lokalt)

## Databaser
Hvorfor ikke bruke postgres både lokalt og i produksjon?


## For å starte appen i Intellij lokalt

Edit Configuration => Spring Boot

* Main Class: `no.nav.academy.exapp.AcademyExApplicationLocal`
* Active profiles: `dev`

Merk, det er klassen i test-scope som skal startes, ikke den som ligger
i default scope.




