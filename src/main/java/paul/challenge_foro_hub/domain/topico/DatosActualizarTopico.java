package paul.challenge_foro_hub.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        String autor,
        String curso
) {
}
