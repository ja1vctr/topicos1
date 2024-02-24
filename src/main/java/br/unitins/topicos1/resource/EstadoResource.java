package br.unitins.topicos1.resource;

import br.unitins.topicos1.model.Estado;
import br.unitins.topicos1.repository.EstadoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/estados")
public class EstadoResource {
    @Inject
    public EstadoRepository estadoRepository;

    @GET
    @Path("/{id}")
    public Estado findById(@PathParam("id") Long id){
        return estadoRepository.findById(id);
    }

    @GET
    public List<Estado> findAll(){
        return estadoRepository.listAll();
    }
    @POST
    @Transactional
    public void create (Estado estado){
        estadoRepository.persist(estado);
    }
}
