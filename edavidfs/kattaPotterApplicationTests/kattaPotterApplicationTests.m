//
//  kattaPotterApplicationTests.m
//  kattaPotterApplicationTests
//
//  Created by David Santana on 27/11/11.
//  Copyright (c) 2011 __MyCompanyName__. All rights reserved.
//

#import "kattaPotterApplicationTests.h"

@implementation kattaPotterApplicationTests

- (void)setUp
{
    [super setUp];
    appDelegate = [[[UIApplication sharedApplication] delegate] retain];
    kattaPotterViewController = appDelegate.viewController;
    kattaView = kattaPotterViewController.view;
    
    bookOneTextField    = (UITextField*) [kattaPotterViewController.view viewWithTag:1];
    bookTwoTextField    = (UITextField*) [kattaPotterViewController.view viewWithTag:2];
    bookThreeTextField  = (UITextField*) [kattaPotterViewController.view viewWithTag:3];
    bookFourTextField   = (UITextField*) [kattaPotterViewController.view viewWithTag:4];
    bookFiveTextField   = (UITextField*) [kattaPotterViewController.view viewWithTag:5];
    
    [bookOneTextField   setText:@"0"];
    [bookTwoTextField   setText:@"0"];
    [bookThreeTextField setText:@"0"];
    [bookFourTextField  setText:@"0"];
    [bookFiveTextField  setText:@"0"];
    // Set-up code here.
    
/*    app_delegate         = [[UIApplication sharedApplication] delegate];
    calc_view_controller = app_delegate.calcViewController;
    calc_view            = calc_view_controller.view;*/
}

- (void)tearDown
{
    // Tear-down code here.
    [resultado release];
    [appDelegate release];
    [super tearDown];
}


- (void)testApplicationDelegate {
    STAssertTrue([appDelegate isMemberOfClass:[DFAppDelegate class]], @"bad UIApplication delegate");
    STAssertNotNil(appDelegate, @"AppDelegate Nil");
    
}

-(void)testNoBook{
    
    [kattaPotterViewController calcTotalPrice:bookOneTextField];
    STAssertEqualObjects(kattaPotterViewController.totalPrice.text, @"0.00", @"No Book");
}

-(void)testOneBook{
    
    [bookOneTextField setText:@"1"];

    [kattaPotterViewController calcTotalPrice:bookOneTextField];
    STAssertEqualObjects(kattaPotterViewController.totalPrice.text , @"8.00", @"One book add");
}
-(void)testTwoDifferentsBook{

    [bookOneTextField setText:@"1"];
    [bookTwoTextField setText:@"1"];

    [kattaPotterViewController calcTotalPrice:bookOneTextField];
    STAssertEqualObjects(kattaPotterViewController.totalPrice.text , @"15.20", @"Two Different book Fail");
}

-(void)testTwoDifferentsWithOneDeleteBook{

    [bookOneTextField setText:@"1"];
    [bookTwoTextField setText:@"1"];
    
    [kattaPotterViewController calcTotalPrice:bookOneTextField];
     STAssertEqualObjects(kattaPotterViewController.totalPrice.text , @"15.20", @"Two Different book Fail");
    
    [bookTwoTextField setText:@"0"];
    [kattaPotterViewController calcTotalPrice:bookOneTextField];
    STAssertEqualObjects(kattaPotterViewController.totalPrice.text , @"8.00", @"Instert Two Different and Delete one book Fail");
}
-(void)testThreeDifferentsBook{
    
    [bookOneTextField   setText:@"1"];
    [bookTwoTextField   setText:@"1"];
    [bookThreeTextField setText:@"1"];
    
    [kattaPotterViewController calcTotalPrice:bookOneTextField];
    STAssertEqualObjects(kattaPotterViewController.totalPrice.text , @"21.60", @"Three Different book Fail");
}
-(void)testFourDifferentsBook{
    
    [bookOneTextField   setText:@"1"];
    [bookTwoTextField   setText:@"1"];
    [bookThreeTextField setText:@"1"];
    [bookFourTextField  setText:@"1"];
    
    [kattaPotterViewController calcTotalPrice:bookOneTextField];
    STAssertEqualObjects(kattaPotterViewController.totalPrice.text , @"25.60", @"Four Different book Fail");
}
-(void)testFiveDifferentsBook{
    
    [bookOneTextField   setText:@"1"];
    [bookTwoTextField   setText:@"1"];
    [bookThreeTextField setText:@"1"];
    [bookFourTextField  setText:@"1"];
    [bookFiveTextField  setText:@"1"];
    
    [kattaPotterViewController calcTotalPrice:bookOneTextField];
    STAssertEqualObjects(kattaPotterViewController.totalPrice.text , @"30.00", @"Five Different book Fail");
}
-(void)testFiveDifferentsBookPlusOne{
    
    [bookOneTextField   setText:@"2"];
    [bookTwoTextField   setText:@"1"];
    [bookThreeTextField setText:@"1"];
    [bookFourTextField  setText:@"1"];
    [bookFiveTextField  setText:@"1"];
    
    [kattaPotterViewController calcTotalPrice:bookOneTextField];
    STAssertEqualObjects(kattaPotterViewController.totalPrice.text , @"38.00", @"Five Different book Fail plus One");
}
-(void)testFiveDifferentsBookX2{
    
    [bookOneTextField   setText:@"2"];
    [bookTwoTextField   setText:@"2"];
    [bookThreeTextField setText:@"2"];
    [bookFourTextField  setText:@"2"];
    [bookFiveTextField  setText:@"2"];
    
    [kattaPotterViewController calcTotalPrice:bookOneTextField];
    STAssertEqualObjects(kattaPotterViewController.totalPrice.text , @"60.00", @"Five Different book Twice Fail");
}
@end
