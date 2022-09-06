package br.com.bb.compra.service;

import javax.ws.rs.core.Response.Status;

public class ServiceResponse {
    public final Status status;
    public final Object content;
    
    public ServiceResponse(Status status, Object content) {
        this.status = status;
        this.content = content;
    }

    public ServiceResponse(Status status) {
        this.status = status;
        this.content = null;
    }
}
