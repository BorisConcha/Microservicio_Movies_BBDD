package s5.peliculas.peliculas_crud.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public CollectionModel<EntityModel<Peliculas>> getAllPeliculas() {

        List<Peliculas> peliculas = peliculasService.getAllPeliculas();
        
        List<EntityModel<Peliculas>> peliculasResources = peliculas.stream()
            .map(pelicula -> EntityModel.of(pelicula,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculasbyId(pelicula.getId())).withSelfRel()
                ))
            .collect(Collectors.toList());
        
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas());
        CollectionModel<EntityModel<Peliculas>> data = CollectionModel.of(peliculasResources, linkTo.withRel("peliculas"));

        return data;
    }
    

    @GetMapping("/{id}")
    public EntityModel<Peliculas> getPeliculasbyId(@PathVariable Long id) {
        Optional<Peliculas> peliculas = peliculasService.getPeliculasbyId(id);
        
        if (peliculas.isPresent()){
            return EntityModel.of(peliculas.get(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculasbyId(id)).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas()).withRel("all-peliculas"));

        } else {

            throw new PeliculasNotFoundException("La Peliculas con el id: " +id+ " no existe en el sistema");
        }
    }

    @PostMapping
    public EntityModel<Peliculas> createPelicula(@RequestBody Peliculas peliculas) {

        Peliculas crearPelicula = peliculasService.createPelicula(peliculas);
        return EntityModel.of(crearPelicula,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculasbyId(crearPelicula.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas()).withRel("all-peliculas"));
    }

    @PutMapping("/{id}")
    public EntityModel<Peliculas> updatePelicula(@PathVariable Long id, @RequestBody Peliculas peliculas) {
        
        Peliculas updatePelicula = peliculasService.updatePelicula(id, peliculas);
        return EntityModel.of(updatePelicula,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculasbyId(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas()).withRel("all-peliculas"));
    }
    
    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable Long id){

        peliculasService.deletePelicula(id);
    }
    
}
