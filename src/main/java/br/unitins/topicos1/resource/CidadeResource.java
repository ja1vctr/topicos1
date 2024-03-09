package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.CidadeDTO;
import br.unitins.topicos1.dto.CidadeResponseDTO;
import br.unitins.topicos1.model.Cidade;
import br.unitins.topicos1.repository.CidadeRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/Cidades")
public class CidadeResource {
    @Inject
    public CidadeRepository cidadeRepository;

    @GET
    @Path("/{id}")
    public CidadeResponseDTO findById(@PathParam("id") Long id){
        return CidadeResponseDTO.valueOf(cidadeRepository.findById(id));
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<CidadeResponseDTO> findByNome(@PathParam("nome") String nome){
        return cidadeRepository.findByNome(nome).stream().map(cidade -> CidadeResponseDTO.valueOf(cidade)).toList();
    }

    @GET
    public List<CidadeResponseDTO> findAll(){
//        Opcao 1: forma de passar a informação do CidadeRepository.listAll() pelo ResponseDTO
//
//        List<Cidade> lista = CidadeRepository.listAll();
//        List<CidadeResponseDTO> listaDTO = new ArrayList<CidadeResponseDTO>();
//        for(Cidade Cidade : lista){
//            listaDTO.add(CidadeResponseDTO.valueOf(Cidade));
//        }
//        return listaDTO;
//
//      Opcao 2:
        return cidadeRepository.listAll().stream().map(Cidade -> CidadeResponseDTO.valueOf(Cidade)).toList();
    }

    @POST
    @Transactional
    public CidadeResponseDTO create (CidadeDTO dto){
        Cidade cidade = new Cidade();
        cidade.setNome(dto.nome());

        cidadeRepository.persist(cidade);
        return CidadeResponseDTO.valueOf(cidade);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, CidadeDTO dto){
        Cidade cidadeBanco = cidadeRepository.findById(id);
        cidadeBanco.setNome(dto.nome());
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        cidadeRepository.deleteById(id);
    }
}
