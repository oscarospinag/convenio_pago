package gt.com.tigo.convenio.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gt.com.tigo.convenio.dtos.ConvMesesDto;
import gt.com.tigo.convenio.service.ConvMesesService;

@RestController
@RequestMapping("/api")
public class ConvMesesController {

	@Autowired
	private ConvMesesService convMeses;

	@GetMapping("/mesesCon")
	public @ResponseBody ResponseEntity<List<ConvMesesDto>> listar() {
		return (ResponseEntity<List<ConvMesesDto>>) convMeses.listar();

	}

	@PostMapping("/mesesCon")
	public ResponseEntity<ConvMesesDto> agregar(@RequestBody ConvMesesDto convMesesDto) {
		ResponseEntity<ConvMesesDto> response = convMeses.agregar(convMesesDto);
		return response;
	}

	@PutMapping("/mesesCon/{id}")
	public ResponseEntity<ConvMesesDto> editar(@RequestBody ConvMesesDto convMesesDto) {
		ResponseEntity<ConvMesesDto> dto = convMeses.agregar(convMesesDto);
		return dto;
	}

	@DeleteMapping("mesesCon/{id}")
	public void delete(@PathVariable("id") Long id) {

		convMeses.eliminar(id);
	}

}
