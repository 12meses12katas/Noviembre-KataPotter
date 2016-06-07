
class PriceCalculator {
	private int BOOK_PRICE = 8
	private double price
	private Map groupedBooks
	
	def calculate(def books) {
		price = 0
		group books
		sumGroupedBooksPrice()
		price
	}
	
	private void group(books) {
		groupedBooks = books?.countBy { it.name }
	}
	
	private void sumGroupedBooksPrice() {
		getMaxBookNumber(groupedBooks)?.times {
			price += discountedGroupPrice(groupedBooks)
			groupedBooks = cleanBlankGroups(groupedBooks)
		}
	}
	
	private def getMaxBookNumber (Map groupedBooks) {
		groupedBooks?.max { it.value }?.value 
	}
	
	private def discountedGroupPrice(groupedBooks) {
		def booksForDiscount = groupedBooks.size()
		def discountForGroup = DiscountFactory.getDiscountByNumber(booksForDiscount)
		BOOK_PRICE * booksForDiscount * discountForGroup
	}
	
	private def cleanBlankGroups(groupedBooks) {
		groupedBooks = groupedBooks.collectEntries { key, value -> [key, value - 1] }
		groupedBooks - groupedBooks.findAll { key, value -> value == 0 }
	}
}
