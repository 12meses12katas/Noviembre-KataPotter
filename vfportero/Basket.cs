using System.Collections.Generic;
using System.Linq;

namespace Noviembre_KataPotter
{
    
    internal class Basket
    {
        List<BookPack> BookPacks = new List<BookPack>();

        public Basket()
        {
            BookPacks = new List<BookPack>();
        }

        public void AddBookToCheapestPack(int bookCode)
        {
            BookPack cheapestPack = null;

            foreach (var bookPack in BookPacks)
            {
                if (!bookPack.HasThisBook(bookCode))
                {
                    if (cheapestPack == null)
                    {
                        cheapestPack = bookPack;
                    }
                    else
                    {
                        if (BookPack.GetPriceIncrement(bookPack.Books.Count) < BookPack.GetPriceIncrement(cheapestPack.Books.Count))
                        {
                            cheapestPack = bookPack;
                        }
                    }
                }
            }

            if (cheapestPack == null)
            {
                BookPacks.Add(new BookPack(bookCode));
            }
            else
            {
                cheapestPack.Books.Add(bookCode);
            }
        }

        public double GetTotalPrice()
        {
            return BookPacks.Sum(bookPack => BookPack.GetBookPackPrice(bookPack.Books.Count));
        }
    }
}