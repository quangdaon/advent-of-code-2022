import { processPart1Solution } from '../src/functions.js';
import fs from 'fs';
const readFile = fs.promises.readFile;

describe('solutions', () => {
  const INPUT_FILENAME = './inputs/input.sample.txt';
  let input;

  beforeEach(async () => {
    input = await readFile(INPUT_FILENAME, 'utf-8');
  });

  xit('returns correct solution for part 1', () => {
    const result = processPart1Solution(input);
    expect(result).toBe('CMZ');
  });

  xit('returns correct solution for part 2', () => {
    const result = processPart2Solution(input);
    expect(result).toBe('TBD');
  });
});
