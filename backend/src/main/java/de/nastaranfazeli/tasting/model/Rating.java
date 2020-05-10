package de.nastaranfazeli.tasting.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="ratings")
public class Rating {
    @Id @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    private UUID id;
    private String tastingId;
    private String userId;
    private float rating;
}
