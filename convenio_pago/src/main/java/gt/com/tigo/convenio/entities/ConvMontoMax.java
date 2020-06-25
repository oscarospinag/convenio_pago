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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CONV_MONTO_MAX")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ConvMontoMax.findAll", query = "SELECT c FROM ConvMontoMax c"),
		@NamedQuery(name = "ConvMontoMax.findById", query = "SELECT c FROM ConvMontoMax c WHERE c.id = :id"),
		@NamedQuery(name = "ConvMontoMax.findByDescripcion", query = "SELECT c FROM ConvMontoMax c WHERE c.descripcion = :descripcion"),
		@NamedQuery(name = "ConvMontoMax.findByValor", query = "SELECT c FROM ConvMontoMax c WHERE c.valor = :valor") })
public class ConvMontoMax implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@SequenceGenerator(name = "SEQ_ID_GENERATOR", sequenceName = "CONV_SEQ_MONTO_MAX", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_GENERATOR")
	@Basic(optional = false)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "VALOR")
	private Double valor;

	public ConvMontoMax() {
	}

	public ConvMontoMax(Long id) {
		this.id = id;
	}

	public ConvMontoMax(Long id, String descripcion, Double valor) {
		this.id = id;
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
		if (!(object instanceof ConvMontoMax)) {
			return false;
		}
		ConvMontoMax other = (ConvMontoMax) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "gt.com.tigo.convenio.model.entities.ConvMontoMax[ id=" + id + " ]";
	}

}
