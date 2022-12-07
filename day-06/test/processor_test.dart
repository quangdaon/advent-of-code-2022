import 'dart:io';
import 'package:program/processor.dart';
import 'package:test/test.dart';

void main() {
  group('solutions', () {
    var expectedResults = {
      'mjqjpqmgbljsphdztnvjfqwrcgsmlb': 7,
      'nppdvjthqldpwncqszvftbrmjlhg': 5,
      'bvwbjplbgvbhsrlpgdmjqwftvncz': 6,
      'nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg': 10,
      'zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw': 10
    };

    expectedResults.forEach((input, expected) {
      test('returns correct solution for part 1 sample', () {
        var result = processPart1Result(input);
        expect(result, expected);
      });
    });
  });
}
