<?php

include_once 'src/Book.php';

class BookTest extends PHPUnit_Framework_TestCase {
	
	public function test_there_are_five_different_books(
	) {
		$book1 = new Book(1);
		$book2 = new Book(2);
		$book3 = new Book(3);
		$book4 = new Book(4);
		$book5 = new Book(5);
		$this->assertNotEquals($book1, $book2);
		$this->assertNotEquals($book3, $book4);
		$this->assertNotEquals($book5, $book2);
		$this->assertEquals(new Book(2), $book2);
	}

	public function unexisting_books(
	) {
		return array(
			"negative" => array(-1),
			"zero" => array(0),
			"too great" => array(6)
		);
	}

	/**
	 * @dataProvider unexisting_books
	 * @expectedException NoSuchBook
	 */
	public function test_there_are_only_those_books(
		$book_number
	) {
		new Book($book_number);
	}

}

