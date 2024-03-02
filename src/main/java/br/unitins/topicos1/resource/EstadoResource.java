package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.EstadoDTO;
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
    @Path("/search/nome/{nome}")
    public List<Estado> findByNome(@PathParam("nome") String nome){
        return estadoRepository.findByNome(nome);
    }

    @GET
    @Path("/search/sigla/{sigla}")
    public List<Estado> findBySigla(@PathParam("sigla") String sigla){
        return estadoRepository.findBySigla(sigla);
    }

    @GET
    public List<Estado> findAll(){
        return estadoRepository.listAll();
    }

    @POST
    @Transactional
    public Estado create (EstadoDTO dto){
        Estado estado = new Estado();
        estado.setNome(dto.nome());
        estado.setSigla(dto.sigla());

        estadoRepository.persist(estado);
        return estado;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, Estado estado){
        Estado estadoBanco = estadoRepository.findById(id);
        estadoBanco.setNome(estado.getNome());
        estadoBanco.setSigla(estado.getSigla());
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        estadoRepository.deleteById(id);
    }
}
