def calculateshopping = { basket ->
	def price = 8//Price in euros
	def discounts = [0,5,10,20,25]//Discounts per buy
	def totalprice = 0
	def sw = false
	while (!sw){
		sw = true
		def pack = 0
		basket = basket.collect {
			if (it>1){
				pack++
				sw = false
				it - 1
			}
			else if (it==1){
				pack++
				it - 1
			}
			else
				it
		}
		totalprice += pack*price*((100-discounts[pack-1])/100)
	}
	return totalprice
}


assert calculateshopping([2,2,2,1,0])==47.2
assert calculateshopping([4,2,0,3,2])==74.4
assert calculateshopping([1,0,0,0,0])==8
assert calculateshopping([1,1,0,0,0])==15.2
assert calculateshopping([1,1,1,0,0])==21.6
assert calculateshopping([1,1,1,1,0])==25.6
assert calculateshopping([1,1,1,1,1])==30
assert calculateshopping([5,5,5,5,5])==150
