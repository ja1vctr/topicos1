package br.unitins.topicos1.resource;

import br.unitins.topicos1.model.Estado;
import br.unitins.topicos1.repository.EstadoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/estados")
public class EstadoResource {
    @Inject
    public EstadoRepository estadoRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> findAll(){
        return estadoRepository.listAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void create (Estado estado){
        estadoRepository.persist(estado);
    }
}
