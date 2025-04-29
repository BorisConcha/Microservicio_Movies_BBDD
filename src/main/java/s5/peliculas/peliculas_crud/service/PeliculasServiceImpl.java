package s5.peliculas.peliculas_crud.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import s5.peliculas.peliculas_crud.model.Peliculas;
import s5.peliculas.peliculas_crud.repository.PeliculasRepository;

@Service
public class PeliculasServiceImpl implements PeliculasService{
    @Autowired
    private PeliculasRepository peliculasRepository;

    private static final Logger logger = LoggerFactory.getLogger(PeliculasServiceImpl.class);

    @Override
    public List<Peliculas> getAllPeliculas(){

        logger.info("Buscando las Paliculas existentes en el sistema");
        try{

            List<Peliculas> peliculas = peliculasRepository.findAll();
            logger.info("Peliculas encontradas con exito:",peliculas);
            return peliculas;

        }catch (Exception e){
            logger.info("Error al buscar las peliculas en el sistema:",e);
            throw e;
        }
    }

    @Override
    public Optional<Peliculas> getPeliculasbyId(Long id){

        logger.info("Buscando la pelicula en el sistema con el id:",id);
        try{

            Optional<Peliculas> pelicula = peliculasRepository.findById(id);
            logger.info("Pelicula encontrada:",pelicula);
            return pelicula;

        }catch (Exception e){
            logger.info("Error al buscar la pelicula:",e);
            throw e;
        }
    }

    @Override
    public Peliculas createPelicula(Peliculas peliculas){

        logger.info("Creando una nueva pelicula en el sistema:",peliculas);
        try{

            Peliculas nueva_pelicula = peliculasRepository.save(peliculas);
            logger.info("Pelicula creada correctamente en el sistema:",nueva_pelicula);
            return nueva_pelicula;

        }catch (Exception e){
            logger.info("Error al crear una nueva pelicula en el sistema:",e);
            throw e;
        }
    }

    @Override
    public Peliculas updatePelicula(Long id,Peliculas peliculas){
        logger.info("Buscando la pelicula a modificar en el sistema");
        if(peliculasRepository.existsById(id)){

            peliculas.setId(id);
            Peliculas pelicula = peliculasRepository.save(peliculas);
            logger.info("Pelicula modificada correctamente en el sistema:",pelicula);
            return pelicula;

        }else{
            logger.info("La pelicula a modificar con el id: "+id+" no existe en el sistema");
            return null;
        }
    }

    @Override
    public void deletePelicula(Long id){
        logger.info("Borrando la pelicula del sistema con el id: ",id);
        try{

            peliculasRepository.deleteById(id);
            logger.info("Pelicula eliminada correctamente en el sistema");

        }catch (Exception e){
            logger.info("Error al eliminar la pelicula en el sistema",e);
            throw e;
        }
    }
}
