package gt.com.tigo.convenio.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import gt.com.tigo.convenio.dtos.ConvProdContDto;
import gt.com.tigo.convenio.entities.ConvProdCont;
import gt.com.tigo.convenio.repository.ConvProdContRepository;

@Service
public class ConvProdContDtoImp implements ConvProdContService {

	@Autowired
	private ConvProdContRepository repository;

	@Override
	public ResponseEntity<List<ConvProdContDto>> listar() {
		List<ConvProdContDto> response = null;
		List<ConvProdCont> entities = (List<ConvProdCont>) repository.findAll();
		if (entities != null && entities.size() > 0) {
			response = new ArrayList<>();
			for (ConvProdCont entity : entities) {
				ConvProdContDto dto = new ConvProdContDto(entity.getId(), entity.getDescripcion(),
						entity.getDescripcion(), entity.getTipoProducto());
				response.add(dto);
			}
			return new ResponseEntity<List<ConvProdContDto>>(response, HttpStatus.OK);

		}
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<ConvProdContDto> agregar(ConvProdContDto convProdContDto) {
		ConvProdContDto response = null;
		ConvProdCont entity = new ConvProdCont();
		entity.setId(convProdContDto.getId());
		entity.setDescripcion(convProdContDto.getDescripcion());
		entity.setTipoContrato(convProdContDto.getDescripcion());
		entity.setTipoProducto(convProdContDto.getTipoProducto());
		ConvProdCont entityDB = repository.save(entity);
		if (entityDB != null) {
			response = new ConvProdContDto(entityDB.getId(), entityDB.getDescripcion(), entityDB.getTipoContrato(),
					entityDB.getTipoProducto());

			return new ResponseEntity<ConvProdContDto>(response, HttpStatus.OK);
		}

		return new ResponseEntity<ConvProdContDto>(response, HttpStatus.BAD_REQUEST);

	}

	@Override
	public ResponseEntity<ConvProdContDto> editar(ConvProdContDto convProdContDto) {
		// TODO Auto-generated method stub
		ConvProdContDto response = null;
		ConvProdCont entity = new ConvProdCont();
		entity.setId(convProdContDto.getId());
		entity.setDescripcion(convProdContDto.getDescripcion());
		entity.setTipoContrato(convProdContDto.getTipoContrato());
		entity.setTipoProducto(convProdContDto.getTipoProducto());
		ConvProdCont entityBD = repository.save(entity);

		if (entityBD != null) {
			response = new ConvProdContDto(entityBD.getId(), entityBD.getDescripcion(), entityBD.getTipoContrato(),
					entityBD.getTipoProducto());

			return new ResponseEntity<ConvProdContDto>(response, HttpStatus.OK);
		}

		return new ResponseEntity<ConvProdContDto>(response, HttpStatus.BAD_REQUEST);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		ConvProdCont entity = repository.findById(id).orElse(null);
		if (entity != null) {
			repository.delete(entity);
		}

	}

	@Override
	public ResponseEntity<ConvProdContDto> ConvProdContfindById(Long id) {
		ConvProdContDto response = null;
		ConvProdCont entity = repository.findById(id).orElse(null);
		if (entity != null) {
			response = new ConvProdContDto(entity.getId(), entity.getDescripcion(), entity.getTipoContrato(),
					entity.getTipoProducto());

			return new ResponseEntity<ConvProdContDto>(response, HttpStatus.OK);
		}

		return new ResponseEntity<ConvProdContDto>(response, HttpStatus.BAD_REQUEST);
	}

}
