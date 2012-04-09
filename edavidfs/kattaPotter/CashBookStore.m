//
//  CashBookStore.m
//  kattaPotter
//
//  Created by David Santana on 10/11/11.
//  Copyright (c) 2011 __MyCompanyName__. All rights reserved.
//

#import "CashBookStore.h"

@implementation CashBookStore

-(float) priceForList:(NSArray*)booksList{
    
    NSInteger nBookOne      = 0;
    NSInteger nBookTwo      = 0;
    NSInteger nBookThree    = 0;
    NSInteger nBookFour     = 0;
    NSInteger nBookFive     = 0;
    
    float price = 0.0;
    
    for (id book in booksList) {
        if ([book intValue] == 1) {
            nBookOne = nBookOne+1;
        }else if ([book intValue] == 2) {
            nBookTwo = nBookTwo+1;
        }else if ([book intValue] == 3) {
            nBookThree = nBookThree+1;
        }else if ([book intValue] == 4) {
            nBookFour = nBookFour+1;
        }else if ([book intValue] == 5) {
            nBookFive = nBookFive+1;
        }
    }
    NSNumber *one   = [[NSNumber alloc]initWithInt:nBookOne];
    NSNumber *two   = [[NSNumber alloc]initWithInt:nBookTwo];
    NSNumber *three = [[NSNumber alloc]initWithInt:nBookThree];
    NSNumber *four  = [[NSNumber alloc]initWithInt:nBookFour];
    NSNumber *five  = [[NSNumber alloc]initWithInt:nBookFive];
    
    NSArray* nBooks = [[NSArray alloc]initWithObjects:one,two,three,four,five, nil];
    
    price = [self priceForNBooks:nBooks];
    return price;
}
-(float)priceForNBooks:(NSArray *)bookList{
    
    float price = 0.0;
    
    NSArray *sortArray = [[NSArray alloc] initWithArray:[bookList sortedArrayUsingSelector:@selector(compare:)]];
    NSInteger nBookFive     = [[sortArray objectAtIndex:0] intValue];
    NSInteger nBookFour     = [[sortArray objectAtIndex:1] intValue];
    NSInteger nBookThree    = [[sortArray objectAtIndex:2] intValue];
    NSInteger nBookTwo      = [[sortArray objectAtIndex:3] intValue];
    NSInteger nBookOne      = [[sortArray objectAtIndex:4] intValue];
    
    if (nBookOne>0) {
        if (nBookTwo>0) {
            if (nBookThree>0) {
                if (nBookFour>0) {
                    if (nBookFive>0) {
                        price = price + 8*5*0.75*nBookFive;
                        nBookOne    = nBookOne - nBookFive;
                        nBookTwo    = nBookTwo - nBookFive;
                        nBookThree  = nBookThree - nBookFive;  
                        nBookFour   = nBookFour - nBookFive; 
                        nBookFive   = 0; 
                    }
                    price = price + 8*4*0.80*nBookFour ;
                    nBookOne    = nBookOne - nBookFour ;
                    nBookTwo    = nBookTwo - nBookFour ;
                    nBookThree  = nBookThree - nBookFour ;  
                    nBookFour   = 0;
                }
                price = price + 8*3*0.90*nBookThree;
                nBookOne    = nBookOne - nBookThree;
                nBookTwo    = nBookTwo - nBookThree;
                nBookThree  = 0;  
            }
            price = price + 8*2*0.95*nBookTwo;
            nBookOne    = nBookOne - nBookTwo;
            nBookTwo    = 0;
        }
        price = price + 8*nBookOne;
        nBookOne    = 0;
    }
    [sortArray release];
    return price;
}

@end
