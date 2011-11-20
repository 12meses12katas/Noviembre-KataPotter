<?php

define ("FIRST_BOOK",  1);
define ("SECOND_BOOK", 2);
define ("THIRD_BOOK",  3);
define ("FOURTH_BOOK", 4);
define ("FIFTH_BOOK",  5);

class NoSuchBook extends Exception {}

class Book {

	private $number;

	public function __construct(
		$book_number
	) {
		$this->number = $book_number;
		if (!$this->exists())
			throw new NoSuchBook;
	}

	private function exists(
	) {
		return ($this->number >= FIRST_BOOK && $this->number <= FIFTH_BOOK);
	}

}
