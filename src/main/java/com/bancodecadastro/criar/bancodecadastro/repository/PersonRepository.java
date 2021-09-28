package com.bancodecadastro.criar.bancodecadastro.repository;

import com.bancodecadastro.criar.bancodecadastro.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
