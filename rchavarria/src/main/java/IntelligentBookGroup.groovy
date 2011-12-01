
class IntelligentBookGroup {
    private FIRST_BOOK = 0
    private LAST_BOOK = 4
    
	public compute(def books){
        def sortedBooks = books.sort()
        
        def occurenciesOfBook = (FIRST_BOOK..LAST_BOOK).collect {
            def book = it
            return (sortedBooks.findAll { it == book }).size()
        }
        
        def mostBookOcurrences = occurenciesOfBook.max()

        def groups = [][]
        (1..mostBookOcurrences).each {
            groups[it - 1] = []
		}
        
        int i = 0
        int j = 0
        sortedBooks.each {
            groups[i][j] = it
            i++
            
            if(i == mostBookOcurrences){
                i = 0
                j++
            }
        }
        
		groups
	}
}
