//
//  kattaPotterApplicationTests.h
//  kattaPotterApplicationTests
//
//  Created by David Santana on 27/11/11.
//  Copyright (c) 2011 __MyCompanyName__. All rights reserved.
//

#import <SenTestingKit/SenTestingKit.h>

#import "DFAppDelegate.h"
#import "DFViewController.h"

@interface kattaPotterApplicationTests : SenTestCase{
    DFAppDelegate* appDelegate;
    DFViewController* kattaPotterViewController;
    UIView *kattaView;
    
    UITextField *bookOneTextField;
    UITextField *bookTwoTextField;
    UITextField *bookThreeTextField;
    UITextField *bookFourTextField;
    UITextField *bookFiveTextField;
    
    NSString *resultado;
}
@end
