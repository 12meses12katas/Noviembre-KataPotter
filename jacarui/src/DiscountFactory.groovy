
class DiscountFactory {

	static def getDiscountByNumber(int number) {
		def DISCOUNTS = [1, 0.95, 0.9, 0.8, 0.75]
		DISCOUNTS[number - 1]
	}
}
