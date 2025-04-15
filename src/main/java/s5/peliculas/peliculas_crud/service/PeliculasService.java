package s5.peliculas.peliculas_crud.service;

import java.util.List;
import java.util.Optional;

import s5.peliculas.peliculas_crud.model.Peliculas;

public interface PeliculasService {
    List<Peliculas> getAllPeliculas();
    Optional<Peliculas> getPeliculasbyId(Long id);
    Peliculas createPelicula(Peliculas peliculas);
    Peliculas updatePelicula(Long id, Peliculas peliculas);
    void deletePelicula(Long id);
}
