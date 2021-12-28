package com.intango.colorGame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "colors")
public class Color {
    @Id
    private Long id;

    @Column(name = "color_name")
    private String colorName;

    @Column(name = "color_votes")
    private int colorVotes;

    public Color() {
    }

    public Color(Long id, String colorName, int colorVotes) {
        super();
        this.id = id;
        this.colorName = colorName;
        this.colorVotes = colorVotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public int getColorVotes() {
        return colorVotes;
    }

    public void setColorVotes(int colorVotes) {
        this.colorVotes = colorVotes;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", colorName='" + colorName + '\'' +
                ", colorVotes=" + colorVotes +
                '}';
    }
}
