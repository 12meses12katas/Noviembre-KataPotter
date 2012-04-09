Array.prototype.each = function (callable) {
  var l = this.length;
  if (typeof callable != "function")
    throw new TypeError();
  for (var idx = 0; idx < l; idx++)
    callable(this[idx], idx, this)
};
Array.prototype.first = function (callable) {
  var len = this.length;
  if (null == callable)
    return this[0];
  if (typeof callable != "function")
    throw new TypeError();
  for (var idx = 0; idx < len; idx++)
    if (callable(this[idx], idx, this))
      return this[idx];
};
Array.prototype.find = function (callable) {
  var results = [];
  var len = this.length;
  if (typeof callable != "function")
    throw new TypeError();
  for (var idx = 0; idx < len; idx++)
    if (callable(this[idx], idx, this))
      results.push(this[idx]);
  return results;
};
Array.prototype.sum = function (callable) {
  var result = 0;
  var len = this.length;
  if (typeof callable != "function")
    throw new TypeError();
  for (var idx = 0; idx < len; idx++)
    result += callable(this[idx], idx, this);
  return result;
};
Array.prototype.contains = function (it) {
  return this.indexOf(it) != -1;
};
Array.prototype.isEmpty = function () {
  return this.length == 0;
}