
class IntelligentBookGroup {

	public compute(def books){
		def groups = [][]
		
        def sortedBooks = books.sort()
        
        def countZeros = (sortedBooks.findAll { it == 0 }).size()

        (1..countZeros).each {
            groups[it - 1] = []
		}
        
        int i = 0
        int j = 0
        sortedBooks.each {
            groups[i][j] = it
            i++
            
            if(i == countZeros){
                i = 0
                j++
            }
        }
        
		groups
	}
}
