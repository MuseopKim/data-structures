//
//  ArrayList.c
//  introduction-to-data-structures
//
//  Created by Museop Kim on 2020/11/17.
//

#include <stdio.h>
#include "ArrayList.h"

void init(List * listPointer) {
    (listPointer -> numOfData) = 0;
    (listPointer -> currentPosition) = -1;
}

void insert(List * listPointer, ListData data) {
    if (listPointer -> numOfData >= LIST_LENGTH) {
        puts("저장이 불가능 합니다.");
        return
    }
    
    listPointer -> array[listPointer -> numOfData] = data;
    (listPointer -> numOfData)++;
}

int findFirst(List * listPointer, ListData * dataPointer) {
    if (listPointer -> numOfData == 0) {
        return FALSE;
    }
    
    (listPointer -> currentPosition) = 0;
    *dataPointer = listPointer -> array[0];
    return TRUE;
}

int findNext(List * listPointer, ListData * dataPointer) {
    if (listPointer -> currentPosition >= (listPointer -> numOfData) - 1) {
        return FALSE;
    }
    
    (listPointer -> currentPosition)++;
    *dataPointer = listPointer -> array[listPointer -> currentPosition];
    return TRUE;
}

ListData remove(List * listPointer) {
    int currentPosition = listPointer -> currentPosition;
    int numOfData = listPointer -> numOfData;
    ListData data = listPointer -> array[currentPosition];
    
    int i;
    for (i = currentPosition; i < numOfData - 1; i++) {
        listPointer -> array[i] = listPointer -> array[i + 1];
    }
    
    (listPointer -> numOfData)--;
    (listPointer -> currentPosition)--;
    return data;
}

int count(List * listPointer) {
    return listPointer -> numOfData;
}
