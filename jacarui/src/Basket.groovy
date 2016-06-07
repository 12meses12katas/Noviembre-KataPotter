
class Basket {
	private List books
	private priceCalculator
	
	Basket() {
		this.books = []
		this.priceCalculator = new PriceCalculator()
	}
	
	int getResult() {
		priceCalculator.calculate(books)
	}
	
	void leftShift(def book) {
		books << book
		books = books.flatten()
	}
}
