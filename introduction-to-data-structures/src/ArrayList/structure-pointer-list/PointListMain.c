//
//  PointListMain.c
//  structure-pointer-list
//
//  Created by Museop Kim on 2020/11/18.
//

#include <stdio.h>
#include <stdlib.h>
#include "ArrayList.h"
#include "../ArrayList.c"

int main(void) {
    List list;
    Point pointData;
    Point * point;
    
    
    init(&list);
    
    point = (Point *)malloc(sizeof(Point));
    setPointPosition(point, 2, 1);
    insertData(&list, point);
    
    point = (Point *)malloc(sizeof(Point));
    setPointPosition(point, 2, 2);
    insertData(&list, point);
    
    
    point = (Point *)malloc(sizeof(Point));
    setPointPosition(point, 3, 1);
    insertData(&list, point);
    
    point = (Point *)malloc(sizeof(Point));
    setPointPosition(point, 3, 2);
    insertData(&list, point);
    
    printf("데이터 수 : %d \n", count(&list));
    
    if (findFirst(&list, &point)) {
        showPointPosition(point);
        
        while (findNext(&list, &point)) {
            showPointPosition(point);
        }
    }
    
    printf("\n");
    
    pointData.x = 2;
    pointData.y = 0;
    
    if (findFirst(&list, &point)) {
        if (comparePoint(point, &pointData) == 1) {
            point = removeData(&list);
            free(point);
        }
        
        while (findNext(&list, &point)) {
            if (comparePoint(point, &pointData) == 1) {
                point = removeData(&list);
                free(point);
            }
        }
    }
    
    if (findFirst(&list, &point)) {
        showPointPosition(point);
        
        while (findNext(&list, &point)) {
            showPointPosition(point);
        }
    }
    
    printf("\n");
    
    return 0;
}
