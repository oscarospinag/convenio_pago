package gt.com.tigo.convenio.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import gt.com.tigo.convenio.dtos.ConvMontoMaxDto;
import gt.com.tigo.convenio.entities.ConvMontoMax;
import gt.com.tigo.convenio.repository.ConvMontoMaxRepository;

@Service
@ResponseStatus
public class ConvMontoMaxImpl implements ConvMontoMaxService {

	@Autowired
	private ConvMontoMaxRepository repository;

	@Override
	public ResponseEntity<List<ConvMontoMaxDto>> listar() {
		List<ConvMontoMaxDto> dtos = null;
		List<ConvMontoMax> entities = (List<ConvMontoMax>) repository.findAll();
		if (entities != null && entities.size() >= 0) {
			dtos = new ArrayList<>();
			for (ConvMontoMax entity : entities) {
				ConvMontoMaxDto dto = new ConvMontoMaxDto(entity.getId(), entity.getDescripcion(), entity.getValor());
				dtos.add(dto);
			}

			return new ResponseEntity<List<ConvMontoMaxDto>>(dtos, HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<>(dtos, HttpStatus.BAD_REQUEST);

	}

	@Override
	public ResponseEntity<ConvMontoMaxDto> agregar(ConvMontoMaxDto convMontoMaxDto) {
		// TODO Auto-generated method stub
		ConvMontoMaxDto response = null;
		ConvMontoMax entity = new ConvMontoMax();
		entity.setId(convMontoMaxDto.getId());
		entity.setDescripcion(convMontoMaxDto.getDescripcion());
		entity.setValor(convMontoMaxDto.getValor());
		ConvMontoMax responseEntity = repository.save(entity);
		if (responseEntity != null) {
			response = new ConvMontoMaxDto(responseEntity.getId(), responseEntity.getDescripcion(),
					responseEntity.getValor());

			return new ResponseEntity<ConvMontoMaxDto>(response, HttpStatus.CREATED);
		}

		return new ResponseEntity<ConvMontoMaxDto>(response, HttpStatus.CONFLICT);

	}

	@Override
	public ResponseEntity<ConvMontoMaxDto> editar(ConvMontoMaxDto convMontoMax) {
		ConvMontoMaxDto response = null;
		ConvMontoMax entity = new ConvMontoMax();
		entity.setId(convMontoMax.getId());
		entity.setDescripcion(convMontoMax.getDescripcion());
		entity.setValor(convMontoMax.getValor());
		ConvMontoMax responseEntity = repository.save(entity);
		if (responseEntity != null) {
			response = new ConvMontoMaxDto(entity.getId(), entity.getDescripcion(), entity.getValor());

			return new ResponseEntity<ConvMontoMaxDto>(response, HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<ConvMontoMaxDto>(response, HttpStatus.ACCEPTED);

	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		ConvMontoMax entity = repository.findById(id).orElse(null);
		if (entity != null) {
			repository.delete(entity);
		}

	}

	@Override
	public ResponseEntity<ConvMontoMaxDto> convMontoMaxfindById(Long id) {
		ConvMontoMaxDto response = null;
		// TODO Auto-generated method stub
		ConvMontoMax entity = repository.findById(id).orElse(null);
		if (entity != null) {
			response = new ConvMontoMaxDto(entity.getId(), entity.getDescripcion(), entity.getValor());

			return new ResponseEntity<ConvMontoMaxDto>(response, HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<ConvMontoMaxDto>(response, HttpStatus.CONFLICT);

	}

}
