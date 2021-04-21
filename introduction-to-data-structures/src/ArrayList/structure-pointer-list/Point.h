//
//  Point.h
//  structure-pointer-list
//
//  Created by Museop Kim on 2020/11/18.
//

#ifndef __POINT_H__
#define __POINT_H__

typedef struct _point {
    int x;
    int y;
} Point;

void setPointPosition(Point * point, int x, int y);

void showPointPosition(Point * point);

int comparePoint(Point * firstPoint, Point * secondPoint);

#endif /* Point_h */
