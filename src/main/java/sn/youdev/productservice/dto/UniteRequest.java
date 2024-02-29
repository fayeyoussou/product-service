package sn.youdev.productservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.ToString;
import lombok.Value;
import sn.youdev.productservice.entity.Unite;

import java.io.Serializable;

/**
 * DTO for {@link Unite}
 */
public record UniteRequest(
        @NotNull(message = "ne peut etre null") @Size(message = "la taille doit etre minimum 1", min = 1, max = 20) @NotEmpty(message = "ne peut etre vide") String nom) implements Serializable {
    public Unite toEntity() {
        Unite unite = new Unite();
        unite.setNom(this.nom);
        return unite;
    }

    public void update(Unite unite) {
        unite.setNom(this.nom);
    }
}