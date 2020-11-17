//
//  ArrayListMain.c
//  introduction-to-data-structures
//
//  Created by Museop Kim on 2020/11/18.
//

#include <stdio.h>
#include "ArrayList.h"

int main(void) {
    List list;
    int data;
    init(&list);
    
    insertData(&list, 11);
    insertData(&list, 11);
    insertData(&list, 22);
    insertData(&list, 22);
    insertData(&list, 33);
    
    printf("현재 데이터의 수 : %d \n", count(&list));
    
    if (findFirst(&list, &data)) {
        printf("%d ", data);
        
        while (findNext(&list, &data)) {
            printf("%d ", data);
        }
    }
    printf("\n\n");
    
    if (findFirst(&list, &data)) {
        if (data == 22) {
            removeData(&list);
        }
        
        while(findNext(&list, &data)) {
            if (data == 22) {
                removeData(&list);
            }
        }
    }
    
    printf("데이터 수 : %d \n", count(&list));
    
    if (findFirst(&list, &data)) {
        printf("%d ", data);
        
        while (findNext(&list, &data)) {
            printf("%d ", data);
        }
    }
    
    printf("\n\n");
    
    return 0;
}
