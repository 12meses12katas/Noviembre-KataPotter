function kataPotterTest() {}
registerTestSuite(kataPotterTest);

kataPotterTest.prototype.testBasics = function() {
    expectThat(kataPotter.price([])         , equals(0));
    expectThat(kataPotter.price([0])        , equals(8));
    expectThat(kataPotter.price([1])        , equals(8));
    expectThat(kataPotter.price([2])        , equals(8));
    expectThat(kataPotter.price([0, 0])     , equals(8 * 2));
    expectThat(kataPotter.price([1, 1, 1])  , equals(8 * 3));
}

kataPotterTest.prototype.testSimpleDiscounts = function () {
    expectThat(kataPotter.price([0, 1])         , equals(8 * 2 * 0.95));
    expectThat(kataPotter.price([0, 1, 2])      , equals(8 * 3 * 0.9));
    expectThat(kataPotter.price([0, 1, 2, 3])   , equals(8 * 4 * 0.8));
    expectThat(kataPotter.price([0, 1, 2, 3, 4]), equals(8 * 5 * 0.75));
}

kataPotterTest.prototype.testSeveralDiscounts = function() {
    expectThat(kataPotter.price([0, 0, 1])          , equals(8 + (8 * 2 * 0.95)));
    expectThat(kataPotter.price([0, 0, 1, 1])       , equals(2 * (8 * 2 * 0.95)));
    expectThat(kataPotter.price([0, 0, 1, 2, 2, 3]) , equals((8 * 4 * 0.8) + (8 * 2 * 0.95)));
    expectThat(kataPotter.price([0, 1, 1, 2, 3, 4]) , equals(8 + (8 * 5 * 0.75)));
}

kataPotterTest.prototype.testEdgeCases = function() {
    expectThat(kataPotter.price([0, 0, 1, 1, 2, 2, 3, 4]), equals(2 * (8 * 4 * 0.8)));
}