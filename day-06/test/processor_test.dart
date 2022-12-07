import 'dart:io';
import 'package:program/processor.dart';
import 'package:test/test.dart';

void main() {
  group('stringHasRepeatingCharacter', () {
    test('identifies repeated character', () {
      expect(true, stringHasRepeatingCharacter('aa'));
      expect(true, stringHasRepeatingCharacter('abca'));
      expect(true, stringHasRepeatingCharacter('abcdefghh'));
    });

    test('identifies nonrepeating strings', () {
      expect(false, stringHasRepeatingCharacter('pz'));
      expect(false, stringHasRepeatingCharacter('abcd'));
    });
  });

  group('solutions', () {
    var expectedResults = {
      'mjqjpqmgbljsphdztnvjfqwrcgsmlb': 7,
      'bvwbjplbgvbhsrlpgdmjqwftvncz': 5,
      'nppdvjthqldpwncqszvftbrmjlhg': 6,
      'nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg': 10,
      'zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw': 11
    };

    expectedResults.forEach((input, expected) {
      test('returns correct solution for part 1 sample', () {
        var result = processPart1Result(input);
        expect(result, expected);
      });
    });
  });
}
