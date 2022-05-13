package org.fao.plataformaECA.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.fao.plataformaECA.modelo.Titulo;
import org.fao.plataformaECA.repository.TituloRepository;
import org.fao.plataformaECA.resource.detalhes.DetalhesDoTituloDTO;
import org.fao.plataformaECA.resource.dto.TituloDTO;
import org.fao.plataformaECA.resource.form.TituloForm;
import org.fao.plataformaECA.resource.form.update.TituloAtualizar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private TituloRepository repository;

	@GetMapping
	public List<TituloDTO> listar() {
		List<Titulo> titulos=repository.findAll();
		return TituloDTO.convert(titulos);
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<TituloDTO> gravar(@RequestBody @Valid TituloForm form, UriComponentsBuilder uriBuilder) {
		Titulo titulos = form.convert();
		repository.save(titulos);

		URI uri = uriBuilder.path("/titulo/{id}").buildAndExpand(titulos.getId()).toUri();
		return ResponseEntity.created(uri).body(new TituloDTO(titulos));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoTituloDTO> detalhar(@PathVariable Long id) {
		Optional<Titulo> titulos = repository.findById(id);
		if (titulos.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoTituloDTO(titulos.get()));
		}
		return ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TituloDTO> atualizar(@PathVariable Long id, @RequestBody @Valid TituloAtualizar form) {
		Optional<Titulo> titulo = repository.findById(id);
		if (titulo.isPresent()) {
			Titulo emolumento = form.atualizar(id, repository);
			return ResponseEntity.ok(new TituloDTO(emolumento));
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable Long id) {
		Optional<Titulo> titulo = repository.findById(id);
		if (titulo.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
