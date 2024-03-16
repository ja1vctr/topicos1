package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped // técnica para lidar com o consumo de dados da memória.
public class EstadoRepository implements PanacheRepository<Estado> {

    public List<Estado> findByNome(String nome){
        return find("nome LIKE ?1","%"+ nome+"%").list();
    }

    public List<Estado> findBySigla(String sigla){
        return find("sigla Like ?1", "%"+ sigla.toUpperCase()+"%").list();
    }

    public Estado findByNomeCompleto(String nome){
        return find("UPPER(nome) = ?1", nome.toUpperCase()).firstResult();
    }

}
