/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "WIDGETS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Widgets.findAll", query = "SELECT w FROM Widgets w")
    , @NamedQuery(name = "Widgets.findByChannelid", query = "SELECT w FROM Widgets w WHERE w.widgetsPK.channelid = :channelid")
    , @NamedQuery(name = "Widgets.findByPageid", query = "SELECT w FROM Widgets w WHERE w.widgetsPK.pageid = :pageid")
    , @NamedQuery(name = "Widgets.findByLastupdate", query = "SELECT w FROM Widgets w WHERE w.lastupdate = :lastupdate")})
public class Widgets implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WidgetsPK widgetsPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "WIDGETPREFERENCES")
    private String widgetpreferences;
    @Basic(optional = false)
    @Column(name = "LASTUPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "widgets")
    private List<Userwidgets> userwidgetsList;

    public Widgets() {
    }

    public Widgets(WidgetsPK widgetsPK) {
        this.widgetsPK = widgetsPK;
    }

    public Widgets(WidgetsPK widgetsPK, String widgetpreferences, Date lastupdate) {
        this.widgetsPK = widgetsPK;
        this.widgetpreferences = widgetpreferences;
        this.lastupdate = lastupdate;
    }

    public Widgets(String channelid, BigInteger pageid) {
        this.widgetsPK = new WidgetsPK(channelid, pageid);
    }

    public WidgetsPK getWidgetsPK() {
        return widgetsPK;
    }

    public void setWidgetsPK(WidgetsPK widgetsPK) {
        this.widgetsPK = widgetsPK;
    }

    public String getWidgetpreferences() {
        return widgetpreferences;
    }

    public void setWidgetpreferences(String widgetpreferences) {
        this.widgetpreferences = widgetpreferences;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    @XmlTransient
    public List<Userwidgets> getUserwidgetsList() {
        return userwidgetsList;
    }

    public void setUserwidgetsList(List<Userwidgets> userwidgetsList) {
        this.userwidgetsList = userwidgetsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (widgetsPK != null ? widgetsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Widgets)) {
            return false;
        }
        Widgets other = (Widgets) object;
        if ((this.widgetsPK == null && other.widgetsPK != null) || (this.widgetsPK != null && !this.widgetsPK.equals(other.widgetsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.Widgets[ widgetsPK=" + widgetsPK + " ]";
    }
    
}
