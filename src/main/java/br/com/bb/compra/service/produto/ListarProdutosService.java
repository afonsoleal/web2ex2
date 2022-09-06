package br.com.bb.compra.service.produto;

import br.com.bb.compra.repository.ProdutoRepository;
import br.com.bb.compra.service.Service;
import br.com.bb.compra.service.ServiceResponse;
import static javax.ws.rs.core.Response.Status.OK;

public class ListarProdutosService extends Service {

    public ServiceResponse run() {
        // @FIXME
        ProdutoRepository repo = new ProdutoRepository();

        return new ServiceResponse(OK, repo.listAll());
    }
}
