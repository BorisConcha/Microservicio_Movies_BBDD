package s5.peliculas.peliculas_crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Peliculas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "año")
    private Number anio;
    @Column(name = "director")
    private String director;
    @Column(name = "genero")
    private String genero;
    @Column(name = "sinopsis")
    private String sinopsis;

    public Long getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public Number getAnio(){
        return anio;
    }

    public String getDirector(){
        return director;
    }

    public String getGenero(){
        return genero;
    }

    public String getSinopsis(){
        return sinopsis;
    }

    public void setId(Long id){ 
        this.id = id;
    }

    public void setTitulo(String titulo){ 
        this.titulo = titulo;
    }

    public void setAnio(Number anio){ 
        this.anio = anio;
    }

    public void setDirector(String director){ 
        this.director = director;
    }

    public void setGenero(String genero){ 
        this.genero = genero;
    }

    public void setSinopsis(String sinopsis){ 
        this.sinopsis = sinopsis;
    }

}
