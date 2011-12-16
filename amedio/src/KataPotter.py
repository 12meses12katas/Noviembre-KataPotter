'''
Created on 08/12/2011

@author: ruben
'''

class BooksList(object):
    '''
    classdocs
    '''
    
    def prices(self):
        totalPrice = 0.0
        numDifferentBooks = [0, 0]
        for books in self.listOfBooks:
            i = 0
            while (books != 0):
                numDifferentBooks[i] += 1
                i += 1
                books -= 1
        for numBooksPerLevel in numDifferentBooks:
            totalPrice += 8.0 * numBooksPerLevel * self.discountRates[numBooksPerLevel]
        return totalPrice

    def __init__(self, listOfBooks):
        self.listOfBooks = listOfBooks
        self.discountRates = [0.0, 1.0, 0.95, 0.90, 0.80, 0.75]
        