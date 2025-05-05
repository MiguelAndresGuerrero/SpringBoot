package com.adrian.demojpa.infrastructure.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.application.service.ProjectService;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Project;
import com.adrian.demojpa.domain.Rol;
import com.adrian.demojpa.domain.RoleRequest;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonService personService;

    private final ProjectService projectService;

    public ApiController(PersonService personService, ProjectService projectService) {
        this.personService = personService;
        this.projectService = projectService;
    }

    // Obtener usuarios
    @GetMapping("/users")
    public List<Person> findAllUser(
            @RequestParam(name = "filter", defaultValue = "") String filter,
            @RequestParam(name = "value", defaultValue = "") String value) {

        List<Person> results = personService.findAllUsersByFilter(filter, value);

        return results;
    }

    // Eliminar usuarios por id
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable long id) {
        boolean eliminado = personService.eliminarPorId(id);
        if (eliminado) {
            return ResponseEntity.ok("Persona eliminada con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Persona no encontrada");
        }
    }

    /*
     * Error del servidor no acepta utf-8 del postman -hacerle la pregunta al
     * profesor
     * Agregar usuarios metodo POST
     * 
     * @PostMapping("/users")
     * public Person CreateUser(@Valid @RequestBody Person person) {
     * return personService.saveUser(person);
     * }
     */

    // Actualizar usuario
    @PutMapping("/users/{id}")
    public ResponseEntity<Person> updateUser(
            @PathVariable Long id,
            @RequestBody Person updatePerson) {
        Person person = personService.updatePerson(id, updatePerson);

        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Rol>> findAllRoles(
            @RequestParam(name = "filter", defaultValue = "") String filter,
            @RequestParam(name = "value", defaultValue = "") String value) {

        List<Rol> results = personService.findAllRolesByFilter(filter, value);

        return ResponseEntity.ok(results);
    }

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol newRole(@Valid @RequestBody RoleRequest role) {
        return personService.createNewRol(role.getName());
    }

    @GetMapping("/projects")
    public List<Project> findAllProjects(
            @RequestParam(name = "filter", defaultValue = "") String filter,
            @RequestParam(name = "value", defaultValue = "") String value) {

        List<Project> results = projectService.findAllProjects();
        return results;
    }
}