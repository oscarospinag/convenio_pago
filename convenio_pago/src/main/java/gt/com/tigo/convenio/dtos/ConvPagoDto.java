package gt.com.tigo.convenio.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ConvPagoDto implements Serializable {

	   private static final long serialVersionUID = 1L;

	    private Long id;
	    private Double saldoTotal;
	    private Double saldoVencido;
	    private Double saldoVigente;
	    private Double totalConvenio;
	    private Short cuotas;
	    private Double valorCuota;
	    private String tipoProceso;
	    private List<ConvFactDto> convFactList;
	    private String tipoBusqueda;
	    private String valorBusqueda;
	    private String nombreCliente;
	    private String cicloFacturacion;
	    private Date fechaInicioConv;
	    private String usuario;
	    
	    
		public ConvPagoDto() {
		
		}

	    
	
	

}
