function isPrime(number) {
  if (number < 2) {
    return false;
  }

  var sqrt = Math.sqrt(number);
  var divisors = Array.from({ length: sqrt }, function (_, i) { return i + 2; });

  return divisors.every(function (divisor) { return number % divisor !== 0; });
}

function findPrimes(start, end) {
  var primes = [];

  for (var i = start; i <= end; i++) {
    if (isPrime(i)) {
      primes.push(i);
    }
  }

  return primes;
}

function sumPrimes(primes) {
  return primes.reduce(function (sum, prime) { return sum + prime; }, 0);
}

function main() {
  var primes = findPrimes(1, 1000);
  var sum = sumPrimes(primes);

  return sum;
}

console.log(main());
