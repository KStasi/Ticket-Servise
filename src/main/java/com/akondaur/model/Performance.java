package com.akondaur.model;
import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @Column (name = "name")
    private String name;
    @Column (name = "description")
    private String description;
    @Column (name = "type")
    private Integer type;
    @Column (name = "theatre")
    private String theatre;

    public Performance() {
    }

    public Performance(Long id, String name, String description, Integer type, String theatre) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.theatre = theatre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTheatre() {
        return theatre;
    }

    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }

    @Override
    public String toString() {
        return "Performance{" + "id=" + id + ", name=" + name + ", description='" + description + '\'' + ", type='" + type
                + '\'' + ", theatre='" + theatre + '\'' + '}';
    }
}
