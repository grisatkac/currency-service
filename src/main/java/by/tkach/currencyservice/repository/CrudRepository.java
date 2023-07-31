package by.tkach.currencyservice.repository;


import java.util.List;

public interface CrudRepository<T> {

    List<T> getAll();
}
