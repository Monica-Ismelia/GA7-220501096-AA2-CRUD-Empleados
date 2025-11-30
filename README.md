# Módulo de Gestión de Empleados  
**Evidencia GA7-220501096-AA2-EV01** – Aplicar estándares de codificación

Este proyecto implementa un sistema de gestión de empleados con operaciones CRUD (Crear, Leer, Actualizar, Eliminar) utilizando **Java, JDBC y MySQL**, siguiendo buenas prácticas de desarrollo y estándares de codificación.

## 🔧 Tecnologías utilizadas
- **Lenguaje**: Java 17+ (OpenJDK 25)
- **Gestor de dependencias**: Apache Maven
- **Base de datos**: MySQL 8.0+
- **Gestión de credenciales**: Archivo `.env` (con librería `java-dotenv`)
- **Estructura por capas**: Modelo, DAO, Utilidad, Aplicación principal

## 📦 Funcionalidades
- ✅ Insertar nuevo empleado
- ✅ Listar todos los empleados
- ✅ Actualizar datos de un empleado
- ✅ Eliminar un empleado

## 🛠️ Requisitos
- JDK 17 o superior
- MySQL 8.0+ en ejecución
- Base de datos `empresa` con tabla `empleado`:
  ```sql
  CREATE DATABASE IF NOT EXISTS empresa;
  USE empresa;
  CREATE TABLE empleado (
      id INT PRIMARY KEY AUTO_INCREMENT,
      nombre VARCHAR(80) NOT NULL,
      correo VARCHAR(120) UNIQUE NOT NULL,
      salario DECIMAL(10,2) NOT NULL
  );

  ⚙️ Configuración
Clona el repositorio.
Crea un archivo .env en la raíz del proyecto con tus credenciales:

DB_URL=jdbc:mysql://localhost:3306/empresa
DB_USER=root
DB_PASSWORD=tu_contraseña_temporal

3. Asegúrate de que tu base de datos local use la misma contraseña.
🔒 Importante: El archivo .env está excluido de Git por seguridad (/.gitignore).

▶️ Ejecución
# Compilar
mvn clean compile

# Ejecutar (recomendado para Java 17+)
mvn exec:exec -Dexec.executable="java" -Dexec.args="-cp %classpath com.example.App"

📁 Estructura del proyecto

src/
├── main/
│   └── java/
│       └── com.example/
│           ├── App.java          # Menú interactivo
│           ├── dao/             # Capa de acceso a datos
│           ├── model/           # Entidad Empleado
│           └── util/            # Conexión a base de datos
pom.xml
.env              
.gitignore
README.md


📝 Notas
Este proyecto cumple con los estándares de nombramiento (camelCase, PascalCase).
Usa PreparedStatement para evitar inyección SQL.
Código modular y con responsabilidad única por clase.
