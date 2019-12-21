package br.com.sisms.api.model.mapper;

import java.util.List;
import java.util.Optional;

public interface BaseMapper<E, D> {

    E toEntity(D dto);

    D toDTO(E entity);

    D toDTO(Optional<E> optional);

    List<E> toEntity(List<D> dtoList);

    List<D> toDTO(List<E> entityList);

}
