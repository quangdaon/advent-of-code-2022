from src.functions import *
import unittest
import os.path

SAMPLE_INPUT_PATH = os.path.join(os.path.dirname(__file__), '../inputs/input.sample.txt')

class TestProcessorMethods(unittest.TestCase):
  def setUp(self):
    pass

  def test_find_duplicate_item(self):
    self.assertEqual('w', find_duplicate_item('ww'))
    self.assertEqual('N', find_duplicate_item('fgNiNp'))
    self.assertEqual('r', find_duplicate_item('rijLlesr'))

  def test_find_common_item(self):
    self.assertEqual('z', find_common_item([
      'qazwsxedcr',
      'fvTqbyhNzU',
      'JzUIkOan'
    ]))

  def test_get_item_priority(self):
    self.assertEqual(1, get_item_priority('a'))
    self.assertEqual(2, get_item_priority('b'))
    self.assertEqual(27, get_item_priority('A'))
    self.assertEqual(31, get_item_priority('E'))

  def test_divide_list(self):
    self.assertEqual([[1], [1], [1]], divide_list([1, 1, 1], 1))
    self.assertEqual([[1, 1], [1, 1], [1, 1]], divide_list([1, 1, 1, 1, 1, 1], 2))
    self.assertEqual([['a', 'rt', 'SdwW'], ['ert', 's', 'uSfd']], 
      divide_list(['a', 'rt', 'SdwW', 'ert', 's', 'uSfd'], 3))
  
  def test_process_part_1_solution(self):
    with open(SAMPLE_INPUT_PATH) as input_file:
      input_txt = input_file.read()
      result = process_part_1_solution(input_txt)
      self.assertEqual(157, result)
  
  def test_process_part_2_solution(self):
    with open(SAMPLE_INPUT_PATH) as input_file:
      input_txt = input_file.read()
      result = process_part_2_solution(input_txt)
      self.assertEqual(70, result)

if __name__ == '__main__':
  unittest.main()
