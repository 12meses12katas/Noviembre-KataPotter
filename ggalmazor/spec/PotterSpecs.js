describe('basket price calculator', function () {
  var basket, price;
  describe('does not apply any discounts', function () {
    it('to a set with 1 title', function () {
      basket = [1];
      price = Basket.getPrice(basket);
      expect(price).toBe(BookSet.pricePerBook);
    });
  });
  describe('applies discounts', function () {
    it('of 5% to a set of two different titles', function () {
      basket = [1, 2];
      price = Basket.getPrice(basket);
      expect(price).toBe(2 * BookSet.pricePerBook * 0.95)
    });
    it('of 10% to a set of three different titles', function () {
      basket = [1, 2, 3];
      price = Basket.getPrice(basket);
      expect(price).toBe(3 * BookSet.pricePerBook * 0.90);
    });
    it('of 20% to a set of four different titles', function () {
      basket = [1, 2, 3, 4];
      price = Basket.getPrice(basket);
      expect(price).toBe(4 * BookSet.pricePerBook * 0.80);
    });
    it('of 25% to a set of five different titles', function () {
      basket = [1, 2, 3, 4, 5];
      price = Basket.getPrice(basket);
      expect(price).toBe(5 * BookSet.pricePerBook * 0.75);
    });
  });
  describe('builds sets from baskets', function () {
    it('for every repeating title', function () {
      basket = [1, 1];
      price = Basket.getPrice(basket);
      expect(price).toBe(2 * BookSet.pricePerBook);
    });
    describe('always tries to complete sets', function () {
      it('spread over all book sets', function () {
        basket = [1, 1, 2, 2];
        price = Basket.getPrice(basket);
        expect(price).toBe((2 * BookSet.pricePerBook * 0.95) * 2);
      });
      it('favours for 4 title sets over 5 title sets', function () {
        basket = [1, 1, 2, 2, 3, 3, 4, 5];
        price = Basket.getPrice(basket);
        expect(price).toBe((4 * BookSet.pricePerBook * 0.80) * 2);
      });
    });
  })
});