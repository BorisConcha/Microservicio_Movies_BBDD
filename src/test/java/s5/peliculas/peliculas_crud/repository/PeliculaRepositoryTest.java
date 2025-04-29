package s5.peliculas.peliculas_crud.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import s5.peliculas.peliculas_crud.model.Peliculas;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaRepositoryTest {
    
    @Autowired
    private PeliculasRepository peliculasRepository;

    @Test
    public void createPeliculaTest() {

        Peliculas peliculas = new Peliculas();

        peliculas.setTitulo("Volver al futuro");
        peliculas.setAnio(1985);
        peliculas.setDirector("Robert Zemeckis");
        peliculas.setGenero("Ciencia Ficción");
        peliculas.setSinopsis("El adolescente Marty McFly es amigo de Doc, un científico que ha construido una máquina del tiempo. Cuando los dos prueban el artefacto, un error fortuito hace que Marty llegue a 1955, año en el que sus padres iban al instituto.");

        Peliculas resultado = peliculasRepository.save(peliculas);

        assertNotNull(resultado.getId());

        assertEquals("Volver al futuro", resultado.getTitulo());

    }
}
