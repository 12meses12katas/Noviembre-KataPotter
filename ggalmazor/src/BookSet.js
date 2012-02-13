var BookSet = function () {
  this.books = [];
};
BookSet.pricePerBook = 8;
BookSet.prototype.contains = function (book) {
  return this.books.contains(book);
};
BookSet.prototype.add = function (book) {
  this.books.push(book);
};
BookSet.prototype.getPrice = function () {
  return this.applyDiscounts();
};
BookSet.prototype.applyDiscounts = function () {
  return this.getRawPrice() * this.getDiscountPercentage();
};
BookSet.prototype.getRawPrice = function () {
  return this.books.length * BookSet.pricePerBook;
};
BookSet.prototype.getDiscountPercentage = function () {
  if (2 == this.books.length)
    return 0.95;
  if (3 == this.books.length)
    return 0.90;
  if (4 == this.books.length)
    return 0.80;
  if (5 == this.books.length)
    return 0.75;
  return 1;
};