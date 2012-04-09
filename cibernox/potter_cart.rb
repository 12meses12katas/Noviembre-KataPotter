class PotterBook
  attr_accessor :title, :number
  
  def initialize(title)
    self.title = title
  end

  def ==(other)
    self.title == other.title
  end

  def <=>(other)
    self.title <=> other.title
  end
end

class PotterCart
  attr_accessor :books
  @@discounts = { 1 => 0.0, 2 => 0.05, 3 => 0.1, 4 => 0.2 }
  
  def initialize
    self.books = []
  end

  def <<(other)
    self.books << other
  end

  def find_packs
    packs = []
    content = books.dup
    while book = content.pop do
      if packs.empty? || packs.all?{ |pack| pack.include?(book) }
        packs << [book]  # Si esta vacio o todas las colleciones ya incluyen este libro, empiezo una nueva colección
      else
        dips = packs.find{ |pack| !pack.include?(book)}
        dips << book if dips
      end
    end
    packs.map(&:sort)
  end

  def total_amount
    find_packs.inject(0.0){ |sum, pack| sum + pack.size*8*(1.0 - (@@discounts[pack.size] || 0.25)) }
  end

end