package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.EstadoDTO;
import br.unitins.topicos1.dto.EstadoResponseDTO;
import br.unitins.topicos1.model.Estado;
import br.unitins.topicos1.repository.EstadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
@ApplicationScoped
public class EstadoServiceImpl implements EstadoService{
    @Inject
    public EstadoRepository estadoRepository;
    @Override
    @Transactional
    public EstadoResponseDTO create(EstadoDTO dto) {
        Estado estado = new Estado();
        estado.setNome(dto.nome());
        estado.setSigla(dto.sigla());

        estadoRepository.persist(estado);
        return EstadoResponseDTO.valueOf(estado);
    }

    @Override
    @Transactional
    public void update(Long id, EstadoDTO dto) {
        Estado estadoBanco = estadoRepository.findById(id);
        estadoBanco.setNome(dto.nome());
        estadoBanco.setSigla(dto.sigla());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        estadoRepository.deleteById(id);
    }

    @Override
    public EstadoResponseDTO findById(Long id) {
        return EstadoResponseDTO.valueOf(estadoRepository.findById(id));
    }

    @Override
    public List<EstadoResponseDTO> findAll() {
        return estadoRepository.listAll().stream().map(estado -> EstadoResponseDTO.valueOf(estado)).toList();
    }

    @Override
    public List<EstadoResponseDTO> findByNome(String nome) {
        return estadoRepository.findByNome(nome).stream().map(estado-> EstadoResponseDTO.valueOf(estado)).toList();
    }

    @Override
    public List<EstadoResponseDTO> findBySigla(String sigla) {
        return estadoRepository.findBySigla(sigla).stream().map(estado-> EstadoResponseDTO.valueOf(estado)).toList();
    }
}
