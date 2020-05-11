/*
 * RatingRequest.java
 *
 * Created on 2020-05-10
 *
 * Copyright (C) 2020 Volkswagen AG, All rights reserved.
 */

package de.nastaranfazeli.tasting.model;

import lombok.Data;

@Data
public class RatingRequest {
    private String tastingId;
    private String userId;
    private float rating;
}
