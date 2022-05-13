package org.fao.plataformaECA.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.fao.plataformaECA.modelo.Projecto;
import org.fao.plataformaECA.repository.ProjectoRepository;
import org.fao.plataformaECA.resource.detalhes.DetalhesDoProjectoDTO;
import org.fao.plataformaECA.resource.dto.ProjectoDTO;
import org.fao.plataformaECA.resource.form.ProjectoForm;
import org.fao.plataformaECA.resource.form.update.ProjectoAtualizar;
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
@RequestMapping("/projectos")
@CrossOrigin("*")
public class ProjectoController {

	@Autowired(required = true)
	private ProjectoRepository repository;
	
	
	@GetMapping
	public List<ProjectoDTO> listar() {
		List<Projecto> projectos=repository.findAll();
		return ProjectoDTO.convert(projectos);
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProjectoDTO> gravar(@RequestBody @Valid ProjectoForm form, UriComponentsBuilder uriBuilder) {
		Projecto projectos = form.convert();
		repository.save(projectos);

		URI uri = uriBuilder.path("/projecto/{id}").buildAndExpand(projectos.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProjectoDTO(projectos));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoProjectoDTO> detalhar(@PathVariable Long id) {
		Optional<Projecto> projectos = repository.findById(id);
		if (projectos.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoProjectoDTO(projectos.get()));
		}
		return ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProjectoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProjectoAtualizar form) {
		Optional<Projecto> projecto = repository.findById(id);
		if (projecto.isPresent()) {
			Projecto emolumento = form.atualizar(id, repository);
			return ResponseEntity.ok(new ProjectoDTO(emolumento));
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable Long id) {
		Optional<Projecto> projecto = repository.findById(id);
		if (projecto.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
