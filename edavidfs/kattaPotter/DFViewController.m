//
//  DFViewController.m
//  kattaPotter
//
//  Created by David Santana on 09/11/11.
//  Copyright (c) 2011 __MyCompanyName__. All rights reserved.
//

#import "DFViewController.h"

@implementation DFViewController


//@synthesize bookList = _bookList;
@synthesize totalPrice;

@synthesize bookOneTextField = _bookOneTextField;
@synthesize bookTwoTextField = _bookTwoTextField;
@synthesize bookThreeTextField = _bookThreeTextField;
@synthesize bookFourTextField = _bookFourTextField;
@synthesize bookFiveTextField = _bookFiveTextField;
@synthesize nBookOne = _nBookOne;

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)viewDidUnload
{
    [self setTotalPrice:nil];

    [self setBookOneTextField:nil];
    [self setBookTwoTextField:nil];
    [self setBookThreeTextField:nil];
    [self setBookFourTextField:nil];
    [self setBookFiveTextField:nil];
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
}

- (void)viewWillDisappear:(BOOL)animated
{
	[super viewWillDisappear:animated];
}

- (void)viewDidDisappear:(BOOL)animated
{
	[super viewDidDisappear:animated];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
}

- (void)dealloc {
    [totalPrice release];
    [_bookOneTextField release];
    [_bookTwoTextField release];
    [_bookThreeTextField release];
    [_bookFourTextField release];
    [_bookFiveTextField release];
    [super dealloc];
}
- (IBAction)calcTotalPrice:(id)sender {
    
    //UITextField *contadorLibro = sender;
    NSNumber *bookOne   = [[NSNumber alloc] initWithInt:[self.bookOneTextField.text intValue]];
    NSNumber *bookTwo   = [[NSNumber alloc] initWithInt:[self.bookTwoTextField.text intValue]];
    NSNumber *bookThree = [[NSNumber alloc] initWithInt:[self.bookThreeTextField.text intValue]];
    NSNumber *bookFour  = [[NSNumber alloc] initWithInt:[self.bookFourTextField.text intValue]];
    NSNumber *bookFive  = [[NSNumber alloc] initWithInt:[self.bookFiveTextField.text intValue]];
       
    NSArray *bookList = [[NSArray alloc]initWithObjects:bookOne,bookTwo,bookThree,bookFour,bookFive ,nil];
    CashBookStore *bookStore = [[CashBookStore alloc]init];
    float result =[bookStore priceForNBooks:bookList];
    NSString *output = [[NSString alloc] initWithFormat:@"%.2f",result];
    self.totalPrice.text = output;
    
    //[result release];
    [output release];
    [bookOne release];
    [bookTwo release];
    [bookThree release];
    [bookFour release];
    [bookFive release];
    [bookList release];
}

- (IBAction)backgroundTap:(id)sender{
    [self.bookOneTextField resignFirstResponder];
    [self.bookTwoTextField resignFirstResponder];
    [self.bookThreeTextField resignFirstResponder];
    [self.bookFourTextField resignFirstResponder];
    [self.bookFiveTextField resignFirstResponder];
    
}
@end
