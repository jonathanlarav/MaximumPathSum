package com.shibumi;

import java.util.ArrayList;
import java.util.List;

public class MaxWithPath {
    private int max;
    private List<Direction> directions;
    
    public MaxWithPath(int max, List<Direction> directions) {
        this.max = max;
        this.directions = directions;
    }
    
    public int getMax() {
        return max;
    }
    
    public List<Direction> getDirections() {
        return new ArrayList<Direction>(directions);
    }
}
