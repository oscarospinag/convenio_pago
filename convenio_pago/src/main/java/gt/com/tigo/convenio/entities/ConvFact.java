/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.tigo.convenio.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CONV_FACT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ConvFact.findAll", query = "SELECT c FROM ConvFact c"),
		@NamedQuery(name = "ConvFact.findById", query = "SELECT c FROM ConvFact c WHERE c.id = :id"),
		@NamedQuery(name = "ConvFact.findByTipo", query = "SELECT c FROM ConvFact c WHERE c.tipo = :tipo"),
		@NamedQuery(name = "ConvFact.findByNumero", query = "SELECT c FROM ConvFact c WHERE c.numero = :numero"),
		@NamedQuery(name = "ConvFact.findByMonto", query = "SELECT c FROM ConvFact c WHERE c.monto = :monto"),
		@NamedQuery(name = "ConvFact.findByEstado", query = "SELECT c FROM ConvFact c WHERE c.estado = :estado"),
		@NamedQuery(name = "ConvFact.findByAnexo", query = "SELECT c FROM ConvFact c WHERE c.anexo = :anexo") })
public class ConvFact implements Serializable {

	  private static final long serialVersionUID = 1L;
	    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	    @Id
	    @SequenceGenerator(name = "SEQ_ID_GENERATOR",sequenceName = "CONV_SEQ_FACT", allocationSize = 1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_GENERATOR")
	    @Basic(optional = false)
	    @Column(name = "ID")
	    private Long id;
	    @Column(name = "TIPO")
	    private String tipo;
	    @Column(name = "NUMERO")
	    private String numero;
	    @Column(name = "MONTO")
	    private Double monto;
	    @Column(name = "ESTADO")
	    private String estado;
	    @Column(name = "ANEXO")
	    private String anexo;
	    @JoinColumn(name = "ID_PAGO", referencedColumnName = "ID")
	    @ManyToOne(fetch = FetchType.LAZY)
	    private ConvPago idPago;
	    @Column(name = "LETRA")
	    private String letra;
	    @Column(name = "FECHA_EMI")
	    private String fechaEmi;
	    @Column(name = "FECHA_VENC")
	    private String fechaVenc;

	    public ConvFact() {
	    }

	    public ConvFact(Long id) {
	        this.id = id;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getTipo() {
	        return tipo;
	    }

	    public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }

	    public String getNumero() {
	        return numero;
	    }

	    public void setNumero(String numero) {
	        this.numero = numero;
	    }

	    public Double getMonto() {
	        return monto;
	    }

	    public void setMonto(Double monto) {
	        this.monto = monto;
	    }

	    public String getEstado() {
	        return estado;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }

	    public String getAnexo() {
	        return anexo;
	    }

	    public void setAnexo(String anexo) {
	        this.anexo = anexo;
	    }

	    public ConvPago getIdPago() {
	        return idPago;
	    }

	    public void setIdPago(ConvPago idPago) {
	        this.idPago = idPago;
	    }

	    public String getLetra() {
	        return letra;
	    }

	    public void setLetra(String letra) {
	        this.letra = letra;
	    }

	    public String getFechaEmi() {
	        return fechaEmi;
	    }

	    public void setFechaEmi(String fechaEmi) {
	        this.fechaEmi = fechaEmi;
	    }

	    public String getFechaVenc() {
	        return fechaVenc;
	    }

	    public void setFechaVenc(String fechaVenc) {
	        this.fechaVenc = fechaVenc;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (id != null ? id.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof ConvFact)) {
	            return false;
	        }
	        ConvFact other = (ConvFact) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "gt.com.tigo.convenio.model.entities.ConvFact[ id=" + id + " ]";
	    }
}
