package com.tempestiva.lme.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Robot {
    Integer id;
    Position currentPosition;
    Position startingPosition;

}
