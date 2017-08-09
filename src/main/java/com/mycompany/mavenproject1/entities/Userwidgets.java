/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "USERWIDGETS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userwidgets.findAll", query = "SELECT u FROM Userwidgets u")
    , @NamedQuery(name = "Userwidgets.findByCustomerno", query = "SELECT u FROM Userwidgets u WHERE u.userwidgetsPK.customerno = :customerno")
    , @NamedQuery(name = "Userwidgets.findByChannelid", query = "SELECT u FROM Userwidgets u WHERE u.userwidgetsPK.channelid = :channelid")
    , @NamedQuery(name = "Userwidgets.findByPageid", query = "SELECT u FROM Userwidgets u WHERE u.userwidgetsPK.pageid = :pageid")
    , @NamedQuery(name = "Userwidgets.findByLastupdate", query = "SELECT u FROM Userwidgets u WHERE u.lastupdate = :lastupdate")})
public class Userwidgets implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserwidgetsPK userwidgetsPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "CUSTOMERPREFERENCES")
    private String customerpreferences;
    @Basic(optional = false)
    @Column(name = "LASTUPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdate;
    @JoinColumns({
        @JoinColumn(name = "PAGEID", referencedColumnName = "PAGEID", insertable = false, updatable = false)
        , @JoinColumn(name = "CHANNELID", referencedColumnName = "CHANNELID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Widgets widgets;

    public Userwidgets() {
    }

    public Userwidgets(UserwidgetsPK userwidgetsPK) {
        this.userwidgetsPK = userwidgetsPK;
    }

    public Userwidgets(UserwidgetsPK userwidgetsPK, String customerpreferences, Date lastupdate) {
        this.userwidgetsPK = userwidgetsPK;
        this.customerpreferences = customerpreferences;
        this.lastupdate = lastupdate;
    }

    public Userwidgets(String customerno, String channelid, BigInteger pageid) {
        this.userwidgetsPK = new UserwidgetsPK(customerno, channelid, pageid);
    }

    public UserwidgetsPK getUserwidgetsPK() {
        return userwidgetsPK;
    }

    public void setUserwidgetsPK(UserwidgetsPK userwidgetsPK) {
        this.userwidgetsPK = userwidgetsPK;
    }

    public String getCustomerpreferences() {
        return customerpreferences;
    }

    public void setCustomerpreferences(String customerpreferences) {
        this.customerpreferences = customerpreferences;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public Widgets getWidgets() {
        return widgets;
    }

    public void setWidgets(Widgets widgets) {
        this.widgets = widgets;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userwidgetsPK != null ? userwidgetsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userwidgets)) {
            return false;
        }
        Userwidgets other = (Userwidgets) object;
        if ((this.userwidgetsPK == null && other.userwidgetsPK != null) || (this.userwidgetsPK != null && !this.userwidgetsPK.equals(other.userwidgetsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.Userwidgets[ userwidgetsPK=" + userwidgetsPK + " ]";
    }
    
}
