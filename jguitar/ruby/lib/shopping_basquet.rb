class Shopping_basquet
  
  def create_sets(books)
    histogram = Hash.new(0)
    books.each { |book| histogram[book] += 1 }
    
    result = []
    while ! histogram.empty?
      result << histogram.size
      histogram.each { |book, count| histogram[book] -= 1 }
      
      histogram.delete_if { |book, count| count == 0 }
      
    end
    
    return result
  end
  
  def prize(books)
    sets = create_sets(books)
    
    result = 0
    
    sets.each do |set|
      discount = case
      when set <= 1
        1
      when set == 2
        0.95
      when set == 3
        0.90
      when set == 4
        0.80
      when set == 5
        0.75
      end
      result += set * discount * 8
    end
    
    return result
  end  
end
