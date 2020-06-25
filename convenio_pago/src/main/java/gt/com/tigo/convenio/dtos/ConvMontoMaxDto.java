package gt.com.tigo.convenio.dtos;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ConvMontoMaxDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Double valor;

}
