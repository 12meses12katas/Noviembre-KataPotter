'''
Created on 08/12/2011

@author: ruben
'''
import unittest
from KataPotter import BooksList


class Test(unittest.TestCase):

    def testPriceOneBook(self):
        books2Buy = BooksList([1, 0, 0, 0, 0])
        self.assertEquals(books2Buy.prices(), 8.0, books2Buy.prices())
    
    def testPriceTwoSameBooks(self):
        books2Buy = BooksList([2, 0, 0, 0, 0])
        self.assertEquals(books2Buy.prices(), 8.0 * 2, books2Buy.prices())
        
    def testPriceTwoDifferentBooks(self):
        books2Buy = BooksList([1, 1, 0, 0, 0])
        self.assertEquals(books2Buy.prices(), 15.2, books2Buy.prices())
        
    def testPriceThreeDifferentBooks(self):
        books2Buy = BooksList([1, 1, 1, 0, 0])
        self.assertEquals(books2Buy.prices(), (24.0 * 90) / 100, books2Buy.prices())
        
    def testPriceTwoSameBooksThreeDifferentBooks(self):
        books2Buy = BooksList([2, 1, 1, 0, 0])
        self.assertEquals(books2Buy.prices(), 8.0 + ((24.0 * 90) / 100), books2Buy.prices())

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()