package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.CidadeDTO;
import br.unitins.topicos1.dto.CidadeResponseDTO;
import br.unitins.topicos1.model.Cidade;
import br.unitins.topicos1.repository.CidadeRepository;
import br.unitins.topicos1.service.CidadeService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/Cidades")
public class CidadeResource {
    @Inject
    public CidadeService cidadeService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(cidadeService.findById(id)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(cidadeService.findByNome(nome)).build();
    }

    @GET
    public Response findAll(){
        return Response.ok(cidadeService.findAll()).build();
    }

    @POST
    @Transactional
    public Response create (CidadeDTO dto){
        return Response
                .status(Response.Status.CREATED)
                .entity(cidadeService.create(dto))
                .build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CidadeDTO dto){
        cidadeService.update(id, dto);
        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        cidadeService.delete(id);
        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }
}
