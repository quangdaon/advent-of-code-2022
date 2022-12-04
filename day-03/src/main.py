from src.functions import *
import os.path

INPUT_PATH = os.path.join(os.path.dirname(__file__), '../inputs/input.txt')

if __name__ == '__main__':
  with open(INPUT_PATH) as input_file:
    input_txt = input_file.read()

    part_1_result = process_part_1_solution(input_txt)
    print("Solution for Part 1: " + str(part_1_result))

    part_2_result = process_part_2_solution(input_txt)
    print("Solution for Part 2: " + str(part_2_result))