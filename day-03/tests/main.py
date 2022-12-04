from src.functions import *
import unittest
import os.path

SAMPLE_INPUT_PATH = os.path.join(os.path.dirname(__file__), '../inputs/input.sample.txt')

class TestProcessorMethods(unittest.TestCase):
  def setUp(self):
    pass
  
  def test_process_part_1_solution(self):
    with open(SAMPLE_INPUT_PATH) as input_file:
      input_txt = input_file.read()
      result = process_part_1_solution(input_txt)
      self.assertEqual(157, result)

if __name__ == '__main__':
  unittest.main()
