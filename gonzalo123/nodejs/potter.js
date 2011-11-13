(function() {
  var Potter;
  Potter = (function() {
    function Potter() {
      this.discounts = [0, 1, 0.95, 0.9, 0.8, 0.75];
      this.basePrice = 8;
      this._blankBooks = [0, 0, 0, 0, 0];
      this._price = function(shopingCart) {
        var newBooks, size;
        size = this._calcSize(shopingCart);
        if (size === 0) {
          return 0;
        }
        newBooks = this._changeShoppingCart(shopingCart, size);
        return size * this.discounts[size] + this._price(newBooks);
      };
      this._calcSize = function(shopingCart) {
        var bookAmount, size, size2, _i, _len;
        size = size2 = 0;
        for (_i = 0, _len = shopingCart.length; _i < _len; _i++) {
          bookAmount = shopingCart[_i];
          if (bookAmount > 0) {
            size++;
          }
          if (bookAmount > 1) {
            size2++;
          }
        }
        if (size2 === 3 && size === 5) {
          return 4;
        }
        return size;
      };
      this._changeShoppingCart = function(shopingCart, toReduce) {
        var bookAmount, i, nextshopingCart, _i, _len;
        nextshopingCart = this._blankBooks;
        i = 0;
        for (_i = 0, _len = shopingCart.length; _i < _len; _i++) {
          bookAmount = shopingCart[_i];
          nextshopingCart[i] = bookAmount;
          if (bookAmount > 0 && toReduce > 0) {
            --toReduce;
            nextshopingCart[i] = bookAmount - 1;
          }
          i++;
        }
        return nextshopingCart;
      };
    }
    Potter.prototype.price = function(books) {
      var book, shopingCart, _i, _len;
      shopingCart = this._blankBooks;
      for (_i = 0, _len = books.length; _i < _len; _i++) {
        book = books[_i];
        shopingCart[book]++;
      }
      return this.basePrice * this._price(shopingCart);
    };
    return Potter;
  })();
  exports.Potter = Potter;
}).call(this);
