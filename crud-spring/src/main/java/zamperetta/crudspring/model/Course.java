package zamperetta.crudspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
// @Table(name="cursos") se a tabela tiver um nome diferente da classe
public class Course {

    @Id //chave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //genedara automaticamente
    private Long id;

    @Column(length = 200, nullable = false) //opcional, porém é bom por
    private String name;

    @Column(length = 10, nullable = false) //opcional, porém é bom por
    private String category;

}
