package com.tempestiva.lme.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Point {
    int x;
    int y;
}
