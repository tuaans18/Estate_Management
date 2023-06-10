package com.laptrinhjavaweb.repository.entity;


import javax.persistence.*;

@Entity
@Table(name="rentarea")
public class RentAreaEntity extends BaseEntity{

    @Column(name = "value")
    private Integer value;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "buildingid")
    private BuildingEntity buildings;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BuildingEntity getBuildings() {
        return buildings;
    }

    public void setBuildings(BuildingEntity buildings) {
        this.buildings = buildings;
    }
}
