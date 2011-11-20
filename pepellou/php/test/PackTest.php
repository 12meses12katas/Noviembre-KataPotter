<?php

include_once 'src/Book.php';

class PackTest extends PHPUnit_Framework_TestCase {

	/**
	 * @dataProvider atomic_packs
	 */
	public function test_atomic(
		$atomicPack
	) {
		$this->assertTrue($atomicPack->isAtomic());
	}

	public function atomic_packs(
	) {
		$book1 = new Book(Book::$FIRST);
		$book2 = new Book(Book::$SECOND);
		$book3 = new Book(Book::$THIRD);
		$book4 = new Book(Book::$FOURTH);
		$book5 = new Book(Book::$FIFTH);
		return array(
			"sample 1" => array(new Pack($book1)),
			"sample 2" => array(new Pack($book1, $book2)),
			"sample 3" => array(new Pack($book2, $book3, $book4)),
			"sample 4" => array(new Pack($book1, $book2, $book3, $book4, $book5))
		);
	}

	/**
	 * @dataProvider nonatomic_packs
	 */
	public function test_nonatomic(
		$nonatomicPack
	) {
		$this->assertFalse($nonatomicPack->isAtomic());
	}

	public function nonatomic_packs(
	) {
		$book1 = new Book(Book::$FIRST);
		$book2 = new Book(Book::$SECOND);
		$book3 = new Book(Book::$THIRD);
		$book4 = new Book(Book::$FOURTH);
		$book5 = new Book(Book::$FIFTH);
		return array(
			"sample 1" => array(new Pack($book1, $book1)),
			"sample 2" => array(new Pack($book1, $book2, $book1)),
			"sample 3" => array(new Pack($book2, $book3, $book2, $book3)),
			"sample 4" => array(new Pack($book1, $book2, $book3, $book4, $book1))
		);
	}

}
