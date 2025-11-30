package com.example;

import com.example.dao.EmpleadoDAO;
import com.example.model.Empleado;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EmpleadoDAO dao = new EmpleadoDAO();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Menú CRUD Empleados ===");
            System.out.println("1. Insertar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); // consumir \n

                    if (dao.insertar(new Empleado(nombre, correo, salario))) {
                        System.out.println("✅ Empleado insertado correctamente.");
                    } else {
                        System.out.println("❌ Error al insertar.");
                    }
                    break;

                case 2:
                    List<Empleado> empleados = dao.listar();
                    if (empleados.isEmpty()) {
                        System.out.println("No hay empleados registrados.");
                    } else {
                        System.out.println("\n📋 Lista de empleados:");
                        for (Empleado e : empleados) {
                            System.out.printf("ID: %d | Nombre: %s | Correo: %s | Salario: %.2f%n",
                                    e.getId(), e.getNombre(), e.getCorreo(), e.getSalario());
                        }
                    }
                    break;

                case 3:
                    System.out.print("ID del empleado a actualizar: ");
                    int idAct = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo correo: ");
                    String nuevoCorreo = scanner.nextLine();
                    System.out.print("Nuevo salario: ");
                    double nuevoSalario = scanner.nextDouble();
                    scanner.nextLine();

                    Empleado empAct = new Empleado(idAct, nuevoNombre, nuevoCorreo, nuevoSalario);
                    if (dao.actualizar(empAct)) {
                        System.out.println("✅ Empleado actualizado.");
                    } else {
                        System.out.println("❌ Error al actualizar.");
                    }
                    break;

                case 4:
                    System.out.print("ID del empleado a eliminar: ");
                    int idDel = scanner.nextInt();
                    if (dao.eliminar(idDel)) {
                        System.out.println("✅ Empleado eliminado.");
                    } else {
                        System.out.println("❌ Error al eliminar.");
                    }
                    break;

                case 5:
                    System.out.println("👋 ¡Hasta luego!");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
