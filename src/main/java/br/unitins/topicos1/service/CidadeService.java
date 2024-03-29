package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.CidadeDTO;
import br.unitins.topicos1.dto.CidadeResponseDTO;
import br.unitins.topicos1.model.Cidade;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;

import java.util.List;

public interface CidadeService {

    CidadeResponseDTO findById(Long id);
    public List<CidadeResponseDTO> findByNome(String nome);
    public List<CidadeResponseDTO> findAll();
    public CidadeResponseDTO create(@Valid CidadeDTO dto);
    public void update(Long id, CidadeDTO dto);
    public void delete(Long id);

}