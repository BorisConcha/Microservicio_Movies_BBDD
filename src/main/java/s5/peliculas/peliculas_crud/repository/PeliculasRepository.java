package s5.peliculas.peliculas_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import s5.peliculas.peliculas_crud.model.Peliculas;

public interface PeliculasRepository extends JpaRepository<Peliculas, Long>{
    
}
