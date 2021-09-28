package com.bancodecadastro.criar.bancodecadastro.service;

import com.bancodecadastro.criar.bancodecadastro.dto.request.PersonDTO;
import com.bancodecadastro.criar.bancodecadastro.dto.response.MessageResponseDTO;
import com.bancodecadastro.criar.bancodecadastro.entity.Person;
import com.bancodecadastro.criar.bancodecadastro.mapper.PersonMapper;
import com.bancodecadastro.criar.bancodecadastro.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created personDTO with ID" +savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listaAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
