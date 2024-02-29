package sn.youdev.productservice.dto;

import java.io.Serializable;

/**
 * DTO for {@link sn.youdev.productservice.entity.Unite}
 */
public record UniteResponse(Long id, String nom) implements Serializable {
}