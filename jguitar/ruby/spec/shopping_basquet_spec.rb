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
end