package com.example.helloword.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.helloword.Domain.Producto;

@RestController
public class ApiController {

    @GetMapping("/")
    public String home() {
        return "Home de campers";
    }

    @GetMapping("/saludo")
    public String Saludo(
        @RequestParam(name = "nombre", required = true) String name,
        @RequestParam(name = "apellido", required = false, defaultValue = "apellidoComun") String lastName
        ) {
        return "Hello " + name + " " + lastName;
    }

    @GetMapping("/search")
    public Map<String, String> buscar(
        @RequestParam(name = "name", required = false, defaultValue = " ") String name
        ) {
            Map<String, String> cities = new HashMap<>();
            cities.put("BUC", "Bucaramanga");
            cities.put("NYC", "New York");
            cities.put("BOG", "Bogota");
            cities.put("NVA", "Naiva");
            cities.put("LET", "Leticia");
            cities.put("PER", "Pereira");

            if (cities.containsKey(name)) {
                return Map.of(name, cities.get(name));
            } else {
                return cities;
            }
    }

    @GetMapping("/tax")
    public Map<String, Object> calcular(
        @RequestParam(name = "impuestos", defaultValue = "0") double impuestos
        ) {
            List<Producto> productos = new ArrayList<>(
                List.of(new Producto(1, "Pan", 2000))
                );
            productos.add(new Producto(2, "Gaseosa", 3500));
            productos.add(new Producto(3, "Salchichon Zenu", 1500));

            double total = 0;
            double valor = 0;

            for (int i = 0; i < productos.size(); i++) {
                total += productos.get(i).getPrice();
            }
            valor = total + total * (impuestos/100);

            return Map.of("productos", productos, "total", valor, "valor_neto", total, "IVA", impuestos + "%");
            
        }
}