package br.unitins.topicos1.resource;

import br.unitins.topicos1.model.Pessoa;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/pessoas")
public class PessoaResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> listAll(){
        return Pessoa.listAll();
    }
}
