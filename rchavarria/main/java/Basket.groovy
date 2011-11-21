
class Basket {

	def price(def books) {
		if(!books) return 0
		
		def discount = computeDiscount(books)
		
		(1 - discount) * 8 * books.size()
	}
	
	private computeDiscount(def books){
		def discount = 0
		if(books.size() == 2){
			if(books[0] != books[1]){
				discount = 0.05
			}
		}
		
		return discount
	}
}
