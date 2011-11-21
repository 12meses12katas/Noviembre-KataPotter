
class Basket {

	def price(def books) {
		def discount = 0
		
		if(!books) return 0
		
		if(books.size() == 2){
			if(books[0] != books[1]){
				discount = 0.05
			}
		}
		
		(1 - discount) * 8 * books.size()
	}
}
