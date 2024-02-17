package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped // técnica para lidar com o consumo de dados da memória.
public class EstadoRepository implements PanacheRepository<Estado> {
}
