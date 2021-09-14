package ftn.aups.pastrywarehouse;

import java.util.List;

public interface CrudService<E> {

  List<E> getAll();

  E getOne(Long id);

  E save(E e);

  void delete(Long id);
}
