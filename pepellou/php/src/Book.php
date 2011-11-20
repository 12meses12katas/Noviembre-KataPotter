<?php

class NoSuchBook extends Exception {}

class Book {

	public static $FIRST  = "Harry Potter and the Philosopher's Stone";
	public static $SECOND = "Harry Potter and the Chamber of Secrets";
	public static $THIRD  = "Harry Potter and the Prisoner of Azkaban";
	public static $FOURTH = "Harry Potter and the Goblet of Fire";
	public static $FIFTH  = "Harry Potter and the Order of the Phoenix";

	private $name;

	public function __construct(
		$book_name
	) {
		$this->name = $book_name;
		if (!$this->exists())
			throw new NoSuchBook;
	}

	private function exists(
	) {
		$known_books = array(
			self::$FIRST,
			self::$SECOND,
			self::$THIRD,
			self::$FOURTH,
			self::$FIFTH
		);
		return (in_array($this->name, $known_books));
	}

	public function price(
	) {
		return 8;
	}

	public function __toString(
	) {
		return $this->name;
	}

}

class Pack {

	private $books;
	private $subpacks;

	public function __construct(
	) {
		$this->books = func_get_args();
		$this->refreshSubpacks();
	}

	private function refreshSubpacks(
	) {
		if (!$this->isAtomic())
			$this->buildSubpacks();
	}

	public function addBook(
		$book
	) {
		$this->books []= $book;
	}

	public function contains(
		$book
	) {
		return (in_array($book, $this->books));
	}

	public function buildSubpacks(
	) {	
		$subpacks = array();
		foreach ($this->books as $book) {
			$placed = false;
			foreach ($subpacks as $subpack) {
				if (!$placed) {
					if (!$subpack->contains($book)) {
						$subpack->addBook($book);
						$placed = true;
					}
				}
			}
			if (!$placed) {
				$subpacks []= new Pack($book);
			}
		}
		$this->subpacks = $subpacks;
	}

	public function price(
	) {
		return ($this->isAtomic())
			? $this->getBooksPrice() * $this->getDiscount()
			: $this->totalSumOfSubpacks();
	}

	public function totalSumOfSubpacks(
	) {
		$total = 0;
		foreach ($this->subpacks as $subpack) {
			$total += $subpack->price();
		}
		return $total;
	}

	private function getBooksPrice(
	) {
		$price = 0;
		foreach ($this->books as $book) {
			$price += $book->price();
		}
		return $price;
	}

	private function getDiscount(
	) {
		$discounts = array(
			0 => 0,
			1 => 1,
			2 => 0.95,
			3 => 0.9,
			4 => 0.8,
			5 => 0.75
		);
		return $discounts[$this->numberOfDifferentBooks()];
	}

	private function numberOfDifferentBooks(
	) {
		return count(array_unique($this->books));
	}

	public function numberOfBooks(
	) {
		return count($this->books);
	}

	public function __toString(
	) {
		return "Pack {" . implode(", ", $this->books) . "}";
	}

	public function isAtomic(
	) {
		return ($this->numberOfBooks() == $this->numberOfDifferentBooks());
	}

}
