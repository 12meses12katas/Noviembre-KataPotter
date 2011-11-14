namespace Noviembre_KataPotter
{
    internal class BookItem
    {
        public const double BASICPRICE = 8;

        public int BookCode;
        public int Quantity;

        public BookItem(int numberOfBook, int quantity)
        {
            BookCode = numberOfBook;
            Quantity = quantity;
        }
    }
}