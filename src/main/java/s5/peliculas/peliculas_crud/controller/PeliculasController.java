package s5.peliculas.peliculas_crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import s5.peliculas.peliculas_crud.model.Peliculas;
import s5.peliculas.peliculas_crud.service.PeliculasService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "*")
public class PeliculasController {
    @Autowired
    private PeliculasService peliculasService;

    @GetMapping
    public List<Peliculas> getAllPeliculas() {
        return peliculasService.getAllPeliculas();
    }
    

    @GetMapping("/{id}")
    public Optional<Peliculas> getPeliculasbyId(@PathVariable Long id) {
        return peliculasService.getPeliculasbyId(id);
    }

    @PostMapping
    public Peliculas createPelicula(@RequestBody Peliculas peliculas) {
        return peliculasService.createPelicula(peliculas);
    }

    @PutMapping("/{id}")
    public Peliculas updatePelicula(@PathVariable Long id, @RequestBody Peliculas peliculas) {
        
        return peliculasService.updatePelicula(id, peliculas);
    }
    
    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable Long id){

        peliculasService.deletePelicula(id);
    }
    
}
