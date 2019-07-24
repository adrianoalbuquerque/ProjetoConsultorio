/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author adria
 */
@Entity
@Table(name = "consulta", catalog = "dbconsultorio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c"),
    @NamedQuery(name = "Consulta.findByIdconsulta", query = "SELECT c FROM Consulta c WHERE c.idconsulta = :idconsulta"),
    @NamedQuery(name = "Consulta.findByIdmedico", query = "SELECT c FROM Consulta c WHERE c.idmedico = :idmedico"),
    @NamedQuery(name = "Consulta.findByPacienteIdpaciente", query = "SELECT c FROM Consulta c WHERE c.pacienteIdpaciente = :pacienteIdpaciente"),
    @NamedQuery(name = "Consulta.findByHora", query = "SELECT c FROM Consulta c WHERE c.hora = :hora"),
    @NamedQuery(name = "Consulta.findByData", query = "SELECT c FROM Consulta c WHERE c.data = :data")})
public class Consulta implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconsulta")
    private Integer idconsulta;
    
    @ManyToOne
    @JoinColumn(name = "idmedico")
    private Medico idmedico;
    
    @ManyToOne
    @JoinColumn(name = "paciente_idpaciente")
    private Paciente pacienteIdpaciente;
    
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    public Consulta() {
    }

    public Consulta(Integer idconsulta) {
        this.idconsulta = idconsulta;
    }

    public Consulta(Integer idconsulta, Medico idmedico, Paciente pacienteIdpaciente) {
        this.idconsulta = idconsulta;
        this.idmedico = idmedico;
        this.pacienteIdpaciente = pacienteIdpaciente;
    }

    public Integer getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(Integer idconsulta) {
        Integer oldIdconsulta = this.idconsulta;
        this.idconsulta = idconsulta;
        changeSupport.firePropertyChange("idconsulta", oldIdconsulta, idconsulta);
    }

    public Medico getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Medico idmedico) {
        Medico oldIdmedico = this.idmedico;
        this.idmedico = idmedico;
        changeSupport.firePropertyChange("idmedico", oldIdmedico, idmedico);
    }

    public Paciente getPacienteIdpaciente() {
        return pacienteIdpaciente;
    }

    public void setPacienteIdpaciente(Paciente pacienteIdpaciente) {
        Paciente oldPacienteIdpaciente = this.pacienteIdpaciente;
        this.pacienteIdpaciente = pacienteIdpaciente;
        changeSupport.firePropertyChange("pacienteIdpaciente", oldPacienteIdpaciente, pacienteIdpaciente);
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsulta != null ? idconsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.idconsulta == null && other.idconsulta != null) || (this.idconsulta != null && !this.idconsulta.equals(other.idconsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Consulta[ idconsulta=" + idconsulta + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
