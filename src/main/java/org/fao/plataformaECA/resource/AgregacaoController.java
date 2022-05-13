package org.fao.plataformaECA.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.fao.plataformaECA.modelo.Agregacao;
import org.fao.plataformaECA.repository.AgregacaoRepository;
import org.fao.plataformaECA.repository.MembroRepository;
import org.fao.plataformaECA.resource.detalhes.DetalhesDaAgregacaoDTO;
import org.fao.plataformaECA.resource.dto.AgregacaoDTO;
import org.fao.plataformaECA.resource.form.AgregacaoForm;
import org.fao.plataformaECA.resource.form.update.AgregacaoAtualizar;
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
@RequestMapping("/agregacoes")
public class AgregacaoController {

	@Autowired
	private AgregacaoRepository repository;
	
	@Autowired
	private MembroRepository membroRepository;

	@GetMapping
	public List<AgregacaoDTO> listar() {
		List<Agregacao> agregacaos=repository.findAll();
		return AgregacaoDTO.convert(agregacaos);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AgregacaoDTO> gravar(@RequestBody @Valid AgregacaoForm form, UriComponentsBuilder uriBuilder) {
		Agregacao agregacao = form.convert(membroRepository);
		//
		repository.save(agregacao);
		URI uri = uriBuilder.path("/agregacaos/{id}").buildAndExpand(agregacao.getId()).toUri();
		return ResponseEntity.created(uri).body(new AgregacaoDTO(agregacao));
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDaAgregacaoDTO> detalhar(@PathVariable Long id) {
		Optional<Agregacao> agregacao = repository.findById(id);
		if (agregacao.isPresent()) {
			return ResponseEntity.ok(new DetalhesDaAgregacaoDTO(agregacao.get()));
		}
		return ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AgregacaoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AgregacaoAtualizar form) {
		Optional<Agregacao> agregacaos = repository.findById(id);
		if (agregacaos.isPresent()) {
			Agregacao agregacao = form.atualizar(id, repository,membroRepository);
			return ResponseEntity.ok(new AgregacaoDTO(agregacao));
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable Long id) {
		Optional<Agregacao> agregacaos = repository.findById(id);
		if (agregacaos.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
