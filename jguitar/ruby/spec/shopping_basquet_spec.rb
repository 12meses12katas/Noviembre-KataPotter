require 'shopping_basquet'

describe "Shopping Basquet Spec" do
  it "should be a price of 0 with 0 items." do
    basquet = Shopping_basquet.new
    prize = basquet.prize(0)
    prize.should == 0
  end
end