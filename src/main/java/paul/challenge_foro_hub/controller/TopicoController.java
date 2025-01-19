package paul.challenge_foro_hub.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import paul.challenge_foro_hub.domain.topico.DatosDetalladoTopico;
import paul.challenge_foro_hub.domain.topico.DatosRegistroTopico;
import paul.challenge_foro_hub.domain.topico.Topico;
import paul.challenge_foro_hub.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
        var topico = new Topico(datosRegistroTopico);
        topicoRepository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalladoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalladoTopico>>listar(Pageable paginacion) {
        var page = topicoRepository.findByStatusTrue(paginacion).map(DatosDetalladoTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalladoTopico>detallar(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalladoTopico(topico));
    }
}
