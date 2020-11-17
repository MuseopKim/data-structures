//
//  ArrayList.c
//  introduction-to-data-structures
//
//  Created by Museop Kim on 2020/11/18.
//

#include <stdio.h>
#include "ArrayList.h"

void init(List * list) {
    (list -> numOfData) = 0;
    (list -> currentPosition) = -1;
}

void insertData(List * list, ListData data) {
    if (list -> numOfData >= LIST_LENGTH) {
        puts("저장이 불가능 합니다.");
        return;
    }
    
    list -> array[list -> numOfData] = data;
    (list -> numOfData)++;
}

int findFirst(List * list, ListData * data) {
    if (list -> numOfData == 0) {
        return FALSE;
    }
    
    (list -> currentPosition) = 0;
    *data = list -> array[0];
    return TRUE;
}

int findNext(List * list, ListData * data) {
    if (list -> currentPosition >= (list -> numOfData) - 1) {
        return FALSE;
    }
    
    (list -> currentPosition)++;
    *data = list -> array[list -> currentPosition];
    return TRUE;
}

ListData removeData(List * list) {
    int currentPosition = list -> currentPosition;
    int numOfData = list -> numOfData;
    ListData data = list -> array[currentPosition];
    
    int i = 0;
    for (i = currentPosition; i < numOfData - 1; i++) {
        list -> array[i] = list -> array[i + 1];
    }
    
    (list -> numOfData)--;
    (list -> currentPosition)--;
    return data;
}

int count(List * list) {
    return list -> numOfData;
}
