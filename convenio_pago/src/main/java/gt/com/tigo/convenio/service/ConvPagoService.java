package gt.com.tigo.convenio.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import gt.com.tigo.convenio.dtos.ConvPagoDto;

public interface ConvPagoService {

	List<ConvPagoDto> Listar();

	public ResponseEntity<ConvPagoDto> agregar(ConvPagoDto convPagoDto);

	public ResponseEntity<ConvPagoDto> editar(ConvPagoDto convPagoDto);

	void eliminar(Long id);

	public ResponseEntity<ConvPagoDto> ConvPagofindById(Long id);

	List<ConvPagoDto> findAll() ;

}
