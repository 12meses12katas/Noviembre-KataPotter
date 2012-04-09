//
//  CashBookStore.h
//  kattaPotter
//
//  Created by David Santana on 10/11/11.
//  Copyright (c) 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface CashBookStore : NSObject{
    
}

-(float) priceForList:(NSArray *)bookList;
-(float) priceForNBooks:(NSArray *)bookList;




@end
