
namespace Noviembre_KataPotter
{
    internal class BookPriceCalculator
    {


        public double CalculateBasket(int[] books)
        {
            Basket basket = new Basket();
            
            foreach (int bookCode in books)
            {
                basket.AddBookToCheapestPack(bookCode);
            }

            return basket.GetTotalPrice();  
        }

    }
}
