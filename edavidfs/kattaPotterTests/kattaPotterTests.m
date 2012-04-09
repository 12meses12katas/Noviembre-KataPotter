//
//  kattaPotterTests.m
//  kattaPotterTests
//
//  Created by David Santana on 09/11/11.
//  Copyright (c) 2011 __MyCompanyName__. All rights reserved.
//

#import "kattaPotterTests.h"

@implementation kattaPotterTests

- (void)setUp
{
    bookStore = [[[CashBookStore alloc]init]retain];
    bookOne   = [[[NSNumber alloc] initWithInt:1] retain];
    bookTwo   = [[[NSNumber alloc] initWithInt:2] retain];
    bookThree = [[[NSNumber alloc] initWithInt:3] retain];
    bookFour  = [[[NSNumber alloc] initWithInt:4] retain];
    bookFive  = [[[NSNumber alloc] initWithInt:5] retain];
    
    
    
    totalPrice = 0;

    [super setUp];
    // Set-up code here.
}

- (void)tearDown
{
    // Tear-down code here.
    [shoppingList release];
    [bookStore release];
    
    [bookOne    release];
    [bookTwo    release];
    [bookThree  release];
    [bookFour   release];
    [bookFive   release];
    
    [super tearDown];
}

- (void)testInstanceCashBookStore
{
    STAssertNotNil(bookStore, @"Class cashBookStore Fail");
}

- (void)testBuyAnyBook
{
    shoppingList = [[NSArray alloc]initWithObjects: nil];
    totalPrice = 0;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice ,@"Fallo al comprar ningun libro");
}

- (void)testBuyBookOne
{
    shoppingList = [[NSArray alloc]initWithObjects:bookOne, nil];
    totalPrice = 8;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar el libro Uno");
    
 }

- (void)testBuyBookTwo
{
    shoppingList = [[NSArray alloc]initWithObjects:bookTwo, nil];
    totalPrice = 8;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice , @"Fallo al comprar el libro Dos");
    
}

- (void)testBuyBookThree
{
    shoppingList = [[NSArray alloc]initWithObjects:bookThree, nil];
    totalPrice = 8;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice , @"Fallo al comprar el libro Tres");
    
}

- (void)testBuyBookFour
{
    shoppingList = [[NSArray alloc]initWithObjects:bookFour, nil];
    totalPrice = 8;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar el libro Cuatro");
    
}

- (void)testBuyBookFive
{
    shoppingList = [[NSArray alloc]initWithObjects:bookFive, nil];
    totalPrice = 8;
    STAssertEquals([bookStore priceForList:shoppingList],totalPrice, @"Fallo al comprar el libro Cinco");
    
}

- (void)testBuyTwoEqualsBooks
{
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookOne, nil];
    totalPrice = 8*2;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice , @"Fallo al comprar dos libros iguales");
    
}

- (void)testBuyBooksOneAndTwo
{
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookTwo, nil];
    totalPrice = 8*2*0.95;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libro Uno y Dos");
    
}

- (void)testBuyBooksOneAndThree
{
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookThree, nil];    
    totalPrice = 8*2*0.95;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libro Uno y Tres");
    
}

- (void)testBuyBooksOneAndFour
{
       
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookFour, nil];
    totalPrice = 8*2*0.95;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno y Cuatro");
    
}

- (void)testBuyBooksOneAndFive
{
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookFive, nil];
    totalPrice = 8*2*0.95;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno y Cinco");
    
}

- (void)testBuyBooksTwoAndThree
{
   
    shoppingList = [[NSArray alloc]initWithObjects:bookTwo,bookThree, nil];    
    totalPrice = 8*2*0.95;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Dos y Tres");
    
}

- (void)testBuyBooksTwoAndFour
{
  
    shoppingList = [[NSArray alloc]initWithObjects:bookTwo,bookFour, nil];
    totalPrice = 8*2*0.95;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Dos y Cuatro");

}

- (void)testBuyBooksTwoAndFive
{
    shoppingList = [[NSArray alloc]initWithObjects:bookTwo,bookFive, nil];   
    totalPrice = 8*2*0.95;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Dos y Cinco");
    
}

- (void)testBuyBooksThreeAndFour
{

    shoppingList = [[NSArray alloc]initWithObjects:bookThree,bookFour, nil];    
    totalPrice = 8*2*0.95;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Tres y Cuatro");
    
}

- (void)testBuyBooksThreeAndFive
{
    shoppingList = [[NSArray alloc]initWithObjects:bookThree,bookFive, nil];    
    totalPrice = 8*2*0.95;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Tres y Cinco");
    
}

- (void)testBuyBooksFourAndFive
{
    shoppingList = [[NSArray alloc]initWithObjects:bookFour,bookFive, nil];    
    totalPrice = 8*2*0.95;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Cuatro y Cinco");
    
}

- (void)testBuyBooksOneTwoAndThree
{
     
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookTwo,bookThree, nil];
    totalPrice = 8*3*0.9;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno, Dos y Tres");
    
}

- (void)testBuyBooksOneTwoAndFour
{
   
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookTwo,bookFour, nil];
    totalPrice = 8*3*0.90;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno, Dos y Cuatro");
    
}

- (void)testBuyBooksOneTwoAndFive
{
   
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookTwo,bookFive, nil];
    totalPrice = 8*3*0.90;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno, Dos y Cinco");
    
}

- (void)testBuyBooksOneThreeAndFour
{

    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookThree,bookFour, nil];
    totalPrice = 8*3*0.90;   
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno, Tres y Cuatro");
    
}

- (void)testBuyBooksOneThreeAndFive
{
   
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookThree,bookFive, nil];
    totalPrice = 8*3*0.90;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno, Tres y Cinco");

}

- (void)testBuyBooksOneFourAndFive
{
    
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookFour,bookFive, nil];
    totalPrice = 8*3*0.90;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno, Cuatro y Cinco");
    
}

- (void)testBuyBooksTwoThreeAndFour
{

    shoppingList = [[NSArray alloc]initWithObjects:bookTwo,bookThree,bookFour,nil];
    totalPrice = 8*3*0.90;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Dos, Tres y Cuatro");
    
}

- (void)testBuyBooksTwoThreeAndFive
{
   
    shoppingList = [[NSArray alloc]initWithObjects:bookTwo,bookThree,bookFive,nil];
    totalPrice = 8*3*0.90;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Dos, Tres y Cuatro");
       
}

- (void)testBuyBooksThreeFourAndFive
{
 
    shoppingList = [[NSArray alloc]initWithObjects:bookThree,bookFour,bookFive,nil];
    totalPrice = 8*3*0.90;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Tres, Cuatro y Cinco");
    
}

- (void)testBuyBooksOneTwoThreeAndFour
{
    
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookTwo
                              ,bookThree,bookFour,nil];
    totalPrice = 8*4*0.80;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno, Dos, Tres y Cuatro");
       
}

- (void)testBuyBooksOneTwoThreeAndFive
{

    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookTwo
                              ,bookThree,bookFive,nil];
    totalPrice = 8*4*0.80;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno, Dos, Tres y Cinco");
    
}

- (void)testBuyBooksOneTwoFourAndFive
{
   
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookTwo
                              ,bookFour,bookFive,nil];
    totalPrice = 8*4*0.80;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno, Dos, Cuatro y Cinco");
        
}

- (void)testBuyBooksOneThreeFourAndFive
{  
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookThree
                              ,bookFour,bookFive,nil];
    totalPrice = 8*4*0.80;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno, Tres, Cuatro y Cinco");
        
}

- (void)testBuyBooksTwoThreeFourAndFive
{
    shoppingList = [[NSArray alloc]initWithObjects:bookTwo,bookThree
                              ,bookFour,bookFive,nil];    
    totalPrice = 8*4*0.80;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Dos, Tres, Cuatro y Cinco");
        
}

- (void)testBuyBooksOneTwoThreeFourAndFive
{

    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookTwo,bookThree
                              ,bookFour,bookFive,nil];
    totalPrice = 8*5*0.75;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar los libros Uno, Dos, Tres, Cuatro y Cinco");
        
}

- (void)testBuyAllBooksPlusOne
{

    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookTwo,bookThree
                              ,bookFour,bookFive,bookOne,nil];
    totalPrice = 8*5*0.75 + 8;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar todos los libros, y uno adicional del UNO");
    
}

- (void)testBuyAllBooksPlus2xOne
{
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookTwo,bookThree
                              ,bookFour,bookFive,bookOne,bookOne, nil];
    totalPrice = 8*5*0.75 + 8*2;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar todos los libros, y dos adicionales del UNO");

}

- (void)testBuyAllBooksx2
{
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookTwo,bookThree
                              ,bookFour,bookFive,bookOne,bookTwo,bookThree
                              ,bookFour,bookFive, nil];
    totalPrice = 8*10*0.75;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice, @"Fallo al comprar 2 veces todos los libros");
     
}
- (void)testBuyBookOneAndTwox2
{
    shoppingList = [[NSArray alloc]initWithObjects:bookOne,bookTwo,bookOne
                     ,bookTwo, nil];
    totalPrice = 8*4*0.95;
    STAssertEquals([bookStore priceForList:shoppingList], totalPrice , @"Fallo al comprar 2 veces todos los libros");
    
}





@end
