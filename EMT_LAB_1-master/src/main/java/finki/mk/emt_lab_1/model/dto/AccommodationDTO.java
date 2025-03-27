package finki.mk.emt_lab_1.model.dto;

import finki.mk.emt_lab_1.model.enums.Category;

public class AccommodationDTO {
    private Long id;
    private String name;
    private Category category;
    private Long host;
    private Integer numRooms;
    private boolean isRented;

    public AccommodationDTO() {
    }

    public AccommodationDTO(String name, Category category, Long host, Integer numRooms, boolean isRented) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.isRented = isRented;
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


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getHost() {
        return host;
    }

    public void setHost(Long host) {
        this.host = host;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}
