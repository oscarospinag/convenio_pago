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
@Table(name = "CONV_MESES")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ConvMeses.findAll", query = "SELECT c FROM ConvMeses c"),
		@NamedQuery(name = "ConvMeses.findById", query = "SELECT c FROM ConvMeses c WHERE c.id = :id"),
		@NamedQuery(name = "ConvMeses.findByDescripcion", query = "SELECT c FROM ConvMeses c WHERE c.descripcion = :descripcion"),
		@NamedQuery(name = "ConvMeses.findByValor", query = "SELECT c FROM ConvMeses c WHERE c.valor = :valor") })
public class ConvMeses implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@SequenceGenerator(name = "SEQ_ID_GENERATOR", sequenceName = "CONV_SEQ_MESES", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_GENERATOR")
	@Basic(optional = false)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "VALOR")
	private Short valor;

	public ConvMeses() {

	}

	public ConvMeses(Long id, String descripcion, Short valor) {
		this.id = id;
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public ConvMeses(Long id) {
		this.id = id;
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

	public Short getValor() {
		return valor;
	}

	public void setValor(Short valor) {
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
		if (!(object instanceof ConvMeses)) {
			return false;
		}
		ConvMeses other = (ConvMeses) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "gt.com.tigo.convenio.model.entities.ConvMeses[ id=" + id + " ]";
	}

}
