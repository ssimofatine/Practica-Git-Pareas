package com.example.mediateca.pelicula;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final List<Pelicula> peliculas = List.of(
            new Pelicula(1L, "El laberinto del fauno", "Guillermo del Toro", 2006),
            new Pelicula(2L, "Parásitos", "Bong Joon-ho", 2019),
            new Pelicula(3L, "Origen", "Christopher Nolan", 2010)
    );

    @GetMapping
    public List<Pelicula> listar() {
        return peliculas;
    }

    @GetMapping("/{id}")
    public Pelicula buscarPorId(@PathVariable Long id) {
        return peliculas.stream()
                .filter(p -> p.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}