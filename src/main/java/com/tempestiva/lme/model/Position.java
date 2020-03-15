package com.tempestiva.lme.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Position {
    Point point;
    Orientation orientation;
}
