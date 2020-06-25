package gt.com.tigo.convenio.dtos;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ConvDiasVenciDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Short valor;

	public ConvDiasVenciDto(Long id, String descripcion, Short valor) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public ConvDiasVenciDto() {
		super();
	}
	
	

}
