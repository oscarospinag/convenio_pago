package gt.com.tigo.convenio.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import gt.com.tigo.convenio.dtos.ConvFactDto;
import gt.com.tigo.convenio.dtos.ConvPagoDto;
import gt.com.tigo.convenio.entities.ConvFact;
import gt.com.tigo.convenio.entities.ConvPago;
import gt.com.tigo.convenio.repository.ConvPagoRespository;

@Service
public class ConvPagoImp implements ConvPagoService {

	@Autowired
	private ConvPagoRespository repository;

	@Override
	public List<ConvPagoDto> Listar() {
		List<ConvPagoDto> response = null;
		List<ConvPago> entities = (List<ConvPago>) repository.findAll();
		if (entities != null && entities.size() > 0) {
			response = new ArrayList<>();
			for (ConvPago entity : entities) {
				ConvPagoDto dto = new ConvPagoDto();
				dto.setId(entity.getId());
				dto.setSaldoTotal(entity.getSaldoTotal());
				dto.setSaldoVencido(entity.getSaldoVencido());
				dto.setSaldoVigente(entity.getSaldoVigente());
				dto.setTotalConvenio(entity.getTotalConvenio());
				dto.setCuotas(entity.getCuotas());
				dto.setValorCuota(entity.getValorCuota());
				dto.setTipoProceso(entity.getTipoProceso());
				dto.setTipoBusqueda(entity.getTipoBusqueda());
				dto.setValorBusqueda(entity.getValorBusqueda());
				dto.setNombreCliente(entity.getNombreCliente());
				dto.setCicloFacturacion(entity.getCicloFacturacion());
				dto.setFechaInicioConv(entity.getFechaInicioConv());
				if (entity.getConvFactList() != null && !entity.getConvFactList().isEmpty()) {
					List<ConvFactDto> dtoFact = new ArrayList<>();
					for (ConvFact list : entity.getConvFactList()) {
						ConvFactDto dtof = new ConvFactDto();
						dtof.setAnexo(list.getAnexo());
						dtof.setEstado(list.getEstado());
						dtof.setFechaEmi(list.getFechaEmi());
						dtof.setFechaVenc(list.getFechaVenc());
						dtof.setId(list.getId());
						dtof.setIdPago(list.getIdPago());
						dtof.setLetra(list.getLetra());
						dtof.setMonto(list.getMonto());
						dtof.setNumero(list.getNumero());
						dtof.setTipo(list.getTipo());
						dtoFact.add(dtof);
					}

					dto.setConvFactList(dtoFact);
				}

				response.add(dto);
			}

		}

		return response;
	}

	@Override
	public ResponseEntity<ConvPagoDto> agregar(ConvPagoDto convPagoDto) {

		ConvPagoDto response = null;
		ConvPago entity = new ConvPago();
		entity.setId(convPagoDto.getId());
		entity.setSaldoTotal(convPagoDto.getSaldoTotal());
		entity.setSaldoVencido(convPagoDto.getSaldoVencido());
		entity.setSaldoVigente(convPagoDto.getSaldoVigente());
		entity.setTotalConvenio(convPagoDto.getTotalConvenio());
		entity.setCuotas(convPagoDto.getCuotas());
		entity.setValorCuota(convPagoDto.getValorCuota());
		entity.setTipoProceso(convPagoDto.getTipoProceso());
		entity.setConvFactList(entity.getConvFactList());
		entity.setTipoBusqueda(convPagoDto.getTipoBusqueda());
		entity.setValorBusqueda(convPagoDto.getValorBusqueda());
		entity.setNombreCliente(convPagoDto.getNombreCliente());
		entity.setCicloFacturacion(convPagoDto.getCicloFacturacion());
		entity.setFechaInicioConv(convPagoDto.getFechaInicioConv());
		entity.setUsuario(convPagoDto.getUsuario());
		ConvPago responseEntity = repository.save(entity);
		if (responseEntity != null) {
			response = new ConvPagoDto();
			responseEntity.getId();
			responseEntity.getSaldoTotal();
			responseEntity.getSaldoVencido();
			responseEntity.getSaldoVigente();
			responseEntity.getTotalConvenio();
			responseEntity.getCuotas();
			responseEntity.getValorCuota();
			responseEntity.getTipoProceso();
			responseEntity.getConvFactList();
			responseEntity.getConvFactList();
			responseEntity.getTipoBusqueda();
			responseEntity.getValorBusqueda();
			responseEntity.getNombreCliente();
			responseEntity.getCicloFacturacion();
			responseEntity.getFechaInicioConv();
			responseEntity.getUsuario();

			return new ResponseEntity<ConvPagoDto>(response, HttpStatus.CREATED);

		}

		return new ResponseEntity<ConvPagoDto>(response, HttpStatus.BAD_REQUEST);

	}

	@Override
	public ResponseEntity<ConvPagoDto> editar(ConvPagoDto convPagoDto) {

		ConvPagoDto response = null;
		ConvPago entity = new ConvPago();
		entity.setId(convPagoDto.getId());
		entity.setSaldoTotal(convPagoDto.getSaldoTotal());
		entity.setSaldoVencido(convPagoDto.getSaldoVencido());
		entity.setSaldoVigente(convPagoDto.getSaldoVigente());
		entity.setTotalConvenio(convPagoDto.getTotalConvenio());
		entity.setCuotas(convPagoDto.getCuotas());
		entity.setValorCuota(convPagoDto.getValorCuota());
		entity.setTipoProceso(convPagoDto.getTipoProceso());
		entity.setConvFactList(entity.getConvFactList());
		entity.setTipoBusqueda(convPagoDto.getTipoBusqueda());
		entity.setValorBusqueda(convPagoDto.getValorBusqueda());
		entity.setNombreCliente(convPagoDto.getNombreCliente());
		entity.setCicloFacturacion(convPagoDto.getCicloFacturacion());
		entity.setFechaInicioConv(convPagoDto.getFechaInicioConv());
		entity.setUsuario(convPagoDto.getUsuario());
		ConvPago responseEntity = repository.save(entity);
		if (responseEntity != null) {
			response = new ConvPagoDto();
			responseEntity.getId();
			responseEntity.getSaldoTotal();
			responseEntity.getSaldoVencido();
			responseEntity.getSaldoVigente();
			responseEntity.getTotalConvenio();
			responseEntity.getCuotas();
			responseEntity.getValorCuota();
			responseEntity.getTipoProceso();
			responseEntity.getConvFactList();
			responseEntity.getConvFactList();
			responseEntity.getTipoBusqueda();
			responseEntity.getValorBusqueda();
			responseEntity.getNombreCliente();
			responseEntity.getCicloFacturacion();
			responseEntity.getFechaInicioConv();
			responseEntity.getUsuario();

			return new ResponseEntity<ConvPagoDto>(response, HttpStatus.CREATED);
		}

		return new ResponseEntity<ConvPagoDto>(response, HttpStatus.BAD_REQUEST);

	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		ConvPago entity = repository.findById(id).orElse(null);
		if (entity != null) {
			repository.delete(entity);
		}

	}

	@Override
	public ResponseEntity<ConvPagoDto> ConvPagofindById(Long id) {
		ConvPagoDto response = null;
		// TODO Auto-generated method stub
		ConvPago entity = repository.findById(id).orElse(null);
		if (entity != null) {
			response = new ConvPagoDto();
			response.getId();
			response.getSaldoTotal();
			response.getSaldoVencido();
			response.getSaldoVigente();
			response.getTotalConvenio();
			response.getCuotas();
			response.getValorCuota();
			response.getTipoProceso();
			response.getConvFactList();
			response.getConvFactList();
			response.getTipoBusqueda();
			response.getValorBusqueda();
			response.getNombreCliente();
			response.getCicloFacturacion();
			response.getFechaInicioConv();
			response.getUsuario();

			return new ResponseEntity<ConvPagoDto>(response, HttpStatus.OK);
		}

		return new ResponseEntity<ConvPagoDto>(response, HttpStatus.BAD_REQUEST);

	}
//
//	@Override
//	public List<ConvPagoDto> findAll() {
//		List<ConvPagoDto> response = null;
//		List<ConvPago> entities = (List<ConvPago>) repository.findAll();
//		if (entities != null && entities.size() > 0)
//			response = new ArrayList<>();
//		for (ConvPago entity : entities) {
//			ConvPagoDto responseEntity = new ConvPagoDto();
//			responseEntity.setCicloFacturacion(entity.getCicloFacturacion());
//			responseEntity.setCuotas(entity.getCuotas());
//			responseEntity.setFechaInicioConv(entity.getFechaInicioConv());
//			responseEntity.setId(entity.getId());
//			responseEntity.setNombreCliente(entity.getNombreCliente());
//			responseEntity.setSaldoTotal(entity.getSaldoTotal());
//			responseEntity.setSaldoVencido(entity.getSaldoTotal());
//			responseEntity.setSaldoVigente(entity.getSaldoVigente());
//			responseEntity.setTipoBusqueda(entity.getTipoBusqueda());
//			responseEntity.setTipoProceso(entity.getTipoProceso());
//			responseEntity.setTotalConvenio(entity.getTotalConvenio());
//			responseEntity.setUsuario(entity.getUsuario());
//			responseEntity.setValorBusqueda(entity.getValorBusqueda());
//			responseEntity.setValorCuota(entity.getValorCuota());
//			if (entity.getConvFactList() != null && !entity.getConvFactList().isEmpty()) {
//				List<ConvFactDto> facturadto = new ArrayList<>();
//				for (ConvFact lista : entity.getConvFactList()) {
//					ConvFactDto dtofacturas = new ConvFactDto();
//					dtofacturas.setAnexo(lista.getAnexo());
//					dtofacturas.setEstado(lista.getEstado());
//					dtofacturas.setFechaEmi(lista.getFechaEmi());
//					dtofacturas.setFechaVenc(lista.getFechaVenc());
//					dtofacturas.setId(lista.getId());
//					dtofacturas.setIdPago(lista.getIdPago());
//					dtofacturas.setLetra(lista.getLetra());
//					dtofacturas.setMonto(lista.getMonto());
//					dtofacturas.setNumero(lista.getNumero());
//					dtofacturas.setTipo(lista.getTipo());
//					facturadto.add(dtofacturas);
//				}
//				response.add(responseEntity);
//
//			}
//		}
//
//		return response;
//	}

}
