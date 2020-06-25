package gt.com.tigo.convenio.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import gt.com.tigo.convenio.dtos.ConvDiasVenciDto;

public interface ConvDiasVenciService {

	public ResponseEntity<List<ConvDiasVenciDto>> listar();

	public ResponseEntity<ConvDiasVenciDto> agregar(ConvDiasVenciDto convDiasVenci);

	public ResponseEntity<ConvDiasVenciDto> editar(ConvDiasVenciDto convDiasVenci);

	void eliminar(Long id);

	public ResponseEntity<ConvDiasVenciDto> ConvDiasVencifindById(Long id);
}
