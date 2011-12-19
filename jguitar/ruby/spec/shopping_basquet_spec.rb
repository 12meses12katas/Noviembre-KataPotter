require 'shopping_basquet'

describe "Shopping Basquet Basic Specs" do
  it "should be a price of 0 with 0 items" do
    basquet = Shopping_basquet.new
    prize = basquet.prize([])
    prize.should == 0
  end
  
  it "should be costs 8 EUR with one copy of any of the five books" do
    basquet = Shopping_basquet.new
    prize = basquet.prize([1])
    prize.should == 8
  end
end