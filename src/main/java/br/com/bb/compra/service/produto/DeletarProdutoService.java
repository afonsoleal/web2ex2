package br.com.bb.compra.service.produto;

import br.com.bb.compra.model.entity.ProdutoEntity;
import br.com.bb.compra.repository.ProdutoRepository;
import br.com.bb.compra.service.Service;
import br.com.bb.compra.service.ServiceResponse;
import javax.ws.rs.NotFoundException;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

public class DeletarProdutoService extends Service {
    private long id;

    public long getId() {
        return this.id;
    }

    public DeletarProdutoService(long id) {
        super();

        this.id = id;
    }

    public ServiceResponse run() {
        // @FIXME
        ProdutoRepository repo = new ProdutoRepository();
        ProdutoEntity produto = repo.findById(this.id);

        if (null == produto) {
            throw new NotFoundException();
        }

        repo.delete(produto);

        return new ServiceResponse(NO_CONTENT);
    }
}
