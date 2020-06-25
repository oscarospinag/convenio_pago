/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.tigo.convenio.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "CONV_PAGO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ConvPago.findAll", query = "SELECT c FROM ConvPago c")
        , @NamedQuery(name = "ConvPago.findById", query = "SELECT c FROM ConvPago c WHERE c.id = :id")
        , @NamedQuery(name = "ConvPago.findBySaldoTotal", query = "SELECT c FROM ConvPago c WHERE c.saldoTotal = :saldoTotal")
        , @NamedQuery(name = "ConvPago.findBySaldoVencido", query = "SELECT c FROM ConvPago c WHERE c.saldoVencido = :saldoVencido")
        , @NamedQuery(name = "ConvPago.findBySaldoVigente", query = "SELECT c FROM ConvPago c WHERE c.saldoVigente = :saldoVigente")
        , @NamedQuery(name = "ConvPago.findByTotalConvenio", query = "SELECT c FROM ConvPago c WHERE c.totalConvenio = :totalConvenio")
        , @NamedQuery(name = "ConvPago.findByCuotas", query = "SELECT c FROM ConvPago c WHERE c.cuotas = :cuotas")
        , @NamedQuery(name = "ConvPago.findByValorCuota", query = "SELECT c FROM ConvPago c WHERE c.valorCuota = :valorCuota")
        , @NamedQuery(name = "ConvPago.findByTipoProceso", query = "SELECT c FROM ConvPago c WHERE c.tipoProceso = :tipoProceso")})
public class ConvPago implements Serializable {


    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ_ID_GENERATOR",sequenceName = "CONV_SEQ_PAGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "SALDO_TOTAL")
    private Double saldoTotal;
    @Column(name = "SALDO_VENCIDO")
    private Double saldoVencido;
    @Column(name = "SALDO_VIGENTE")
    private Double saldoVigente;
    @Column(name = "TOTAL_CONVENIO")
    private Double totalConvenio;
    @Column(name = "CUOTAS")
    private Short cuotas;
    @Column(name = "VALOR_CUOTA")
    private Double valorCuota;
    @Basic(optional = false)
    @Column(name = "TIPO_PROCESO")
    private String tipoProceso;
    @OneToMany(mappedBy = "idPago", fetch = FetchType.LAZY)
    private List<ConvFact> convFactList;
    @Column(name = "TIPO_BUSQUEDA")
    private String tipoBusqueda;
    @Column(name = "VALOR_BUSQUEDA")
    private String valorBusqueda;
    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;
    @Column(name = "CICLO_FACTURACION")
    private String cicloFacturacion;
    @Column(name = "FECHA_INICIO_CONV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioConv;
    @Column(name = "USUARIO")
    private String usuario;

    public ConvPago() {
    }

    public ConvPago(Long id) {
        this.id = id;
    }

    public ConvPago(Long id, String tipoProceso) {
        this.id = id;
        this.tipoProceso = tipoProceso;
    }

    public ConvPago(Long id,Double saldoTotal, Double saldoVencido, Double saldoVigente, Double totalConvenio, Short cuotas, Double valorCuota, String tipoProceso, List<ConvFact> convFactList, String tipoBusqueda, String valorBusqueda, String nombreCliente, String cicloFacturacion, Date fechaInicioConv, String usuario) {
        this.id = id;
        this.saldoTotal = saldoTotal;
        this.saldoVencido = saldoVencido;
        this.saldoVigente = saldoVigente;
        this.totalConvenio = totalConvenio;
        this.cuotas = cuotas;
        this.valorCuota = valorCuota;
        this.tipoProceso = tipoProceso;
        this.convFactList = convFactList;
        this.tipoBusqueda = tipoBusqueda;
        this.valorBusqueda = valorBusqueda;
        this.nombreCliente = nombreCliente;
        this.cicloFacturacion = cicloFacturacion;
        this.fechaInicioConv = fechaInicioConv;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(Double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public Double getSaldoVencido() {
        return saldoVencido;
    }

    public void setSaldoVencido(Double saldoVencido) {
        this.saldoVencido = saldoVencido;
    }

    public Double getSaldoVigente() {
        return saldoVigente;
    }

    public void setSaldoVigente(Double saldoVigente) {
        this.saldoVigente = saldoVigente;
    }

    public Double getTotalConvenio() {
        return totalConvenio;
    }

    public void setTotalConvenio(Double totalConvenio) {
        this.totalConvenio = totalConvenio;
    }

    public Short getCuotas() {
        return cuotas;
    }

    public void setCuotas(Short cuotas) {
        this.cuotas = cuotas;
    }

    public Double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(Double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public String getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    @XmlTransient
    public List<ConvFact> getConvFactList() {
        return convFactList;
    }

    public void setConvFactList(List<ConvFact> convFactList) {
        this.convFactList = convFactList;
    }

    public String getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(String tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    public String getValorBusqueda() {
        return valorBusqueda;
    }

    public void setValorBusqueda(String valorBusqueda) {
        this.valorBusqueda = valorBusqueda;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCicloFacturacion() {
        return cicloFacturacion;
    }

    public void setCicloFacturacion(String cicloFacturacion) {
        this.cicloFacturacion = cicloFacturacion;
    }

    public Date getFechaInicioConv() {
        return fechaInicioConv;
    }

    public void setFechaInicioConv(Date fechaInicioConv) {
        this.fechaInicioConv = fechaInicioConv;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof ConvPago)) {
            return false;
        }
        ConvPago other = (ConvPago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.tigo.convenio.model.entities.ConvPago[ id=" + id + " ]";
    }

}
