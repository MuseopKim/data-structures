//
//  ArrayList.h
//  structure-pointer-list
//
//  Created by Museop Kim on 2020/11/18.
//

#include "Point.h"

#ifndef __ARRAY_LIST_H__
#define __ARRAY_LIST_H__

#define TRUE    1
#define FALSE   0

#define LIST_LENGTH    100
typedef Point * ListData;

typedef struct __ArrayList {
    ListData array[LIST_LENGTH];
    int numOfData;
    int currentPosition;
} ArrayList;

typedef ArrayList List;

void init(List * list);
void insertData(List * list, ListData data);

int findFirst(List * list, ListData * data);
int findNext(List * list, ListData * data);

ListData removeData(List * list);
int count(List * list);


#endif /* ArrayList_h */
