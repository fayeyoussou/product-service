package sn.youdev.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sn.youdev.productservice.dto.UniteResponse;

@Entity
@Table(name = "unites")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Unite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)

    private String nom;

    public UniteResponse toResponse() {
        return new UniteResponse(id,nom);
    }

}
