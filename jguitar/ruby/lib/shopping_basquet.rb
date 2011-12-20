class Shopping_basquet
  
  def create_histogram(books)
    result = Hash.new(0)
    books.each { |book| result[book] += 1 }
  end
  
  def get_discount(histogram)
    discount = case
    when histogram.size <= 1
      1
    when histogram.size == 2
      0.95
    when histogram.size == 3
      0.90
    when histogram.size == 4
      0.80
    when histogram.size == 5
      0.75
    end
  end
  
  def prize(books)
    histogram = create_histogram(books)
    result = 8 * histogram.size * get_discount(histogram)
  end  
end
