//
//  kattaPotterTests.h
//  kattaPotterTests
//
//  Created by David Santana on 09/11/11.
//  Copyright (c) 2011 __MyCompanyName__. All rights reserved.
//

#import <SenTestingKit/SenTestingKit.h>
#import "CashBookStore.h"

@interface kattaPotterTests : SenTestCase{

    CashBookStore *bookStore;
    
    NSNumber *bookOne;
    NSNumber *bookTwo;
    NSNumber *bookThree;
    NSNumber *bookFour;
    NSNumber *bookFive;
    
    NSArray *shoppingList;
    
    float totalPrice;
}
    

@end
