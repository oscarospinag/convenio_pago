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
import gt.com.tigo.convenio.dtos.ConvDiasVenciDto;
import gt.com.tigo.convenio.service.ConvDiasVenciService;

@RestController
@RequestMapping("/api")
public class ConvDiasVenciController {

	@Autowired
	private ConvDiasVenciService convDiasVenciService;

	@GetMapping("/diasVencidos")
	public @ResponseBody ResponseEntity<List<ConvDiasVenciDto>> listar() {
		return (ResponseEntity<List<ConvDiasVenciDto>>) convDiasVenciService.listar();

	}

	@PostMapping("/diasVencidos")
	public ResponseEntity<ConvDiasVenciDto> agregar(@RequestBody ConvDiasVenciDto convDiasVenciDto) {
		ResponseEntity<ConvDiasVenciDto> dto = convDiasVenciService.agregar(convDiasVenciDto);
		return dto;
	}

	@DeleteMapping("diasVencidos/{id}")
	public void delete(@PathVariable("id") Long id) {

		convDiasVenciService.eliminar(id);
	}

	@PutMapping("/diasVencidos/{id}")
	public ResponseEntity<ConvDiasVenciDto> editar(@PathVariable Long id, @RequestBody ConvDiasVenciDto convDiasVenci) {
		ResponseEntity<ConvDiasVenciDto> dto = convDiasVenciService.editar(convDiasVenci);
		convDiasVenci.setId(id);
		return dto;

	}

}
