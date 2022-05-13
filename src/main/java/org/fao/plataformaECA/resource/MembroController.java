package org.fao.plataformaECA.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.fao.plataformaECA.modelo.Membro;
import org.fao.plataformaECA.repository.MembroRepository;
import org.fao.plataformaECA.resource.detalhes.DetalhesDoMembroDTO;
import org.fao.plataformaECA.resource.dto.MembroDTO;
import org.fao.plataformaECA.resource.form.MembroForm;
import org.fao.plataformaECA.resource.form.update.MembroAtualizar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/membros")
@CrossOrigin("*")
public class MembroController {

	@Autowired(required = true)
	private MembroRepository repository;

	@GetMapping
	public List<MembroDTO> listar() {
		List<Membro> membros=repository.findAll();
		return MembroDTO.convert(membros);
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<MembroDTO> gravar(@RequestBody @Valid MembroForm form, UriComponentsBuilder uriBuilder) {
		Membro membros = form.convert();
		repository.save(membros);

		URI uri = uriBuilder.path("/membro/{id}").buildAndExpand(membros.getId()).toUri();
		return ResponseEntity.created(uri).body(new MembroDTO(membros));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoMembroDTO> detalhar(@PathVariable Long id) {
		Optional<Membro> membros = repository.findById(id);
		if (membros.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoMembroDTO(membros.get()));
		}
		return ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<MembroDTO> atualizar(@PathVariable Long id, @RequestBody @Valid MembroAtualizar form) {
		Optional<Membro> membro = repository.findById(id);
		if (membro.isPresent()) {
			Membro emolumento = form.atualizar(id, repository);
			return ResponseEntity.ok(new MembroDTO(emolumento));
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable Long id) {
		Optional<Membro> membro = repository.findById(id);
		if (membro.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
