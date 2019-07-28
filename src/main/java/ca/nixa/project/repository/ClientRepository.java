package ca.nixa.project.repository;

import org.springframework.data.repository.CrudRepository;

import ca.nixa.project.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {

}
