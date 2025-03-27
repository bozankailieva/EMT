package finki.mk.emt_lab_1.model.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class CountryDto {
    private Long id;
    private String name;
    private String continent;

    public CountryDto(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    public CountryDto() {
    }

    public CountryDto(Long id, String name, String continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }
}
