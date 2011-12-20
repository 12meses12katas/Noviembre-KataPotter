class Shopping_basquet
  def prize(books)
    if books.empty?
      result = 0
    else
      result = 8 * books.size
    end
    
    if books.size > 1
      result *= 1 - ((books.size - 1) * 0.05)
    end
    
    return result
  end  
end
