package paul.challenge_foro_hub.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotNull String titulo,
        @NotNull String mensaje,
        @NotNull LocalDateTime fechaDeCreacion,
        @NotNull Boolean status,
        @NotNull String autor,
        @NotNull String curso
) {
}
