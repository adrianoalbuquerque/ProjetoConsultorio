/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author adria
 */
@Entity
@Table(name = "medico", catalog = "dbconsultorio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
    @NamedQuery(name = "Medico.findByIdmedico", query = "SELECT m FROM Medico m WHERE m.idmedico = :idmedico"),
    @NamedQuery(name = "Medico.findByMedico", query = "SELECT m FROM Medico m WHERE m.medico = :medico"),
    @NamedQuery(name = "Medico.findByCpf", query = "SELECT m FROM Medico m WHERE m.cpf = :cpf"),
    @NamedQuery(name = "Medico.findByRg", query = "SELECT m FROM Medico m WHERE m.rg = :rg"),
    @NamedQuery(name = "Medico.findByCrm", query = "SELECT m FROM Medico m WHERE m.crm = :crm"),
    @NamedQuery(name = "Medico.findByIdade", query = "SELECT m FROM Medico m WHERE m.idade = :idade"),
    @NamedQuery(name = "Medico.findByEspecialidade", query = "SELECT m FROM Medico m WHERE m.especialidade = :especialidade"),
    @NamedQuery(name = "Medico.findByTelefone", query = "SELECT m FROM Medico m WHERE m.telefone = :telefone")})
public class Medico implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedico")
    private Integer idmedico;
    @Column(name = "medico")
    private String medico;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "crm")
    private String crm;
    @Column(name = "idade")
    private Integer idade;
    @Column(name = "especialidade")
    private String especialidade;
    @Column(name = "telefone")
    private String telefone;

    public Medico() {
    }

    public Medico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public Integer getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Integer idmedico) {
        Integer oldIdmedico = this.idmedico;
        this.idmedico = idmedico;
        changeSupport.firePropertyChange("idmedico", oldIdmedico, idmedico);
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        String oldMedico = this.medico;
        this.medico = medico;
        changeSupport.firePropertyChange("medico", oldMedico, medico);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        String oldRg = this.rg;
        this.rg = rg;
        changeSupport.firePropertyChange("rg", oldRg, rg);
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        String oldCrm = this.crm;
        this.crm = crm;
        changeSupport.firePropertyChange("crm", oldCrm, crm);
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        Integer oldIdade = this.idade;
        this.idade = idade;
        changeSupport.firePropertyChange("idade", oldIdade, idade);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        String oldEspecialidade = this.especialidade;
        this.especialidade = especialidade;
        changeSupport.firePropertyChange("especialidade", oldEspecialidade, especialidade);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedico != null ? idmedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.idmedico == null && other.idmedico != null) || (this.idmedico != null && !this.idmedico.equals(other.idmedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.medico;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
