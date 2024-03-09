package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.EstadoDTO;
import br.unitins.topicos1.dto.EstadoResponseDTO;
import br.unitins.topicos1.model.Estado;
import br.unitins.topicos1.repository.EstadoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/estados")
public class EstadoResource {
    @Inject
    public EstadoRepository estadoRepository;

    @GET
    @Path("/{id}")
    public EstadoResponseDTO findById(@PathParam("id") Long id){
        return EstadoResponseDTO.valueOf(estadoRepository.findById(id));
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<EstadoResponseDTO> findByNome(@PathParam("nome") String nome){
        return estadoRepository.findByNome(nome).stream().map(estado-> EstadoResponseDTO.valueOf(estado)).toList();
    }

    @GET
    @Path("/search/sigla/{sigla}")
    public List<EstadoResponseDTO> findBySigla(@PathParam("sigla") String sigla){
        return estadoRepository.findBySigla(sigla).stream().map(estado-> EstadoResponseDTO.valueOf(estado)).toList();
    }

    @GET
    public List<EstadoResponseDTO> findAll(){
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
        return estadoRepository.listAll().stream().map(estado -> EstadoResponseDTO.valueOf(estado)).toList();
    }

    @POST
    @Transactional
    public EstadoResponseDTO create (EstadoDTO dto){
        Estado estado = new Estado();
        estado.setNome(dto.nome());
        estado.setSigla(dto.sigla());

        estadoRepository.persist(estado);
        return EstadoResponseDTO.valueOf(estado);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, EstadoDTO dto){
        Estado estadoBanco = estadoRepository.findById(id);
        estadoBanco.setNome(dto.nome());
        estadoBanco.setSigla(dto.sigla());
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        estadoRepository.deleteById(id);
    }
}
