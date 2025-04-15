package s5.peliculas.peliculas_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import s5.peliculas.peliculas_crud.model.Peliculas;
import s5.peliculas.peliculas_crud.repository.PeliculasRepository;

@Service
public class PeliculasServiceImpl implements PeliculasService{
    @Autowired
    private PeliculasRepository peliculasRepository;

    @Override
    public List<Peliculas> getAllPeliculas(){
        return peliculasRepository.findAll();
    }

    @Override
    public Optional<Peliculas> getPeliculasbyId(Long id){
        return peliculasRepository.findById(id);
    }

    @Override
    public Peliculas createPelicula(Peliculas peliculas){
        return peliculasRepository.save(peliculas);
    }

    @Override
    public Peliculas updatePelicula(Long id,Peliculas peliculas){
        if(peliculasRepository.existsById(id)){
            peliculas.setId(id);
            return peliculasRepository.save(peliculas);

        }else{
            return null;
        }
    }

    @Override
    public void deletePelicula(Long id){
        peliculasRepository.deleteById(id);
    }
}
