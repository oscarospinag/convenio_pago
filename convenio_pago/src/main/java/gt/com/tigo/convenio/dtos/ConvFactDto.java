package gt.com.tigo.convenio.dtos;

import java.io.Serializable;

import gt.com.tigo.convenio.entities.ConvPago;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvFactDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String tipo;
	private String numero;
	private Double monto;
	private String estado;
	private String anexo;
	private ConvPago idPago;
	private String letra;
	private String fechaEmi;
	private String fechaVenc;

	public ConvFactDto() {
		super();
	}

}
