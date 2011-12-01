
class Basket {
	private static DISCOUNT_FACTORS = [0, 0, 0.05, 0.1, 0.2, 0.25]

	private BookListUtil bookList = new BookListUtil()
	
	def price(def books) {
		if(!books) return 0

        def normalPrice = calculatePrice(new BookGroup(), books)
        def intelligentPrice = calculatePrice(new IntelligentBookGroup(), books)
        
        return [normalPrice, intelligentPrice].min()
	}
    
    private calculatePrice(def bookGroup, def books){
        def bookGroups = bookGroup.compute(books)
                
        def groupPrices = bookGroups.collect {
            def discount = computeDiscount(it)
            return (1 - discount) * 8 * it.size()
        }
        
        return groupPrices.sum()
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
