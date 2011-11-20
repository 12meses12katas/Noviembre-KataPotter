<?php

include_once 'src/Book.php';

class BookTest extends PHPUnit_Framework_TestCase {
	
	public function test_there_are_five_different_books(
	) {
		$book1 = new Book(FIRST_BOOK);
		$book2 = new Book(SECOND_BOOK);
		$book3 = new Book(THIRD_BOOK);
		$book4 = new Book(FOURTH_BOOK);
		$book5 = new Book(FIFTH_BOOK);
		$this->assertNotEquals($book1, $book2);
		$this->assertNotEquals($book3, $book4);
		$this->assertNotEquals($book5, $book2);
		$this->assertEquals(new Book(SECOND_BOOK), $book2);
	}

	/**
	 * @expectedException NoSuchBook
	 */
	public function test_there_are_only_those_books(
	) {
		$unexisting_title = "Harry Potter finally dies";
		new Book($unexisting_title);
	}

	/**
	 * @dataProvider all_valid_books
	 */
	public function test_one_book_costs_eight_euro(
		$bookName
	) {
		$aBook = new Book($bookName);
		$this->assertEquals(8, $aBook->price());
	}

	public function simple_discounts_examples(
	) {
		return array(
			"one single book" => array(
				new Pack(
					new Book(FIRST_BOOK)
				), 
				1
			),
			"two books" => array(
				new Pack(
					new Book(FIRST_BOOK), 
					new Book(SECOND_BOOK)
				), 
				0.95
			),
			"three books" => array(
				new Pack(
					new Book(FIRST_BOOK), 
					new Book(SECOND_BOOK),
					new Book(THIRD_BOOK)
				), 
				0.9
			),
			"four books" => array(
				new Pack(
					new Book(FIRST_BOOK), 
					new Book(SECOND_BOOK),
					new Book(THIRD_BOOK),
					new Book(FOURTH_BOOK)
				), 
				0.8
			),
			"five books" => array(
				new Pack(
					new Book(FIRST_BOOK), 
					new Book(SECOND_BOOK),
					new Book(THIRD_BOOK),
					new Book(FOURTH_BOOK),
					new Book(FIFTH_BOOK)
				), 
				0.75
			),
		);
	}

	/**
	 * @dataProvider simple_discounts_examples
	*/
	public function test_simple_discounts(
		$pack,
		$discount
	) {
		$numberOfBooks = $pack->numberOfBooks();
		$this->assertEquals(8 * $numberOfBooks * $discount, $pack->price());
	}

	public function all_valid_books(
	) {
		return array(
			"first book"  => array(FIRST_BOOK),
			"second book" => array(SECOND_BOOK),
			"third book"  => array(THIRD_BOOK),
			"fourth book" => array(FOURTH_BOOK),
			"fifth book"  => array(FIFTH_BOOK)
		);
	}

}

