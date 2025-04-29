package s5.peliculas.peliculas_crud.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import s5.peliculas.peliculas_crud.model.Peliculas;
import s5.peliculas.peliculas_crud.service.PeliculasServiceImpl;

@WebMvcTest(PeliculasController.class)
public class PeliculaControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculasServiceImpl peliculasServiceImplMock;

    @Test
    public void obtenerTodosTest() throws Exception{

        Peliculas pelicula1 = new Peliculas();
        pelicula1.setId(1L);
        pelicula1.setTitulo("Pelicula de prueba");
        pelicula1.setAnio(1999);
        pelicula1.setDirector("Pruebita");
        pelicula1.setGenero("Ciencia Ficción");
        pelicula1.setSinopsis("Pelicula de prueba 1");

        Peliculas pelicula2 = new Peliculas();
        pelicula2.setId(2L);
        pelicula2.setTitulo("Prueba la pelicula");
        pelicula2.setAnio(2000);
        pelicula2.setDirector("Pruebito Pruebas");
        pelicula2.setGenero("Acción");
        pelicula2.setSinopsis("Pelicula de prueba 2");

        List<Peliculas> peliculas = Arrays.asList(pelicula1, pelicula2);
        when(peliculasServiceImplMock.getAllPeliculas()).thenReturn(peliculas);

        mockMvc.perform(MockMvcRequestBuilders.get("/peliculas"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.peliculasList[0].name", Matchers.is("Pelicula de prueba")))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.peliculasList[1].name", Matchers.is("Prueba la pelicula")));

    }
}
