class Shopping_basquet
  
  def refine_sets(sets)
    if sets.include?(3) && sets.include?(5)
      sets[sets.index(3)] = 4
      sets[sets.index(5)] = 4
    end
    return sets
  end
  
  def create_sets(books)
    histogram = Hash.new(0)
    books.each { |book| histogram[book] += 1 }
    
    result = []
    while ! histogram.empty?
      result << histogram.size
      histogram.each { |book, count| histogram[book] -= 1 }
      histogram.delete_if { |book, count| count == 0 }
    end
      
    result = refine_sets(result)
      
    return result
  end
  
  def prize(books)
    discounts_table = {
      0 => 1,
      1 => 1,
      2 => 0.95,
      3 => 0.9,
      4 => 0.8,
      5 => 0.75
    }
    
    sets = create_sets(books)
    
    result = 0
    sets.each do |set|
      discount = discounts_table[set]
      result += set * discount * 8
    end
    
    return result
  end  
end
