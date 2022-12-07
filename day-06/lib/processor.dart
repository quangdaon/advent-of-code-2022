bool stringHasRepeatingCharacter(String str) {
  for(int i = 0; i < str.length; i++) {
    if(str.lastIndexOf(str[i]) > i) return true;
  }
  return false;
}

int endOfFirstNonRepeatingSequence(String input, int bufferSize) {
  int pointer = bufferSize;

  while(pointer <= input.length) {
    var check = input.substring(pointer - bufferSize, pointer);
    if(!stringHasRepeatingCharacter(check)) {
      return pointer;
    }
    pointer++;
  }

  return -1;
}

int processPart1Result(String input) {
  return endOfFirstNonRepeatingSequence(input, 4);
}

int processPart2Result(String input) {
  return endOfFirstNonRepeatingSequence(input, 14);
}
