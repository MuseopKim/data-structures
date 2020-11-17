//
//  ArrayList.h
//  introduction-to-data-structures
//
//  Created by Museop Kim on 2020/11/17.
//

#ifndef __ARRAY_LIST_H__
#define __ARRAY_LIST_H__

#define TRUE    1
#define FALSE   0

#define LIST_LENGTH    100
typedef int listData;

typedef struct __ArrayList {
    listData array[LIST_LENGTH];
    int numOfData;
    int currentPosition;
} ArrayList;

typedef ArrayList list;

void init(List * listPointer);
void insert(List * listPointer, ListData data);

int findFirst(List * listPointer, ListData * listDataPointer);
int findNext(List * listPointer, ListData * listDataPointer);

ListData remove(List * listPointer);
int count(List * listPointer);

#endif /* ArrayList_h */
