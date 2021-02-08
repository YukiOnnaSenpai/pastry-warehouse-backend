package ftn.aups.pastrywarehouse.mapper;

public interface Mapper<T, E> {

    T toDto(E e);
    E toEntity(T t);
}
