
class Basket {
	private static DISCOUNT_FACTORS = [0, 0, 0.05, 0.1, 0.2, 0.25]

	private BookListUtil bookList = new BookListUtil()
	
	def price(def books) {
		if(!books) return 0
		
		def discount = computeDiscount(books)
		
		(1 - discount) * 8 * books.size()
	}
	
	private computeDiscount(def books){
		def discount = 0
		
		if(bookList.areAllDifferent(books)){
			def discountFactor = books.size()
			discount = DISCOUNT_FACTORS[discountFactor]
		}
		
		return discount
	}
}
