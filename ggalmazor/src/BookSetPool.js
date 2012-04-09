var BookSetPool = function () {
  this.bookSets = [];
};
BookSetPool.factory = function (books) {
  var pool = new BookSetPool();
  pool.init(books);
  return pool;
};
BookSetPool.prototype.getPrice = function () {
  return this.bookSets.sum(function (bookSet) {
    return bookSet.getPrice();
  });
};
BookSetPool.prototype.newInstance = function () {
  var bookSet = new BookSet();
  this.bookSets.push(bookSet);
  return bookSet;
};
BookSetPool.prototype.candidates = function (book) {
  return this.bookSets.find(function (it) {
    return !it.contains(book);
  });
};
BookSetPool.prototype.hasCandidates = function (book) {
  return !this.candidates(book).isEmpty();
};
BookSetPool.prototype.bestCandidates = function (book) {
  return this.candidates(book).find(function (it) {
    return it.books.length == 3;
  });
};
BookSetPool.prototype.hasBestCandidates = function (book) {
  return !this.bestCandidates(book).isEmpty();
};
BookSetPool.prototype.getOrCreateFor = function (book) {
  if (this.hasBestCandidates(book))
    return this.bestCandidates(book).first();
  if (this.hasCandidates(book))
    return this.candidates(book).first();
  return this.newInstance(book);
};
BookSetPool.prototype.init = function (books) {
  books.each(function (book) {
    this.getOrCreateFor(book).add(book);
  }.bind(this));
};