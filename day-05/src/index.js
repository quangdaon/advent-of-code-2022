import fs from 'fs';
const readFile = fs.promises.readFile;
import { processPart1Solution, processPart2Solution } from './functions.js';
const INPUT_FILENAME = './inputs/input.txt';

(async function main() {
  const input = await readFile(INPUT_FILENAME, 'utf-8');

  const part1Result = processPart1Solution(input);
  console.log(`Solution to part 1: ${part1Result}`);

  const part2Result = processPart2Solution(input);
  console.log(`Solution to part 2: ${part2Result}`);
})();
