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
		if (!$this->exists($book_number))
			throw new NoSuchBook;
		$this->number = $book_number;
	}

	private function exists(
		$number
	) {
		return ($number >= FIRST_BOOK && $number <= FIFTH_BOOK);
	}

}
