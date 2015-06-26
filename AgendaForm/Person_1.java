/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaForm;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ancy
 */
@Entity
@Table(name = "PERSON", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Person_1.findAll", query = "SELECT p FROM Person_1 p"),
    @NamedQuery(name = "Person_1.findById", query = "SELECT p FROM Person_1 p WHERE p.id = :id"),
    @NamedQuery(name = "Person_1.findByFirstName", query = "SELECT p FROM Person_1 p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Person_1.findByLastName", query = "SELECT p FROM Person_1 p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Person_1.findByTelephone", query = "SELECT p FROM Person_1 p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Person_1.findByPicturePath", query = "SELECT p FROM Person_1 p WHERE p.picturePath = :picturePath"),
    @NamedQuery(name = "Person_1.findByOwnerId", query = "SELECT p FROM Person_1 p WHERE p.ownerId = :ownerId"),
    @NamedQuery(name = "Person_1.findByEmail", query = "SELECT p FROM Person_1 p WHERE p.email = :email")})
public class Person_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "TELEPHONE")
    private String telephone;
    @Column(name = "PICTURE_PATH")
    private String picturePath;
    @Basic(optional = false)
    @Column(name = "OWNER_ID")
    private int ownerId;
    @Column(name = "EMAIL")
    private String email;

    public Person_1() {
    }

    public Person_1(Integer id) {
        this.id = id;
    }

    public Person_1(Integer id, int ownerId) {
        this.id = id;
        this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        String oldTelephone = this.telephone;
        this.telephone = telephone;
        changeSupport.firePropertyChange("telephone", oldTelephone, telephone);
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        String oldPicturePath = this.picturePath;
        this.picturePath = picturePath;
        changeSupport.firePropertyChange("picturePath", oldPicturePath, picturePath);
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        int oldOwnerId = this.ownerId;
        this.ownerId = ownerId;
        changeSupport.firePropertyChange("ownerId", oldOwnerId, ownerId);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
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
        if (!(object instanceof Person_1)) {
            return false;
        }
        Person_1 other = (Person_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AgendaForm.Person_1[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
