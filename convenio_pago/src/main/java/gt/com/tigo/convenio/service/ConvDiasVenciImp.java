package gt.com.tigo.convenio.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import gt.com.tigo.convenio.dtos.ConvDiasVenciDto;
import gt.com.tigo.convenio.entities.ConvDiasVenci;
import gt.com.tigo.convenio.repository.ConvDiasVenciRepository;

@Service
public class ConvDiasVenciImp implements ConvDiasVenciService {

	@Autowired
	private ConvDiasVenciRepository repository;

	@Override
	public ResponseEntity<List<ConvDiasVenciDto>> listar() {
		// TODO Auto-generated method stub
		List<ConvDiasVenciDto> dtos = null;
		List<ConvDiasVenci> entities = (List<ConvDiasVenci>) repository.findAll();
		if (entities != null && entities.size() > 0) {
			dtos = new ArrayList<>();
			for (ConvDiasVenci entity : entities) {
				ConvDiasVenciDto dto = new ConvDiasVenciDto(entity.getId(), entity.getDescripcion(), entity.getValor());
				dtos.add(dto);
			}
			return new ResponseEntity<List<ConvDiasVenciDto>>(dtos, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(dtos, HttpStatus.CONFLICT);
		}

	}

	@Override
	@ResponseStatus
	public ResponseEntity<ConvDiasVenciDto> agregar(ConvDiasVenciDto convDiasVenci) {
		// TODO Auto-generated method stub
		ConvDiasVenciDto response = null;
		ConvDiasVenci entity = new ConvDiasVenci();
		entity.setDescripcion(convDiasVenci.getDescripcion());
		entity.setValor(convDiasVenci.getValor());
		ConvDiasVenci entityDB = repository.save(entity);
		if (entityDB != null) {
			response = new ConvDiasVenciDto(entityDB.getId(), entityDB.getDescripcion(), entityDB.getValor());

			return new ResponseEntity<ConvDiasVenciDto>(response, HttpStatus.CREATED);
		}

		return new ResponseEntity<ConvDiasVenciDto>(response, HttpStatus.BAD_REQUEST);

	}

	@Override
	public ResponseEntity<ConvDiasVenciDto> editar(ConvDiasVenciDto convDiasVenci) {
		// TODO Auto-generated method stub
		ConvDiasVenciDto response = null;
		ConvDiasVenci entity = new ConvDiasVenci();
		entity.setId(convDiasVenci.getId());
		entity.setDescripcion(convDiasVenci.getDescripcion());
		entity.setValor(convDiasVenci.getValor());
		ConvDiasVenci entityDB = repository.save(entity);
		if (entityDB != null) {
			response = new ConvDiasVenciDto(entityDB.getId(), entityDB.getDescripcion(), entityDB.getValor());

			return new ResponseEntity<ConvDiasVenciDto>(response, HttpStatus.CREATED);
		}

		return new ResponseEntity<ConvDiasVenciDto>(response, HttpStatus.BAD_REQUEST);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		ConvDiasVenci entity = repository.findById(id).orElse(null);
		if (entity != null) {
			repository.delete(entity);
		}

	}

	@Override
	public ResponseEntity<ConvDiasVenciDto> ConvDiasVencifindById(Long id) {
		ConvDiasVenciDto response = null;
		ConvDiasVenci entity = repository.findById(id).orElse(null);
		if (entity != null) {
			response = new ConvDiasVenciDto(entity.getId(), entity.getDescripcion(), entity.getValor());
		}

		return new ResponseEntity<ConvDiasVenciDto>(response, HttpStatus.ACCEPTED);

	}

}
