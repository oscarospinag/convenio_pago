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
import gt.com.tigo.convenio.dtos.ConvMontoMaxDto;
import gt.com.tigo.convenio.service.ConvMontoMaxService;

@RestController
@RequestMapping("/api")
public class ConvMontoMaxController {

	@Autowired
	private ConvMontoMaxService convMontoMaxService;

	@GetMapping("/montoMax")
	public @ResponseBody ResponseEntity<List<ConvMontoMaxDto>> listar() {
		return (ResponseEntity<List<ConvMontoMaxDto>>) convMontoMaxService.listar();
	}

	@PostMapping("/montoMax")
	public ResponseEntity<ConvMontoMaxDto> agregar(@RequestBody ConvMontoMaxDto convMontoMaxDto) {
		ResponseEntity<ConvMontoMaxDto> dto = convMontoMaxService.agregar(convMontoMaxDto);
		return dto;
	}

	@PutMapping("/montoMax/{id}")
	public ResponseEntity<ConvMontoMaxDto> editar(@RequestBody ConvMontoMaxDto convMontoMaxDto) {
		ResponseEntity<ConvMontoMaxDto> dto = convMontoMaxService.editar(convMontoMaxDto);
		return dto;
	}

	@DeleteMapping("montoMax/{id}")
	public void delete(@PathVariable("id") Long id) {

		convMontoMaxService.eliminar(id);
	}

}
