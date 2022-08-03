package zamperetta.crudspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
// @Table(name="cursos") se a tabela tiver um nome diferente da classe
public class Course {

    @Id //chave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //genedara automaticamente
    @JsonProperty("_id") //para ele mandar como _id e ser entendido pelo front
    private Long id;

    @Column(length = 200, nullable = false) //opcional, porém é bom por
    private String name;

    @Column(length = 10, nullable = false) //opcional, porém é bom por
    private String category;

}
