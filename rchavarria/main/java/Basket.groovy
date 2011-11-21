
class Basket {

	private BookListUtil bookList = new BookListUtil()
	
	def price(def books) {
		if(!books) return 0
		
		def discount = computeDiscount(books)
		
		(1 - discount) * 8 * books.size()
	}
	
	private computeDiscount(def books){
		def discount = 0
		
		if(books.size() == 2){
			if(bookList.areAllDifferent(books)){
				discount = 0.05
			}
		}
		
		if(books.size() == 3){
			if(bookList.areAllDifferent(books)){
				discount = 0.1
			}
		}
		
		return discount
	}
}
