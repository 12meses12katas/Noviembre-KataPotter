
kataPotter.price = function(books){
    var basket = new Basket();
    basket.addBooks(books);
    return basket.price();
}

function Basket(){
    this.groups = [];
    this.groups[0] = new GroupOfUniqueBooks();
}

Basket.prototype.addBooks = function(books){
    for (var i in books){
        this.addBook(books[i]);
    }
}

Basket.prototype.addBook = function(book){
    if (!this.addBookInExistingGroup(book)){
        var newGroup = new GroupOfUniqueBooks();
        newGroup.push(book);
        this.groups.push(newGroup);
    }
}

Basket.prototype.addBookInExistingGroup = function(book){
    var positionForBestPrice = this.getGroupPositionForBestPrice(book);
    if (positionForBestPrice < 0){
        return false;
    }
    this.groups[positionForBestPrice].push(book);
    return true;
}

Basket.prototype.getGroupPositionForBestPrice = function(book){
    var positionForBestPrice = -1;
    var bestPrice = -1;
    for (var j  in this.groups){
        if (!this.groups[j].exists(book)){
            var newPrice = this.priceIfBookIsAddedToGroup(book, j);
            if ((bestPrice < 0) || (newPrice < bestPrice)){
                positionForBestPrice = j;
                bestPrice = newPrice;
            }
        }
    }
    return positionForBestPrice;
}

Basket.prototype.priceIfBookIsAddedToGroup = function(book, positionOfGroup){
    this.groups[positionOfGroup].push(book);
    var newPrice = this.price();
    this.groups[positionOfGroup].pop();
    
    return newPrice;
}

Basket.prototype.price = function() {
    var price = 0;
    for (var i in this.groups){
        price += this.groups[i].price();
    }
    return price;
}

Basket.prototype.toString = function() {
    var result = "";
    result += "price: [" + this.price() + "]\n";
    for (var i in this.groups){
        result += "  group (" + i + "): " + this.groups[i].toString() + "\n";
    }
    return result;
}


function GroupOfUniqueBooks(){
    this.books = [];
}

GroupOfUniqueBooks.prototype.exists = function(book){
    return (this.books.indexOf(book) >= 0) ? true : false;
}

GroupOfUniqueBooks.prototype.push = function(book){
    this.books.push(book);
}

GroupOfUniqueBooks.prototype.pop = function(){
    this.books.pop();
}

GroupOfUniqueBooks.prototype.price = function(){
    return (8 * this.books.length * this.calculateDiscount());
}

GroupOfUniqueBooks.prototype.calculateDiscount = function() {
    switch (this.books.length){
        case 2:return 0.95;
        case 3:return 0.9;
        case 4:return 0.8;
        case 5:return 0.75;
        default:return 1;
    }
}

GroupOfUniqueBooks.prototype.toString = function() {
    return this.books.toString();
}
