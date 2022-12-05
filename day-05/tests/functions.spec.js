import {
  executeInstructionByCrate,
  executeInstructionByStack,
  getTops,
  parseInstructions,
  parseStacks,
  processPart1Solution,
  processPart2Solution,
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

describe('executeInstructionByCrate', () => {
  it('moves single letter instruction', () => {
    const stacks = {
      1: ['A', 'B', 'C'],
      2: ['D', 'E'],
    };

    executeInstructionByCrate(stacks, { amount: 1, from: 1, to: 2 });

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

    executeInstructionByCrate(stacks, { amount: 2, from: 1, to: 2 });

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

    executeInstructionByCrate(stacks, { amount: 2, from: 3, to: 1 });

    expect(stacks).toEqual({
      1: ['A', 'B', 'C', 'D', 'I', 'H'],
      2: ['E', 'F'],
      3: ['G'],
    });
  });
});

describe('executeInstructionByStack', () => {
  it('moves single letter instruction', () => {
    const stacks = {
      1: ['A', 'B', 'C'],
      2: ['D', 'E'],
    };

    executeInstructionByStack(stacks, { amount: 1, from: 1, to: 2 });

    expect(stacks).toEqual({
      1: ['A', 'B'],
      2: ['D', 'E', 'C'],
    });
  });

  it('maintains order for multiple letter instruction', () => {
    const stacks = {
      1: ['A', 'B', 'C', 'D'],
      2: ['E', 'F'],
    };

    executeInstructionByStack(stacks, { amount: 2, from: 1, to: 2 });

    expect(stacks).toEqual({
      1: ['A', 'B'],
      2: ['E', 'F', 'C', 'D'],
    });
  });

  it('jumps stacks', () => {
    const stacks = {
      1: ['A', 'B', 'C', 'D'],
      2: ['E', 'F'],
      3: ['G', 'H', 'I'],
    };

    executeInstructionByStack(stacks, { amount: 2, from: 3, to: 1 });

    expect(stacks).toEqual({
      1: ['A', 'B', 'C', 'D', 'H', 'I'],
      2: ['E', 'F'],
      3: ['G'],
    });
  });

  it('moves larger stacks', () => {
    const stacks = {
      1: ['A', 'B', 'C', 'D'],
      2: ['E', 'F'],
      3: ['G', 'H', 'I', 'J', 'K'],
    };

    executeInstructionByStack(stacks, { amount: 3, from: 3, to: 2 });

    expect(stacks).toEqual({
      1: ['A', 'B', 'C', 'D'],
      2: ['E', 'F', 'I', 'J', 'K'],
      3: ['G', 'H'],
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

  it('returns correct solution for part 2 sample', () => {
    const result = processPart2Solution(input);
    expect(result).toBe('MCD');
  });
});
