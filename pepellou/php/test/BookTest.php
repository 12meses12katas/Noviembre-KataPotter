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

	/**
	 * @dataProvider all_valid_books
	 */
	public function test_a_pack_of_one_book_costs_eight_euro(
		$bookName
	) {
		$aPack = new Pack(new Book($bookName));
		$this->assertEquals(8, $aPack->price());
	}

	public function test_two_books_5_percent_discount(
	) {
		$aBook = new Book(FIRST_BOOK);
		$anotherBook = new Book(SECOND_BOOK);
		$aPack = new Pack($aBook, $anotherBook);
		$this->assertEquals(8 * 2 * 0.95, $aPack->price());
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

