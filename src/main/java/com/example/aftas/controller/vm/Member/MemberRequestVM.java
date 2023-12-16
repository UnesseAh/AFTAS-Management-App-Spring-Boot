package com.example.aftas.controller.vm.Member;

import com.example.aftas.entities.Member;
import com.example.aftas.entities.enums.IdentityDocumentType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record MemberRequestVM(
        @Digits(integer = 10, fraction = 2, message = "Member number must be a digit")
        Long number,
        @NotBlank(message = "First name is required")
        @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
        String firstName,
        @NotBlank(message = "Last name is required")
        @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
        String lastName,
        LocalDate accessionDate,
        @NotBlank(message = "Nationality is required")
        @Size(min = 2, max = 50, message = "Nationality must be between 2 and 50 characters")
        String nationality,
        @NotBlank(message = "Identity document is required")
        @Pattern(regexp = "^(CIN|RESIDENCE_CARD|PASSPORT)$", message = "Identity document must be of type CIN, RESIDENCE CARD, or PASSPORT")
        String identityDocument,
        @NotBlank(message = "Identity number is required")
        String identityNumber
) {
        public Member toMember(){
                return new Member().builder()
                        .number(number)
                        .firstName(firstName)
                        .lastName(lastName)
                        .accessionDate(accessionDate)
                        .nationality(nationality)
                        .identityDocument(IdentityDocumentType.valueOf(identityDocument))
                        .identityNumber(identityNumber)
                        .build();
        }

}