package br.edu.uepb.example.secondmicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailModel {

	private Long id;
	private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
}
