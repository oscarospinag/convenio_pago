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
@Table(name = "CONV_PROD_CONT")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ConvProdCont.findAll", query = "SELECT c FROM ConvProdCont c")
        , @NamedQuery(name = "ConvProdCont.findById", query = "SELECT c FROM ConvProdCont c WHERE c.id = :id")
        , @NamedQuery(name = "ConvProdCont.findByTipoContrato", query = "SELECT c FROM ConvProdCont c WHERE c.tipoContrato = :tipoContrato")
        , @NamedQuery(name = "ConvProdCont.findByTipoProducto", query = "SELECT c FROM ConvProdCont c WHERE c.tipoProducto = :tipoProducto")
        , @NamedQuery(name = "ConvProdCont.findByDescripcion", query = "SELECT c FROM ConvProdCont c WHERE c.descripcion = :descripcion")})
public class ConvProdCont implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_ID_GENERATOR",sequenceName = "CONV_SEQ_PROD_CONT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "TIPO_CONTRATO")
    private String tipoContrato;
    @Column(name = "TIPO_PRODUCTO")
    private String tipoProducto;

    public ConvProdCont() {
    }

    public ConvProdCont(Long id) {
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

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
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
        if (!(object instanceof ConvProdCont)) {
            return false;
        }
        ConvProdCont other = (ConvProdCont) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.tigo.convenio.model.entities.ConvProdCont[ id=" + id + " ]";
    }

}

