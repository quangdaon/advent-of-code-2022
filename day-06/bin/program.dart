import 'dart:io';
import 'package:program/processor.dart' as processor;

void main(List<String> arguments) {
  File file = new File('./inputs/input.txt');
  Future<String> futureContent = file.readAsString();

  futureContent.then((inputContent) {
    int result1 = processor.processPart1Result(inputContent);
    print('Solution to Part 1: ${result1}');

    int result2 = processor.processPart2Result(inputContent);
    print('Solution to Part 2: ${result2}');
  });
}
