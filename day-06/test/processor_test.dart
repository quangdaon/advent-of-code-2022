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

  group('endOfFirstNonRepeatingSequence', () {
    test('return correct output for buffer size 3', () {
      expect(3, endOfFirstNonRepeatingSequence('abc', 3));
      expect(4, endOfFirstNonRepeatingSequence('aabc', 3));
      expect(6, endOfFirstNonRepeatingSequence('ababas', 3));
    });

    test('return correct output for buffer size 6', () {
      expect(6, endOfFirstNonRepeatingSequence('abcdef', 6));
      expect(7, endOfFirstNonRepeatingSequence('aabcdef', 6));
      expect(9, endOfFirstNonRepeatingSequence('abcdabcefg', 6));
    });

    test('returns -1 if unmatchable', () {
      expect(-1, endOfFirstNonRepeatingSequence('aaaaaaaaaaaa', 3));
      expect(-1, endOfFirstNonRepeatingSequence('aaaaaaaaaaaa', 6));
    });
  });

  group('solutions', () {
    var expectedResults = {
      'mjqjpqmgbljsphdztnvjfqwrcgsmlb': [7, 19],
      'bvwbjplbgvbhsrlpgdmjqwftvncz': [5, 23],
      'nppdvjthqldpwncqszvftbrmjlhg': [6, 23],
      'nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg': [10, 29],
      'zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw': [11, 26]
    };

    expectedResults.forEach((input, expectations) {
      test('returns correct solution for part 1 sample', () {
        var result = processPart1Result(input);
        expect(result, expectations[0]);
      });
    });

    expectedResults.forEach((input, expectations) {
      test('returns correct solution for part 2 sample', () {
        var result = processPart2Result(input);
        expect(result, expectations[1]);
      });
    });
  });
}
