//
//  DFViewController.h
//  kattaPotter
//
//  Created by David Santana on 09/11/11.
//  Copyright (c) 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "CashBookStore.h"

@interface DFViewController : UIViewController{
    
    //NSMutableArray *_bookList;

}
//@property (retain, nonatomic) NSMutableArray *bookList;
@property (retain, nonatomic) IBOutlet UITextField *bookOneTextField;
@property (retain, nonatomic) IBOutlet UITextField *bookTwoTextField;
@property (retain, nonatomic) IBOutlet UITextField *bookThreeTextField;
@property (retain, nonatomic) IBOutlet UITextField *bookFourTextField;
@property (retain, nonatomic) IBOutlet UITextField *bookFiveTextField;

@property (retain, nonatomic) NSNumber *nBookOne;
@property (retain, nonatomic) IBOutlet UILabel *totalPrice;


- (IBAction)calcTotalPrice:(id)sender;
- (IBAction)backgroundTap:(id)sender;
@end
