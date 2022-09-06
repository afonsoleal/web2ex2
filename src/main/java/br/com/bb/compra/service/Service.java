package br.com.bb.compra.service;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public abstract class Service implements ServiceInterface {
    private ServiceResponse response;

    public ServiceResponse getResponse() {
        return this.response;
    }

    protected void buildResponse()
    {
        try {
            this.response = this.run();

        } catch(ClientErrorException
            | ServerErrorException
            e
        ) {
            this.response = new ServiceResponse(
                Status.fromStatusCode(e.getResponse().getStatus()),
                e.getMessage()
            );
        }
    }

    public Response respond()
    {
        this.buildResponse();        

        return Response
            .status(this.response.status)
            .entity(this.response.content)
            .build()
        ;
    }
}
