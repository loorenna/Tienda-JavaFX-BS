# Tarea JavaFX + Base de Datos

## Descripción del Proyecto

Este proyecto consiste en el desarrollo de una aplicación de escritorio utilizando JavaFX conectada a una base de datos PostgreSQL. La aplicación permite registrar productos mediante un formulario, almacenar la información en la base de datos y visualizar los registros existentes en una tabla.

## Objetivo

Implementar una aplicación JavaFX que permita realizar operaciones básicas de inserción y consulta de datos utilizando JDBC y PostgreSQL.

## Tecnologías Utilizadas

- Java
- JavaFX
- PostgreSQL
- JDBC
- Maven
- IntelliJ IDEA
- Scene Builder

## Funcionalidades

- Registro de productos.
- Validación de campos vacíos.
- Almacenamiento de información en PostgreSQL.
- Visualización de registros en un TableView.
- Limpieza de campos del formulario.
- Cierre de la aplicación.

## Estructura de la Base de Datos

```sql
CREATE DATABASE tienda;

CREATE TABLE productos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    precio DECIMAL(10,2),
    stock INT
);
```

## Dependencia PostgreSQL (Maven)

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.7</version>
</dependency>
```

## Configuración de la Conexión

```java
public class Conexion {

    public static Connection getConexion() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/tienda";
        String user = "postgres";
        String pass = "123456";

        return DriverManager.getConnection(url, user, pass);
    }
}
```

> Nota: Cambiar el usuario y contraseña según la configuración local de PostgreSQL.

## Estructura del Proyecto

```text
TareaFXconBS
│
├── src
│   └── main
│       ├── java
│       │   └── org.example.tareafxconbs
│       │       ├── Conexion.java
│       │       ├── Controller.java
│       │       ├── HelloApplication.java
│       │       ├── Launcher.java
│       │       └── Producto.java
│       │
│       └── resources
│           ├── Estilos
│           │   └── estilos.css
│           │
│           └── org.example.tareafxconbs
│               └── produc.fxml
│
└── pom.xml
```

## Pasos para Ejecutar el Proyecto

1. Crear la base de datos en PostgreSQL.
2. Crear la tabla `productos`.
3. Configurar los datos de conexión en la clase `Conexion`.
4. Verificar la dependencia PostgreSQL en el archivo `pom.xml`.
5. Ejecutar PostgreSQL.
6. Abrir el proyecto en IntelliJ IDEA.
7. Ejecutar la aplicación JavaFX.
8. Registrar productos y visualizar los registros almacenados.

## Evidencias Solicitadas

- Captura de la aplicación funcionando.
- Captura de los datos almacenados en PostgreSQL.
- Captura del TableView mostrando registros.
- Proyecto comprimido en formato ZIP.

## Resultados Obtenidos

Se logró establecer una conexión entre JavaFX y PostgreSQL mediante JDBC. La aplicación permite registrar productos, almacenar información en la base de datos y consultar los registros existentes de forma correcta mediante una interfaz gráfica amigable.

## Autor

**Nombre:** Alisson Quiguango

**Materia:** POO

## Licencia

Proyecto desarrollado con fines académicos.
