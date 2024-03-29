package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.CidadeDTO;
import br.unitins.topicos1.dto.CidadeResponseDTO;
import br.unitins.topicos1.model.Cidade;
import br.unitins.topicos1.repository.CidadeRepository;
import jakarta.inject.Inject;

import java.util.List;

public class CidadeServiceImpl implements CidadeService{
    @Inject
    CidadeRepository cidadeRepository;

    @Override
    public CidadeResponseDTO findById(Long id) {
        return CidadeResponseDTO.valueOf(cidadeRepository.findById(id));
    }

    @Override
    public List<CidadeResponseDTO> findByNome(String nome) {
        return cidadeRepository.findByNome(nome)
                .stream()
                .map(cidade -> CidadeResponseDTO.valueOf(cidade))
                .toList();
    }

    @Override
    public List<CidadeResponseDTO> findAll() {
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
        return cidadeRepository
                .listAll()
                .stream()
                .map(Cidade -> CidadeResponseDTO.valueOf(Cidade))
                .toList();
    }

    @Override
    public CidadeResponseDTO create(CidadeDTO dto) {
        Cidade cidade = new Cidade();
        cidade.setNome(dto.nome());

        cidadeRepository.persist(cidade);
        return CidadeResponseDTO.valueOf(cidade);
    }

    @Override
    public void update(Long id, CidadeDTO dto) {
        Cidade cidadeBanco = cidadeRepository.findById(id);
        cidadeBanco.setNome(dto.nome());
    }

    @Override
    public void delete(Long id) {
        cidadeRepository.deleteById(id);
    }
}