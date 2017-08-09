/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author user
 */
@Embeddable
public class WidgetsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CHANNELID")
    private String channelid;
    @Basic(optional = false)
    @Column(name = "PAGEID")
    private BigInteger pageid;

    public WidgetsPK() {
    }

    public WidgetsPK(String channelid, BigInteger pageid) {
        this.channelid = channelid;
        this.pageid = pageid;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public BigInteger getPageid() {
        return pageid;
    }

    public void setPageid(BigInteger pageid) {
        this.pageid = pageid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (channelid != null ? channelid.hashCode() : 0);
        hash += (pageid != null ? pageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WidgetsPK)) {
            return false;
        }
        WidgetsPK other = (WidgetsPK) object;
        if ((this.channelid == null && other.channelid != null) || (this.channelid != null && !this.channelid.equals(other.channelid))) {
            return false;
        }
        if ((this.pageid == null && other.pageid != null) || (this.pageid != null && !this.pageid.equals(other.pageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.WidgetsPK[ channelid=" + channelid + ", pageid=" + pageid + " ]";
    }
    
}
