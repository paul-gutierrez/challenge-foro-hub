package paul.challenge_foro_hub.domain.topico;


import java.time.LocalDateTime;

public record DatosDetalladoTopico(String titulo, String mensaje, LocalDateTime fechaDeCreacion, String status, String autor, String curso) {
    public DatosDetalladoTopico(Topico topico) {
        this(topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getStatus() ? "Pendiente" : "Concluido",
                topico.getAutor(),
                topico.getCurso());
    }
}
