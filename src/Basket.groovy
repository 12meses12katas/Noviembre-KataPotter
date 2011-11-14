
class Basket {
	int result
	List books
	
	Basket() {
		this.books = []
	}
	
	int getResult() {
		books.size() * 8
	}
	
	void leftShift(def book) {
		books << book
	}
}
