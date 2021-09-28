package com.bancodecadastro.personapi.repository;

import com.bancodecadastro.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
