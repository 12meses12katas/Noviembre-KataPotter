class Potter
    constructor: () ->
        @discounts   = [0, 1, 0.95, 0.9, 0.8, 0.75]
        @basePrice   = 8
        @_blankBooks = [0, 0, 0, 0, 0]

        @_price = (shopingCart) ->
            size = @_calcSize shopingCart
            return 0 if size is 0
            newBooks = @_changeShoppingCart(shopingCart, size)
            size * @discounts[size] + @_price(newBooks)

        @_calcSize = (shopingCart) ->
            size = size2 = 0
            for bookAmount in shopingCart
                size++  if bookAmount > 0
                size2++ if bookAmount > 1
            if size2 is 3 and size is 5
                return 4
            size

        @_changeShoppingCart = (shopingCart, toReduce) ->
            nextshopingCart = @_blankBooks
            i = 0
            for bookAmount in shopingCart
                nextshopingCart[i] = bookAmount
                if bookAmount > 0 and toReduce > 0
                    --toReduce
                    nextshopingCart[i] = bookAmount - 1
                i++
            nextshopingCart

    price: (books) ->
        shopingCart = @_blankBooks
        for book in books
            shopingCart[book]++
        @basePrice * @_price(shopingCart)

exports.Potter = Potter
