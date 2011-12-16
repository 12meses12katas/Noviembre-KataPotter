'''
Created on 08/12/2011

@author: ruben
'''
import unittest
from KataPotter import BooksList


class Test(unittest.TestCase):

    def testPriceOneBook(self):
        books2Buy = BooksList([1, 0, 0, 0, 0])
        expectedPrice = 8.0 * 1 * 1
        self.assertEquals(books2Buy.prices(), expectedPrice, "{0} != {1}".format(books2Buy.prices(), expectedPrice))
    
    def testPriceTwoSameBooks(self):
        books2Buy = BooksList([2, 0, 0, 0, 0])
        expectedPrice = (8.0 * 1 * 1) + (8.0 * 1 * 1)
        self.assertEquals(books2Buy.prices(), expectedPrice, "{0} != {1}".format(books2Buy.prices(), expectedPrice))
        
    def testPriceTwoDifferentBooks(self):
        books2Buy = BooksList([1, 1, 0, 0, 0])
        expectedPrice = (8.0 * 2 * 0.95)
        self.assertEquals(books2Buy.prices(), expectedPrice, "{0} != {1}".format(books2Buy.prices(), expectedPrice))
        
    def testPriceThreeDifferentBooks(self):
        books2Buy = BooksList([1, 1, 1, 0, 0])
        expectedPrice = (8.0 * 3 * 0.90)
        self.assertEquals(books2Buy.prices(), expectedPrice, "{0} != {1}".format(books2Buy.prices(), expectedPrice))
        
    def testPriceTwoSameBooksThreeDifferentBooks(self):
        books2Buy = BooksList([2, 1, 1, 0, 0])
        expectedPrice = (8.0 * 3 * 0.90) + (8.0 * 1 * 1)
        self.assertEquals(books2Buy.prices(), expectedPrice, "{0} != {1}".format(books2Buy.prices(), expectedPrice))
    
    def testPriceTwoSameAndDifferentBooks(self):
        books2Buy = BooksList([2, 2, 0, 0, 0])
        expectedPrice = (8.0 * 2 * 0.95) + (8.0 * 2 * 0.95)
        self.assertEquals(books2Buy.prices(), expectedPrice, "{0} != {1}".format(books2Buy.prices(), expectedPrice))
        
    def testPriceDifferentCasesOfBooksWithTwoRepetitionsMax(self):
        books2Buy = BooksList([2, 2, 1, 0, 0])
        expectedPrice = (8.0 * 3 * 0.90) + (8.0 * 2 * 0.95)
        self.assertEquals(books2Buy.prices(), expectedPrice, "{0} != {1}".format(books2Buy.prices(), expectedPrice))
                
        books2Buy = BooksList([2, 2, 1, 1, 0])
        expectedPrice = (8.0 * 4 * 0.80) + (8.0 * 2 * 0.95)
        self.assertEquals(books2Buy.prices(), expectedPrice, "{0} != {1}".format(books2Buy.prices(), expectedPrice))
                
        books2Buy = BooksList([2, 2, 2, 1, 0])
        expectedPrice = (8.0 * 4 * 0.80) + (8.0 * 3 * 0.90)
        self.assertEquals(books2Buy.prices(), expectedPrice, "{0} != {1}".format(books2Buy.prices(), expectedPrice))
                
        books2Buy = BooksList([2, 2, 2, 1, 1])
        expectedPrice = (8.0 * 4 * 0.80) + (8.0 * 4 * 0.80)
        self.assertEquals(books2Buy.prices(), expectedPrice, "{0} != {1}".format(books2Buy.prices(), expectedPrice))
        
        books2Buy = BooksList([2, 2, 2, 2, 1])
        expectedPrice = (8.0 * 5 * 0.75) + (8.0 * 4 * 0.80)
        self.assertEquals(books2Buy.prices(), expectedPrice, "{0} != {1}".format(books2Buy.prices(), expectedPrice))

    def testPriceDifferentCasesOfBooksWithNoMaxRepetitions(self):
        books2Buy = BooksList([5, 5, 4, 5, 4])
        expectedPrice = (3 * (8.0 * 5 * 0.75)) + (2 * (8.0 * 4 * 0.80))
        self.assertEquals(books2Buy.prices(), expectedPrice, "{0} != {1}".format(books2Buy.prices(), expectedPrice))
if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()