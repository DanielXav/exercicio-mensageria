package br.edu.uepb.example.secondmicroservice.dtos;

import br.edu.uepb.example.secondmicroservice.enums.EmailStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO {
	
	private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    
    private EmailStatus status;
}
