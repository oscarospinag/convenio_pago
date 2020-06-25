package gt.com.tigo.convenio.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConvProdContDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private String tipoContrato;
	private String tipoProducto;

}
