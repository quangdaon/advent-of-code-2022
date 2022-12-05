export const parseInstructions = (instructions) => {
  const parts = instructions.split(' ');
  return {
    amount: parseInt(parts[1]),
    from: parseInt(parts[3]),
    to: parseInt(parts[5]),
  };
};

export const parseStacks = (drawing) => {
  const [stackLabels, ...rows] = drawing
    .split('\n')
    .filter((e) => e.trim())
    .reverse();

  const stacks = {};

  for (const row of rows) {
    let lastIndexChecked = -1;
    do {
      lastIndexChecked = row.indexOf('[', lastIndexChecked + 1);
      const keyIndex = lastIndexChecked + 1;
      const stackLabel = stackLabels[keyIndex];
      const letter = row[keyIndex];

      if (lastIndexChecked < 0) break;

      if (!stacks[stackLabel]) stacks[stackLabel] = [];

      stacks[stackLabel].push(letter);
    } while (lastIndexChecked > -1);
  }

  return stacks;
};

export const executeInstruction = (stacks, instruction) => {
  const { amount, from, to } = instruction;
  const source = stacks[from];
  const destination = stacks[to];

  let movesRemaining = amount;

  while (movesRemaining > 0) {
    destination.push(source.pop());
    movesRemaining--;
  }
};

export const getTops = (stacks) => {
  let stringResult = '';
  for (const key of Object.keys(stacks).sort()) {
    const stack = stacks[key];
    stringResult += stack[stack.length - 1];
  }

  return stringResult;
};

export const processPart1Solution = (input) => {
  const [stacksDrawing, instructionsText] = input
    .split(/(\r?\n){2}/)
    .filter((e) => e.trim());
  const stacks = parseStacks(stacksDrawing);
  const instructions = instructionsText
    .split(/\r?\n/)
    .map((e) => parseInstructions(e));

  for (const instruction of instructions) {
    executeInstruction(stacks, instruction);
  }

  return getTops(stacks);
};

export const processPart2Solution = (input) => {
  return 'XYZ';
};
