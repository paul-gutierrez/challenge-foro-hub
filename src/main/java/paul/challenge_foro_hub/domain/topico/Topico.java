package paul.challenge_foro_hub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaDeCreacion;
    private Boolean status;
    private String autor;
    private String curso;

    // Constructores
    public Topico(){

    }

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaDeCreacion, Boolean status, String autor, String curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaDeCreacion = fechaDeCreacion;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
    }

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaDeCreacion = datosRegistroTopico.fechaDeCreacion();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }


    public void actualizarInformacion(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }

        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }

        if (datosActualizarTopico.fechaDeCreacion() != null) {
            this.fechaDeCreacion = datosActualizarTopico.fechaDeCreacion();
        }

        if (datosActualizarTopico.autor() != null) {
            this.autor = datosActualizarTopico.autor();
        }

        if (datosActualizarTopico.curso() != null) {
            this.curso = datosActualizarTopico.curso();
        }
    }
}
