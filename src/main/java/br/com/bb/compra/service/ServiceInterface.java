package br.com.bb.compra.service;

import javax.ws.rs.core.Response;

public interface ServiceInterface {
    public abstract ServiceResponse run();

    public abstract ServiceResponse getResponse();

    public abstract Response respond();
}
