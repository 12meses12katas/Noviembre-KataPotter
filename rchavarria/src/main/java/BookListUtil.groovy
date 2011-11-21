
class BookListUtil {

	public def areAllDifferent(def books){
		if(! books) return true
		
		def orderedBooks = books.sort()
		
		for(int i = 1; i < orderedBooks.size(); i++){
			if(orderedBooks[i-1] == orderedBooks[i]){
				return false
			}
		}
		
		return true
	}
}
