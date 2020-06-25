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
import gt.com.tigo.convenio.dtos.ConvPagoDto;
import gt.com.tigo.convenio.service.ConvPagoService;

@RestController
@RequestMapping("/api")
public class ConvPagoController {

	@Autowired
	private ConvPagoService convPagoService;

	@GetMapping("/ConvPago")
	public @ResponseBody List<ConvPagoDto> listar() {
		return (List<ConvPagoDto>) convPagoService.Listar();
	}

	@PostMapping("/ConvPago")
	public ResponseEntity<ConvPagoDto> agregar(@RequestBody ConvPagoDto convPagoDto) {
		ResponseEntity<ConvPagoDto> dto = convPagoService.agregar(convPagoDto);
		return dto;
	}

	@PutMapping("/ConvPago")
	public ResponseEntity<ConvPagoDto> editar(@RequestBody ConvPagoDto convPagoDto) {
		ResponseEntity<ConvPagoDto> dto = convPagoService.agregar(convPagoDto);
		return dto;
	}

	@DeleteMapping("ConvPago/{id}")
	public void delete(@PathVariable("id") Long id) {

		convPagoService.eliminar(id);
	}

}
