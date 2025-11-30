# Módulo de Gestión de Empleados  
**Evidencia GA7-220501096-AA2-EV01** – Aplicar estándares de codificación

Este proyecto implementa un sistema de gestión de empleados con operaciones CRUD (Crear, Leer, Actualizar, Eliminar) utilizando **Java, JDBC y MySQL**, siguiendo buenas prácticas de desarrollo y estándares de codificación.

## Funcionalidades

- ✅ Insertar nuevo empleado
- ✅ Listar todos los empleados
- ✅ Actualizar datos de un empleado
- ✅ Eliminar un empleado

## Requisitos

- JDK 17 o superior
- MySQL 8.0+
- Base de datos `empresa` con tabla `empleado`

## Configuración

1. Crear la base de datos:
   ```sql
   CREATE DATABASE empresa;
   USE empresa;
   CREATE TABLE empleado (
       id INT PRIMARY KEY AUTO_INCREMENT,
       nombre VARCHAR(80) NOT NULL,
       correo VARCHAR(120) UNIQUE NOT NULL,
       salario DECIMAL(10,2) NOT NULL
   );


2. Configurar credenciales en el archivo .env:

DB_URL=jdbc:mysql://localhost:3306/empresa
DB_USER=root
DB_PASSWORD=tu_contraseña_temporal

Ejecución

mvn clean compile
mvn exec:exec -Dexec.executable="java" -Dexec.args="-cp %classpath com.example.App"

Estructura del proyecto

src/
├── main/
│   └── java/
│       └── com.example/
│           ├── App.java          # Menú interactivo
│           ├── dao/             # Capa de acceso a datos
│           ├── model/           # Entidad Empleado
│           └── util/            # Conexión a base de datos
pom.xml
.env                # (no subido a Git)
.gitignore
README.md

## Aprendiz 

- **Monica Ismelia Cañas Reyes** 
- [MonicaIsmelia](https://github.com/Monica-Ismelia) - *Perfil de GitHub*

