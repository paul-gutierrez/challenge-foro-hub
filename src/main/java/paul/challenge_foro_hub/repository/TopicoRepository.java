package paul.challenge_foro_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paul.challenge_foro_hub.domain.topico.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
