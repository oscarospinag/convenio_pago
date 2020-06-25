package gt.com.tigo.convenio.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import gt.com.tigo.convenio.dtos.ConvMesesDto;
import gt.com.tigo.convenio.entities.ConvMeses;
import gt.com.tigo.convenio.repository.ConvMesesReporitory;

@Service
public class ConvMesesImp implements ConvMesesService {

	@Autowired
	private ConvMesesReporitory repository;

	@Override
	public ResponseEntity<List<ConvMesesDto>> listar() {
		// TODO Auto-generated method stub
		List<ConvMeses> entities = (List<ConvMeses>) repository.findAll();
		List<ConvMesesDto> dtos = null;
		if (entities != null && entities.size() > 0) {
			dtos = new ArrayList<ConvMesesDto>();
			for (ConvMeses entity : entities) {
				ConvMesesDto dto = new ConvMesesDto(entity.getId(), entity.getDescripcion(), entity.getValor());
				dtos.add(dto);
			}

			return new ResponseEntity<List<ConvMesesDto>>(dtos, HttpStatus.OK);
		}

		return new ResponseEntity<>(dtos, HttpStatus.NOT_FOUND);

	}

	@Override
	public ResponseEntity<ConvMesesDto> agregar(ConvMesesDto convMesesDto) {
		ConvMesesDto response = null;
		ConvMeses entity = new ConvMeses();
		entity.setId(convMesesDto.getId());
		entity.setDescripcion(convMesesDto.getDescripcion());
		entity.setValor(convMesesDto.getValor());
		ConvMeses responseEntity = repository.save(entity);
		if (responseEntity != null) {
			response = new ConvMesesDto(responseEntity.getId(), responseEntity.getDescripcion(),
					responseEntity.getValor());

			return new ResponseEntity<ConvMesesDto>(response, HttpStatus.CREATED);
		}

		return new ResponseEntity<ConvMesesDto>(response, HttpStatus.BAD_REQUEST);

	}

	@Override
	public ResponseEntity<ConvMesesDto> editar(ConvMesesDto convMesesDto) {
		ConvMeses entity = new ConvMeses();
		entity.setId(convMesesDto.getId());
		entity.setDescripcion(convMesesDto.getDescripcion());
		entity.setValor(convMesesDto.getValor());
		ConvMeses responseEntity = repository.save(entity);
		ConvMesesDto response = null;
		if (responseEntity != null) {
			response = new ConvMesesDto(responseEntity.getId(), responseEntity.getDescripcion(),
					responseEntity.getValor());

			return new ResponseEntity<ConvMesesDto>(response, HttpStatus.CREATED);

		}

		return new ResponseEntity<ConvMesesDto>(response, HttpStatus.BAD_REQUEST);
	}

	@Override
	public void eliminar(Long id) {
		ConvMeses entity = repository.findById(id).orElse(null);
		if (entity != null) {
			repository.delete(entity);
		}

	}

	@Override
	public ResponseEntity<ConvMesesDto> ConvenioMesesfindById(Long id) {
		// TODO Auto-generated method stub
		ConvMesesDto response = null;
		ConvMeses entity = repository.findById(id).orElse(null);
		if (entity != null) {
			response = new ConvMesesDto(entity.getId(), entity.getDescripcion(), entity.getValor());

			return new ResponseEntity<ConvMesesDto>(response, HttpStatus.OK);
		}

		return new ResponseEntity<ConvMesesDto>(response, HttpStatus.BAD_REQUEST);

	}

}
