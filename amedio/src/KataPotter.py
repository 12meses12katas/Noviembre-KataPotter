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
        numDifferentBooks = 0
        for books in self.listOfBooks:
            if (books != 0):
                totalPrice += 8.0 * (books - 1)
                numDifferentBooks += 1
            
        totalPrice += ((8.0 * numDifferentBooks) * (100 - ((numDifferentBooks - 1) * 5))) / 100
        return totalPrice

    def __init__(self, listOfBooks):
        self.listOfBooks = listOfBooks
        