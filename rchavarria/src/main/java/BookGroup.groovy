
class BookGroup {

	public compute(def books){
		def groups = [][]
		
		books.each {
			clasifyBook(groups, it)
		}
		
		groups
	}
	
	private clasifyBook(def groups, def book){
		initGroup(groups, 0)
			
		if(! groups[0].contains(book)){
			groups[0].add(book)
		} else {
			initGroup(groups, 1)
			groups[1].add(book)
		}
	}
	
	private initGroup(def groups, def idx){
		if(!groups[idx])
			groups[idx] = []
	}
}
