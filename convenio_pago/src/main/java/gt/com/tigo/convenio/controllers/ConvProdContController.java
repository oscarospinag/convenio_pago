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
import gt.com.tigo.convenio.dtos.ConvProdContDto;
import gt.com.tigo.convenio.service.ConvProdContService;

@RestController
@RequestMapping("/api")
public class ConvProdContController {
	@Autowired
	private ConvProdContService convProdContService;

	@GetMapping("/convPro")
	public @ResponseBody ResponseEntity<List<ConvProdContDto>> listar() {
		return (ResponseEntity<List<ConvProdContDto>>) convProdContService.listar();
	}

	@PostMapping("/convPro")
	public ResponseEntity<ConvProdContDto> agregar(@RequestBody ConvProdContDto convProdContDto) {
		ResponseEntity<ConvProdContDto> response = convProdContService.agregar(convProdContDto);
		return response;
	}

	@PutMapping("/convPro")
	public ResponseEntity<ConvProdContDto> editar(@RequestBody ConvProdContDto convProdContDto) {
		ResponseEntity<ConvProdContDto> response = convProdContService.editar(convProdContDto);
		return response;
	}

	@DeleteMapping("/convPro")
	public void borrar(@PathVariable("id") Long id) {
		convProdContService.eliminar(id);
	}

}
