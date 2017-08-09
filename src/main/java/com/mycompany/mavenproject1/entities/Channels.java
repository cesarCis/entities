/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "CHANNELS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Channels.findAll", query = "SELECT c FROM Channels c")
    , @NamedQuery(name = "Channels.findByChannelid", query = "SELECT c FROM Channels c WHERE c.channelid = :channelid")
    , @NamedQuery(name = "Channels.findByChannelname", query = "SELECT c FROM Channels c WHERE c.channelname = :channelname")})
public class Channels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CHANNELID")
    private String channelid;
    @Basic(optional = false)
    @Column(name = "CHANNELNAME")
    private String channelname;

    public Channels() {
    }

    public Channels(String channelid) {
        this.channelid = channelid;
    }

    public Channels(String channelid, String channelname) {
        this.channelid = channelid;
        this.channelname = channelname;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (channelid != null ? channelid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Channels)) {
            return false;
        }
        Channels other = (Channels) object;
        if ((this.channelid == null && other.channelid != null) || (this.channelid != null && !this.channelid.equals(other.channelid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.Channels[ channelid=" + channelid + " ]";
    }
    
}
