package com.example.TP2.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La description ne peut pas être vide.")
    @Size(max = 255, message = "La description ne peut pas dépasser 255 caractères.")
    private String description;

    @NotNull(message = "La date de création ne peut pas être nulle.")
    private Date creationDate;

    @NotNull(message = "La date d'échéance ne peut pas être nulle.")
    private Date dueDate;
}