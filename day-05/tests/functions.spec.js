import {
  executeInstruction,
  getTops,
  parseInstructions,
  parseStacks,
  processPart1Solution,
} from '../src/functions.js';
import fs from 'fs';
const readFile = fs.promises.readFile;

describe('parseInstructions', () => {
  it('parses single-digit instructions', () => {
    const instructions = parseInstructions('move 3 from 1 to 5');
    expect(instructions).toEqual({
      amount: 3,
      from: 1,
      to: 5,
    });
  });

  it('parses multi-digit instructions', () => {
    const instructions = parseInstructions('move 45 from 12 to 92');
    expect(instructions).toEqual({
      amount: 45,
      from: 12,
      to: 92,
    });
  });
});

describe('parseStacks', () => {
  it('parses stacks from sample input', () => {
    const drawing = `
    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 
    `;

    const result = parseStacks(drawing);

    expect(result).toEqual({
      1: ['Z', 'N'],
      2: ['M', 'C', 'D'],
      3: ['P'],
    });
  });
});

describe('executeInstruction', () => {
  it('moves single letter instruction', () => {
    const stacks = {
      1: ['A', 'B', 'C'],
      2: ['D', 'E'],
    };

    executeInstruction(stacks, { amount: 1, from: 1, to: 2 });

    expect(stacks).toEqual({
      1: ['A', 'B'],
      2: ['D', 'E', 'C'],
    });
  });

  it('inverts multiple letter instruction', () => {
    const stacks = {
      1: ['A', 'B', 'C', 'D'],
      2: ['E', 'F'],
    };

    executeInstruction(stacks, { amount: 2, from: 1, to: 2 });

    expect(stacks).toEqual({
      1: ['A', 'B'],
      2: ['E', 'F', 'D', 'C'],
    });
  });

  it('jumps stacks', () => {
    const stacks = {
      1: ['A', 'B', 'C', 'D'],
      2: ['E', 'F'],
      3: ['G', 'H', 'I'],
    };

    executeInstruction(stacks, { amount: 2, from: 3, to: 1 });

    expect(stacks).toEqual({
      1: ['A', 'B', 'C', 'D', 'I', 'H'],
      2: ['E', 'F'],
      3: ['G'],
    });
  });
});

describe('getTops', () => {
  it('gets top crates in single string', () => {
    const result = getTops({
      1: ['A', 'B'],
      2: ['C', 'D', 'E'],
      3: ['F', 'G'],
    });

    expect(result).toBe('BEG');
  });
});

describe('solutions', () => {
  const INPUT_FILENAME = './inputs/input.sample.txt';
  let input;

  beforeEach(async () => {
    input = await readFile(INPUT_FILENAME, 'utf-8');
  });

  it('returns correct solution for part 1 sample', () => {
    const result = processPart1Solution(input);
    expect(result).toBe('CMZ');
  });

  xit('returns correct solution for part 2 sample', () => {
    const result = processPart2Solution(input);
    expect(result).toBe('TBD');
  });
});
