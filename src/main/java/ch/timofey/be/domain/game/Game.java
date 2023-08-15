package ch.timofey.be.domain.game;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Max(255)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    /*@NotNull
    @Column(name = "developers")
    private List<String> developers;

    @NotNull
    @Column(name = "publishers")
    private List<String> publishers;

    @NotNull
    @Column(name = "genre_list")
    private List<String> genreList;*/

    @NotNull
    @Column(name = "price")
    private double price;

    /*@NotNull
    @Column(name = "platform")
    private List<String> platform;*/

    @NotNull
    @Column(name = "image")
    private String image;
}
