package com.example.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistApplication {

	// lo que primero haremos sera crear nuestro contenedor de docker para la base
	// de datos y tener listo para encapsular nuestra aplicacion

	// ahora definiremos las propiedades de la aplicacion de spring boot

	// creamos el modelo de task

	// crearemos el controller, el servicio y el repositorio. Adicionalmente,
	// creamos un dto para la transformacion de datos de entrada

	// crearemos un dto para la paginacion

	// crearemos las excepciones para el manejo de errores, ahora manejaremos las
	// excepciones de forma global

	// ahora realizaremos validaciones por cada campo en la clase TaskDto

	// Gracias

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}
