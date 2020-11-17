//
//  Point.c
//  structure-pointer-list
//
//  Created by Museop Kim on 2020/11/18.
//

#include <stdio.h>
#include "Point.h"

void setPointPosition(Point * point, int x, int y) {
    point -> x = x;
    point -> y = y;
}

void showPointPosition(Point * point) {
    printf("[%d, %d] \n", point -> x, point -> y);
}

int comparePoint(Point * firstPoint, Point * secondPoint) {
    if (firstPoint -> x == secondPoint -> x && firstPoint -> y == secondPoint -> y) {
        return 0;
    }
    
    if (firstPoint -> x == secondPoint -> x) {
        return 1;
    }
    
    if (firstPoint -> y == secondPoint -> y) {
        return 2;
    }
    
    return -1;
}
