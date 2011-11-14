using System.Collections.Generic;

namespace Noviembre_KataPotter
{
    internal class BookPack
    {
        public const double BASICBOOKPRICE = 8;
        public List<int> Books;

        public BookPack()
        {
            Books = new List<int>();
        }

        public BookPack(int bookCode)
        {
            Books = new List<int>();
            Books.Add(bookCode);
        }


        public static double GetBookPackPrice(int quantity)
        {
            return BASICBOOKPRICE *quantity * GetDiscountPerDifferentBooks(quantity);
        }

        public static double GetPriceIncrement(int quantity)
        {
            return GetBookPackPrice(quantity + 1) - GetBookPackPrice(quantity);
        }

        private static double GetDiscountPerDifferentBooks(int quantity)
        {
            switch (quantity)
            {
                case 1:
                    {
                        return 1;
                        break;
                    }
                case 2:
                    {
                        return 0.95;
                        break;
                    }
                case 3:
                    {
                        return 0.9;
                        break;
                    }
                case 4:
                    {
                        return 0.8;
                        break;
                    }
                case 5:
                    {
                        return 0.75;
                        break;
                    }
            }

            return 0;
        }

        public bool HasThisBook(int bookCode)
        {
            return Books.IndexOf(bookCode) != -1;
        }
    }
}