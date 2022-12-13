package br.edu.uepb.example.secondmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.uepb.example.secondmicroservice.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
