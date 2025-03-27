package finki.mk.emt_lab_1.model.dto;

public class HostDTO {
    private Long id;
    private String name;
    private String surname;
    private Long country;

    public HostDTO() {
    }

    public HostDTO(Long id, String name, String surname, Long country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }
}
