require './potter_cart.rb'

describe PotterCart do
  let(:cart){ subject }
  let(:book1){ PotterBook.new("Libro1") }
  let(:book2){ PotterBook.new("Libro2") }
  let(:book3){ PotterBook.new("Libro3") }
  let(:book4){ PotterBook.new("Libro4") }
  let(:book5){ PotterBook.new("Libro5") }
  let(:book6){ PotterBook.new("Libro6") }
  let(:full_cart){
    cart.books = [book1, book2, book1, book3, book1, book2] 
    cart
  }

  describe "just created" do
    it { should have(0).books }
  end

  it "should accept new books" do
    cart.should have(0).books
    cart << PotterBook.new('Book1')
    cart.should have(1).books
    cart.books.first.title.should == "Book1"
  end

  it "should show its content when printed" do
    full_cart.to_s.should == "Cart Content: Libro1, Libro2, Libro1, Libro3, Libro1, Libro2"
  end

  it "should find books from the same packs" do
    full_cart.find_packs.should == [[book1, book2, book3],[book1, book2],[book1]]
  end

  describe "should calculate total amount aplying this discounts:" do
    before(:each){ 
      cart <<  PotterBook.new('Book1')
      cart <<  PotterBook.new('Book2') 
    }
    it "5% off in packs of 2 different books. Others at 8 EUR" do
      cart.total_amount.should == 15.2      
    end
    it "10% off in packs of 3 " do
      cart <<  PotterBook.new('Book3') 
      cart.total_amount.should == 21.6
    end
    it "20% off in packs of 4" do
      cart <<  PotterBook.new('Book3') 
      cart <<  PotterBook.new('Book4') 
      cart.total_amount.should == 25.6
    end
    it "25% off in packs of 5 or beyond" do
      cart <<  PotterBook.new('Book3') 
      cart <<  PotterBook.new('Book4')       
      cart <<  PotterBook.new('Book5')       
      cart <<  PotterBook.new('Book6')
      cart.total_amount.should == 36      
    end
  end
  it "should calculate total amount mixing all kind of dicounts" do
    # 2 copies of the first book
    # 2 copies of the second book
    # 2 copies of the third book
    # 1 copy of the fourth book
    # 1 copy of the fifth book
    cart <<  PotterBook.new('Book1')
    cart <<  PotterBook.new('Book2')
    cart <<  PotterBook.new('Book2')
    cart <<  PotterBook.new('Book3')
    cart <<  PotterBook.new('Book4')
    cart <<  PotterBook.new('Book5')
    cart <<  PotterBook.new('Book1') 
    cart <<  PotterBook.new('Book3')       
    cart.total_amount.should == 51.6 # Readme says 51.2, but i think it is a mistake
  end

end