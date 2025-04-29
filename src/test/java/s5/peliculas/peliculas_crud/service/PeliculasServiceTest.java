package s5.peliculas.peliculas_crud.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import s5.peliculas.peliculas_crud.model.Peliculas;
import s5.peliculas.peliculas_crud.repository.PeliculasRepository;

@ExtendWith(MockitoExtension.class)
public class PeliculasServiceTest {
    
    @InjectMocks
    private PeliculasServiceImpl peliculasServiceImpl;

    @Mock
    PeliculasRepository peliculasRepository;

    @Test
        public void createPeliculaTest() {

        Peliculas peliculas = new Peliculas();

        peliculas.setTitulo("La Momia");
        peliculas.setAnio(1999);
        peliculas.setDirector("Stephen Sommers");
        peliculas.setGenero("Ciencia Ficción");
        peliculas.setSinopsis("Rick O'Connell y un compañero descubren las ruinas de Hamunaptra. Después vuelven al mismo lugar con una egiptóloga y su hermano. Allí coinciden con un grupo de americanos que provocan la resurrección de la momia de un diabólico sacerdote egipcio.");

        when(peliculasRepository.save(any())).thenReturn(peliculas);

        Peliculas resultado = peliculasServiceImpl.createPelicula(peliculas);

        assertEquals("La Momia", resultado.getTitulo());

    }
}
