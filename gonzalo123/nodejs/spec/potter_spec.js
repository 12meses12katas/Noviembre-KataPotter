(function() {
  var Potter, potter;
  Potter = require('../potter').Potter;
  potter = new Potter;
  describe('jasmine-node', function() {
    it('testBasics', function() {
      expect(potter.price([])).toEqual(0);
      expect(potter.price([0])).toEqual(8);
      expect(potter.price([1])).toEqual(8);
      expect(potter.price([2])).toEqual(8);
      expect(potter.price([3])).toEqual(8);
      expect(potter.price([4])).toEqual(8);
      expect(potter.price([0, 0])).toEqual(8 * 2);
      return expect(potter.price([1, 1, 1])).toEqual(8 * 3);
    });
    it('testSimpleDiscounts', function() {
      expect(potter.price([0, 1])).toEqual(8 * 2 * 0.95);
      expect(potter.price([0, 2, 4])).toEqual(8 * 3 * 0.9);
      expect(potter.price([0, 1, 2, 4])).toEqual(8 * 4 * 0.8);
      return expect(potter.price([0, 1, 2, 3, 4])).toEqual(8 * 5 * 0.75);
    });
    it('testSeveralDiscounts', function() {
      expect(potter.price([0, 0, 1])).toEqual(8 + (8 * 2 * 0.95));
      expect(potter.price([0, 0, 1, 1])).toEqual(2 * (8 * 2 * 0.95));
      expect(potter.price([0, 0, 1, 2, 2, 3])).toEqual((8 * 4 * 0.8) + (8 * 2 * 0.95));
      return expect(potter.price([0, 1, 1, 2, 3, 4])).toEqual(8 + (8 * 5 * 0.75));
    });
    return it('testEdgeCases', function() {
      expect(potter.price([0, 0, 1, 1, 2, 2, 3, 4])).toEqual(2 * (8 * 4 * 0.8));
      return expect(potter.price([0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4])).toEqual(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8));
    });
  });
}).call(this);
