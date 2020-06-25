package gt.com.tigo.convenio.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import gt.com.tigo.convenio.dtos.ConvProdContDto;

public interface ConvProdContService {

	public ResponseEntity<List<ConvProdContDto>> listar();

	public ResponseEntity<ConvProdContDto> agregar(ConvProdContDto convProdContDto);

	public ResponseEntity<ConvProdContDto> editar(ConvProdContDto convProdContDto);

	void eliminar(Long id);

	public ResponseEntity<ConvProdContDto> ConvProdContfindById(Long id);

}
