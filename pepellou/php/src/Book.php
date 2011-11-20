<?php

class NoSuchBook extends Exception {}

class Book {

	private $number;

	public function __construct(
		$book_number
	) {
		if ($book_number <= 0 || $book_number > 5)
			throw new NoSuchBook;
		$this->number = $book_number;
	}

}
