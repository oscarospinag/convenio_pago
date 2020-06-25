package gt.com.tigo.convenio.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import gt.com.tigo.convenio.dtos.ConvMontoMaxDto;

public interface ConvMontoMaxService {

	public ResponseEntity<List<ConvMontoMaxDto>> listar();

	public ResponseEntity<ConvMontoMaxDto> agregar(ConvMontoMaxDto convMontoMax);

	public ResponseEntity<ConvMontoMaxDto> editar(ConvMontoMaxDto convMontoMax);

	void eliminar(Long id);

	public ResponseEntity<ConvMontoMaxDto> convMontoMaxfindById(Long id);

}
