package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.EstadoDTO;
import br.unitins.topicos1.service.EstadoService;

import jakarta.enterprise.inject.build.compatible.spi.Validation;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/estados")
public class EstadoResource {
    @Inject
    public EstadoService estatdoService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(estatdoService.findById(id)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(estatdoService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/sigla/{sigla}")
    public Response findBySigla(@PathParam("sigla") String sigla){
        return Response
                .ok(estatdoService.findBySigla(sigla))
                .build();
    }

    @GET
    public Response findAll(){
//        Opcao 1: forma de passar a informação do estadoRepository.listAll() pelo ResponseDTO
//
//        List<Estado> lista = estadoRepository.listAll();
//        List<EstadoResponseDTO> listaDTO = new ArrayList<EstadoResponseDTO>();
//        for(Estado estado : lista){
//            listaDTO.add(EstadoResponseDTO.valueOf(estado));
//        }
//        return listaDTO;
//
//      Opcao 2:
        return Response
                .ok(estatdoService.findAll())
                .build();
    }

    @POST
    public Response create (@Valid EstadoDTO dto){
        return Response
                .status(201).entity(estatdoService.create(dto))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, EstadoDTO dto){
        estatdoService.update(id, dto);
        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        estatdoService.delete(id);
        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }
}
