package gt.com.tigo.convenio.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import gt.com.tigo.convenio.dtos.ConvMesesDto;

public interface ConvMesesService {

	public ResponseEntity<List<ConvMesesDto>> listar();

	public ResponseEntity<ConvMesesDto> agregar(ConvMesesDto convMesesDto);

	public ResponseEntity<ConvMesesDto> editar(ConvMesesDto convMesesDto);

	void eliminar(Long id);

	public ResponseEntity<ConvMesesDto> ConvenioMesesfindById(Long id);

}
