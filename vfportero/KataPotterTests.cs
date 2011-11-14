using NUnit.Framework;

namespace Noviembre_KataPotter
{
    [TestFixture]
    class KataPotterTests
    {
        BookPriceCalculator _bookPriceCalculator;

        [SetUp]
        public void SetUp()
        {
            _bookPriceCalculator = new BookPriceCalculator();

        }

        [Test]
        public void EmptyBasket()
        {
            Assert.AreEqual(0, _bookPriceCalculator.CalculateBasket(new int[] { }));
        }

        [Test]
        public void OneBook()
        {
            Assert.AreEqual(8, _bookPriceCalculator.CalculateBasket(new int[] { 0 }));
        }

        [Test]
        public void TwoSameBook()
        {
            Assert.AreEqual(8 * 2, _bookPriceCalculator.CalculateBasket(new int[] { 0, 0 }));
        }

        [Test]
        public void ThreeSameBooks()
        {
            Assert.AreEqual(8 * 3, _bookPriceCalculator.CalculateBasket(new int[] { 0, 0, 0 }));
        }

        [Test]
        public void FourSameBooks()
        {
            Assert.AreEqual(8 * 4, _bookPriceCalculator.CalculateBasket(new int[] { 0, 0, 0, 0 }));
        }

        [Test]
        public void FiveSameBooks()
        {
            Assert.AreEqual(8 * 5, _bookPriceCalculator.CalculateBasket(new int[] { 0, 0, 0, 0, 0 }));
        }

        [Test]
        public void TwoDifferentBooks()
        {
            Assert.AreEqual(8 * 2 * 0.95, _bookPriceCalculator.CalculateBasket(new int[] { 0, 1 }));
        }

        [Test]
        public void ThreeDifferentBooks()
        {
            Assert.AreEqual(8 * 3 * 0.9, _bookPriceCalculator.CalculateBasket(new int[] { 0, 1, 2 }));
        }

        [Test]
        public void FourDifferentBooks()
        {
            Assert.AreEqual(8 * 4 * 0.8, _bookPriceCalculator.CalculateBasket(new int[] { 0, 1, 2, 3 }));
        }

        [Test]
        public void FiveDifferentBooks()
        {
            Assert.AreEqual(8 * 5 * 0.75, _bookPriceCalculator.CalculateBasket(new int[] { 0, 1, 2, 3, 4 }));
        }

        [Test]
        public void SeveralDiscountsTwo_One()
        {
            Assert.AreEqual(8 + (8 * 2 * 0.95), _bookPriceCalculator.CalculateBasket(new int[] { 0, 0, 1 }));
        }

        [Test]
        public void SeveralDiscountsTwoTwo()
        {
            Assert.AreEqual(2 * (8 * 2 * 0.95), _bookPriceCalculator.CalculateBasket(new int[] { 0, 0, 1, 1 }));
        }

        [Test]
        public void SeveralDiscountsFourTwo()
        {
            Assert.AreEqual((8 * 4 * 0.8) + (8 * 2 * 0.95), _bookPriceCalculator.CalculateBasket(new int[] { 0, 0, 1, 2, 2, 3 }));
        }

        [Test]
        public void SeveralDiscountsFiveOne()
        {
            Assert.AreEqual(8 + (8 * 5 * 0.75), _bookPriceCalculator.CalculateBasket(new int[] { 0, 1, 1, 2, 3, 4 }));
        }

        [Test]
        public void SeveralDiscountsFourFour()
        {
            Assert.AreEqual(2 * (8 * 4 * 0.8), _bookPriceCalculator.CalculateBasket(new int[] { 0, 0, 1, 1, 2, 2, 3, 4 }));
        }



        [Test]
        public void SeveralDiscountsFiveFiveFiveFourFour()
        {
            Assert.AreEqual(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), _bookPriceCalculator.CalculateBasket(new int[] { 0, 0, 0, 0, 0, 
           1, 1, 1, 1, 1, 
           2, 2, 2, 2, 
           3, 3, 3, 3, 3, 
           4, 4, 4, 4 }));
        }

    }
}
