var Basket = function() {};
Basket.getPrice = function(books) {
  return BookSetPool.factory(books).getPrice();
};