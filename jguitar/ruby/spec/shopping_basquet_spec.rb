require 'shopping_basquet'

describe "Shopping Basquet Basic Specs" do
  before(:each) do
   @sb = Shopping_basquet.new
  end

  it "should be a price of 0 with 0 items" do
    prize = @sb.prize([])
    prize.should eql 0
  end
  
  it "should be costs 8 EUR with one copy of any of the five books" do
    prize = @sb.prize([1])
    prize.should eql 8
  end
  
  it "should be get a 5% discount if you buy two different books from the series" do
    prize = @sb.prize([1, 2])
    prize.should eql 8 * 2 * 0.95
  end
  
  it "should be get a 10% discount if you buy three different books from the series" do
    prize = @sb.prize([1, 2, 3])
    prize.should eql 8 * 3 * 0.90
  end
  
  it "should be get a 20% discount if you buy four different books from the series" do
    prize = @sb.prize([1, 2, 3, 4])
    prize.should eql 8 * 4 * 0.80
  end
  
  it "should be get a 25% discount the whole hog" do
    prize = @sb.prize([1, 2, 3, 4, 5])
    prize.should eql 8 * 5 * 0.75
  end
  
  it "should be get a 10% discount if you buy four books, but 3 are different titles. And the fourth still costs 8 EUR" do
    prize = @sb.prize([1, 2, 3, 3])
    prize.should eql(8 + (8 * 3 * 0.90))
  end
  
  it "should be 51.20 EUR if you buy two 1st, two 2nd, two 3rd, one 4th and one 5th" do
    prize = @sb.prize([1, 1, 2, 2, 3, 3, 4, 5])
    prize.should eql 51.20
  end
end