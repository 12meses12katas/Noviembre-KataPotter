
kataPotter.price = function(books){
    var groups = this.groupByDifferentBooks(books);
    log(groups.forEach(logArrayElements));
    var price = 0;
    for (var i = 0; i<groups.length; i++){
        price += groups[i].priceOfBooksGroup();
    }
    return price;
}

kataPotter.groupByDifferentBooks = function(books) {
    var groups = [];
    groups[0] = [];
    for (var i=0; i<books.length; i++){
        var book = books[i];
        var isAdded = false;
        for (var j=0; j<groups.length; j++){
            if (groups[j].indexOf(book) < 0){
                groups[j].push(book);
                isAdded = true;
                break;
            }
        }
        if (!isAdded){
            groups.push([book]);
        }
    }
    
    return groups;
}

kataPotter.optimizeGroups = function(groups){
    

}

Array.prototype.priceOfBooksGroup = function() {
    return (8 * this.length * this.calculateDiscount());
}

Array.prototype.calculateDiscount = function() {
    switch (this.length){
        case 2:return 0.95;
        case 3:return 0.9;
        case 4:return 0.8;
        case 5:return 0.75;
        default:return 1;
    }
}

function logArrayElements(element, index, array) {
    log("grupo[" + index + "] = " + element);
}