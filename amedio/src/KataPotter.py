'''
Created on 08/12/2011

@author: ruben
'''

class BooksList(object):
    '''
    classdocs
    '''
    
    def addDifferentBook(self, i, numDifferentBooks):
        if len(numDifferentBooks) <= i:
            numDifferentBooks.append(0)
                
        if numDifferentBooks[i] == 4 or numDifferentBooks[i] == 5:
            numDifferentBooks[i+1] += 1
        else:
            numDifferentBooks[i] += 1

    def prices(self):
        totalPrice = 0.0
        numDifferentBooks = [0, 0]
        for books in self.listOfBooks:
            i = 0
            while (books != 0):
                self.addDifferentBook(i, numDifferentBooks)                    
                i += 1
                books -= 1
                
        for numBooksPerLevel in numDifferentBooks:
            totalPrice += 8.0 * numBooksPerLevel * self.discountRates[numBooksPerLevel]
        return totalPrice
    
    def __init__(self, listOfBooks):
        self.listOfBooks = listOfBooks
        self.discountRates = [0.0, 1.0, 0.95, 0.90, 0.80, 0.75]
        