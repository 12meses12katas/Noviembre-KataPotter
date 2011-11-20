<?php

define ("FIRST_BOOK",  "Harry Potter and the Philosopher's Stone");
define ("SECOND_BOOK", "Harry Potter and the Chamber of Secrets");
define ("THIRD_BOOK",  "Harry Potter and the Prisoner of Azkaban");
define ("FOURTH_BOOK", "Harry Potter and the Goblet of Fire");
define ("FIFTH_BOOK",  "Harry Potter and the Order of the Phoenix");

class NoSuchBook extends Exception {}

class Book {

	private static $known_books = array(
		FIRST_BOOK,
		SECOND_BOOK,
		THIRD_BOOK,
		FOURTH_BOOK,
		FIFTH_BOOK
	);

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
		return (in_array($this->name, self::$known_books));
	}

	public function price(
	) {
		return 8;
	}

}
